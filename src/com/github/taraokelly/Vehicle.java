package com.github.taraokelly;

import javax.faces.bean.ManagedBean;
/*
 * Tara O'Kelly - G00322214
 * Manufacturer class.
 * Holds Vehicle data.
 * Constructors for Vehicle, Full Vehicle Details, and Vehicle Search. 
 */
@ManagedBean
public class Vehicle {
	//Variables
	private String reg;
	private String manu_code;
	private String model_code;
	private Integer mileage;
	private Double price;
	private String colour;
	private String fuel;
	private String manu_name;
	private String manu_details;
	private String model_name;
	private String model_desc;
	//Constructor(s)
	public Vehicle(){
		
	}
	//Vehicle Details
	public Vehicle(String reg, String manu_code, String model_code, Integer mileage, Double price, String colour, String fuel){
		super();
		this.reg=reg;
		this.manu_code=manu_code;
		this.model_code=model_code;
		this.mileage=mileage;
		this.price=price;
		this.colour=colour;
		this.fuel=fuel;
	}
	//Full Vehicle Details
	public Vehicle(String reg, String manu_code, String manu_name, String model_code, String model_name, Integer mileage, Double price, String colour, String fuel){
		super();
		this.reg=reg;
		this.manu_code=manu_code;
		this.manu_name=manu_name;
		this.model_code=model_code;
		this.model_name=model_name;
		this.mileage=mileage;
		this.price=price;
		this.colour=colour;
		this.fuel=fuel;
	}
	//Search Details
	public Vehicle(String reg, String manu_code, String manu_name, String manu_details, String model_code, String model_name, String model_desc, Integer mileage, Double price, String colour, String fuel){
		super();
		this.reg=reg;
		this.manu_code=manu_code;
		this.manu_details=manu_details;
		this.manu_name=manu_name;
		this.model_code=model_code;
		this.model_name=model_name;
		this.model_desc=model_desc;
		this.mileage=mileage;
		this.price=price;
		this.colour=colour;
		this.fuel=fuel;
	}
	//Getters and setters
	public String getReg() {
		return reg;
	}
	public void setReg(String reg) {
		this.reg = reg;
	}
	public String getManu_code() {
		return manu_code;
	}
	public void setManu_code(String manu_code) {
		this.manu_code = manu_code;
	}
	public String getModel_code() {
		return model_code;
	}
	public void setModel_code(String model_code) {
		this.model_code = model_code;
	}
	public Integer getMileage() {
		return mileage;
	}
	public void setMileage(Integer mileage) {
		this.mileage = mileage;
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
	public String getManu_name() {
		return manu_name;
	}
	public void setManu_name(String manu_name) {
		this.manu_name = manu_name;
	}
	public String getManu_details() {
		return manu_details;
	}
	public void setManu_details(String manu_details) {
		this.manu_details = manu_details;
	}
	public String getModel_name() {
		return model_name;
	}
	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}
	public String getModel_desc() {
		return model_desc;
	}
	public void setModel_desc(String model_desc) {
		this.model_desc = model_desc;
	}

}
