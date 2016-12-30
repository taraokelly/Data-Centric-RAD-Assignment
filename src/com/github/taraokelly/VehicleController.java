package com.github.taraokelly;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
/*
 * Tara O'Kelly - G00322214
 * Vehicle Controller.
 * Handles Communication to the dao.
 * Bean is Session Scoped and therefore the data should remain
 * intact until HTTP Session is terminated or times out.
 */
@ManagedBean
@SessionScoped
public class VehicleController {
	//Variables
	private ArrayList<Vehicle> vehicles;
	private DAO dao;
	//Constructor
	public VehicleController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Getters, setters & methods
	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	public void loadVehicles() throws Exception {
		vehicles = dao.getVehicleDetails();
	}
	public void addVehicle(Vehicle v) throws IOException, SQLException {
		
		String result;
		result = dao.addVehicle(v);
		if(result.equals("Successful")){
		FacesContext.getCurrentInstance().getExternalContext().redirect("manageVehicle.xhtml");
		}
		else{
			FacesMessage message = new FacesMessage(result);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	} //addModel
}
