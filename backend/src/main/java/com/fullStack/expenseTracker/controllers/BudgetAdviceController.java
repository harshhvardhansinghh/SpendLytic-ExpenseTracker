package com.fullStack.expenseTracker.controllers;

import com.fullStack.expenseTracker.dto.reponses.BudgetAdviceResponseDto;
import com.fullStack.expenseTracker.dto.requests.BudgetAdviceRequestDto;
import com.fullStack.expenseTracker.services.BudgetAdviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mywallet/ai")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class BudgetAdviceController {

    private final BudgetAdviceService budgetAdviceService;

    @PostMapping("/advice")
    public BudgetAdviceResponseDto getAdvice(@RequestBody BudgetAdviceRequestDto request) {
        return budgetAdviceService.getAdvice(request.getUserId());
    }
}