package com.budgetApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.budgetApp.entity.Expences;

public interface ExpencesRepo extends JpaRepository<Expences, Integer>{
	
	//@Query("update budget_db.budget b set b.total_money=:totalMoney where b.id='1'")
//    @Modifying
//    public void updateExpances(float totalMoney) throws Exception; 
}
