package com.budgetApp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.budgetApp.entity.Budget;
import com.budgetApp.entity.Expences;
import com.budgetApp.repository.BudgetRepo;
import com.budgetApp.repository.ExpencesRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ExpencesServiceImpl implements ExpencesService {

	@Autowired
	private ExpencesRepo expencesRepo;
	
	@Autowired
	private BudgetRepo budgetRepo;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Expences> viewAll() throws Exception {
		List<Expences> expences= expencesRepo.findAll();
		if(expences.isEmpty()) throw new Exception("Expenses.no_is_available");
		return expences;
	}

	@Override
	public Expences addExpences(Expences expences) throws Exception {
		float f=0;
		float tMoney=0;
		 float c=0;
	 String query="SELECT total_money FROM budget_db.budget";
		 List<Budget> exp =jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Budget.class));
         Budget b= new Budget();
		 Expences e= new Expences();
		 c= c+expences.getCost();
		 
		for (Budget ex : exp) {
			f=ex.getTotalMoney();
			System.out.println("total budet" + f);
	}
       if(f>=c) {
		  e.setExpence(expences.getExpence());
		  e.setCost(expences.getCost());
		   tMoney=f-c;
		  System.out.println("total money" + tMoney);
		  e.setBalance(tMoney);
		  b.setTotalMoney(tMoney);
		  budgetRepo.save(b);
       }else {
    	   throw new Exception("ExpensesService.LESS_AMOUNT");
       }
		return expencesRepo.save(e);
	}

	
}
