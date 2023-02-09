package com.budgetApp.service;

import java.util.List;

import com.budgetApp.entity.Budget;

public interface BudgetService {
   Budget addbudget(Budget budget) throws Exception; 
   public List<Budget> showBudget() throws Exception;
}
