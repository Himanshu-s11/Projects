package com.budgetApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.budgetApp.entity.Budget;
import com.budgetApp.service.BudgetService;

@RestController
@RequestMapping("BudgetApi")
public class BudgetApi {

	@Autowired
	private BudgetService budgetService;
	
	@GetMapping("/show")
	public ResponseEntity <List<Budget>> showBudget(){
		try {
			List<Budget> bd= budgetService.showBudget();
			return new ResponseEntity<List<Budget>>(bd,HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<Budget> addBudget(@RequestBody Budget b){
		try {
			Budget bd= budgetService.addbudget(b);
			return new ResponseEntity<Budget>(bd,HttpStatus.CREATED);
		}catch(Exception e) {
			throw new ErrorResponseException(HttpStatus.BAD_REQUEST) ;
		}
		
		
	}
	
}
