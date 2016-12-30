package com.github.taraokelly;

import javax.faces.bean.ManagedBean;
/*
 * Tara O'Kelly - G00322214
 * Manufacturer class.
 * Contains Search data entered by user.
 */
@ManagedBean
public class Search {
	//Variables
	private String operator;
	private Double price;
	private String colour;
	private String fuel;
	//Constructor(s)
	public Search() {
		super();
	}
	public Search(String operator, Double price, String colour, String fuel) {
		super();
		this.operator = operator;
		this.price = price;
		this.colour = colour;
		this.fuel = fuel;
	}
	//Getters and setters
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		if(operator.equals("l"))
			operator="<";
		else
			operator=">";
		this.operator = operator;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
}
