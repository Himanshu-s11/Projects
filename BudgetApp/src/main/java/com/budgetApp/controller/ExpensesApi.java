package com.budgetApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.budgetApp.entity.Expences;
import com.budgetApp.service.ExpencesService;

@RestController
@RequestMapping("expenses")
public class ExpensesApi {

	@Autowired
	private ExpencesService expencesService;
	@Autowired
	private Environment environment;
	
	@GetMapping("/view")
	public ResponseEntity<List<Expences>> viewAll(){
		try {
			List<Expences> exp= expencesService.viewAll();
			return new ResponseEntity<List<Expences>>(exp,HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(e.getMessage()));
		}
	}
	
	
//
//	@PostMapping("/addBalance")
//	public ResponseEntity<Expences> addBalance(@RequestBody Expences expences){
//		try {
//			Expences expen= expencesService.addBalance(expences);
//			return new ResponseEntity<Expences>(expen,HttpStatus.CREATED);
//		}catch (Exception e) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
//		}
//	}
	
	@PostMapping("/add")
	public ResponseEntity<Expences> addExpences(@RequestBody Expences expences){
		try {
			Expences expen= expencesService.addExpences(expences);
			return new ResponseEntity<Expences>(expen,HttpStatus.CREATED);
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
	}
	
}
