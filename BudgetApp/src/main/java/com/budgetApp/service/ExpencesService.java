package com.budgetApp.service;

import java.util.List;

import com.budgetApp.entity.Expences;

public interface ExpencesService {

	public List<Expences> viewAll() throws Exception;
//	Expences addBalance(Expences expences) throws Exception;
    Expences addExpences(Expences expences) throws Exception;
}
