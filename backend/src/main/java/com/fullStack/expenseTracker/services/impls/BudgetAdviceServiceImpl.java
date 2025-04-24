package com.fullStack.expenseTracker.services.impls;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fullStack.expenseTracker.dto.reponses.BudgetAdviceResponseDto;
import com.fullStack.expenseTracker.models.Transaction;
import com.fullStack.expenseTracker.repository.TransactionRepository;
import com.fullStack.expenseTracker.services.BudgetAdviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetAdviceServiceImpl implements BudgetAdviceService {

    private final TransactionRepository transactionRepository;

    @Override
    public BudgetAdviceResponseDto getAdvice(Long userId) {
        List<Transaction> transactions = transactionRepository.findByUserId(userId);

        if (transactions.isEmpty()) {
            return new BudgetAdviceResponseDto("No transactions found for the user.");
        }

        // Build the prompt
        StringBuilder prompt = new StringBuilder("Give me personalized budgeting suggestions based on these expenses:\n");
        for (Transaction txn : transactions) {
            prompt.append(String.format("- %s: ₹%.2f\n", txn.getDescription(), txn.getAmount()));
        }

        try {
            // Prepare the request
            URL url = new URL("http://localhost:11434/api/generate");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json");

            // Build JSON using ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            String jsonInputString = mapper.writeValueAsString(
                    new OllamaRequest("llama3", prompt.toString(), false)
            );

            // Debug: print payload
            System.out.println("Request Payload:\n" + jsonInputString);

            // Send request
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Parse response
            JsonNode node = mapper.readTree(con.getInputStream());
            String response = node.has("response") ? node.get("response").asText() : "Could not generate advice.";

            return new BudgetAdviceResponseDto(response);

        } catch (Exception e) {
            return new BudgetAdviceResponseDto("Error while fetching advice: " + e.getMessage());
        }
    }

    // Inner static class for the JSON body
    static class OllamaRequest {
        public String model;
        public String prompt;
        public boolean stream;

        public OllamaRequest(String model, String prompt, boolean stream) {
            this.model = model;
            this.prompt = prompt;
            this.stream = stream;
        }
    }
}
