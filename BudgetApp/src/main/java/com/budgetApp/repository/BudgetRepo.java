package com.budgetApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budgetApp.entity.Budget;

public interface BudgetRepo extends JpaRepository<Budget, Integer> {
 
}
