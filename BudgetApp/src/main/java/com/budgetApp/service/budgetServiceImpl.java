package com.budgetApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgetApp.entity.Budget;
import com.budgetApp.repository.BudgetRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class budgetServiceImpl implements BudgetService{

	@Autowired
	private BudgetRepo budgetRepo;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Budget addbudget(Budget budget) throws Exception {
		
		Budget b= new Budget();
		b.setTotalMoney(budget.getTotalMoney());
		
		return budgetRepo.save(b);
	}

	@Override
	public List<Budget> showBudget() throws Exception {
		List<Budget> b= budgetRepo.findAll();
		if(b.isEmpty()) throw new Exception("Budget.is_empty");
		return b;
		
	}

}
