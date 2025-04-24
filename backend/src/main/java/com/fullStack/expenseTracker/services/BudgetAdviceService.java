package com.fullStack.expenseTracker.services;

import com.fullStack.expenseTracker.dto.reponses.BudgetAdviceResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface BudgetAdviceService {
    BudgetAdviceResponseDto getAdvice(Long userId);
}
