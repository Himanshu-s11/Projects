package com.budgetApp.entity;

import java.util.Objects;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.ManyToMany;


@Entity
public class Expences {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer expId;
	private String expence;
	private float cost;
	private float balance;
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name = "budget",
//	         joinColumns =  @JoinColumn(name="id"),
//             inverseJoinColumns = @JoinColumn(name="exp_id")
//			)
//	private Budget budget;
	
	public Expences() {
		// TODO Auto-generated constructor stub
	}
public Expences(Integer expId, String expence, float cost, float balance) {
	super();
	this.expId = expId;
	this.expence = expence;
	this.cost = cost;
	this.balance = balance;
}
public Integer getExpId() {
	return expId;
}
public void setExpId(Integer expId) {
	this.expId = expId;
}
public String getExpence() {
	return expence;
}
public void setExpence(String expence) {
	this.expence = expence;
}
public float getCost() {
	return cost;
}
public void setCost(float cost) {
	this.cost = cost;
}
public float getBalance() {
	return balance;
}
public void setBalance(float balance) {
	this.balance = balance;
}
	
}
