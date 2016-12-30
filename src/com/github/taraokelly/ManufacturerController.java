package com.github.taraokelly;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/*
 * Tara O'Kelly - G00322214
 * ManufacturerController class.
 * Handles Communication to the dao.
 * Bean is Session Scoped and therefore the data should remain
 * intact until HTTP Session is terminated or times out.
 */
@ManagedBean
@SessionScoped
public class ManufacturerController {
	//Variables
	private ArrayList<Manufacturer> manufacturers;
	private Manufacturer temp;
	private DAO dao;
	//Constructor
	public ManufacturerController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Getters, setters & methods
	public ArrayList<Manufacturer> getManufacturers() {
		return manufacturers;
	}

	public void loadManufacturers() throws Exception {
		manufacturers = dao.getManufacturerDetails();
	}
	
	public void addManufacturer(Manufacturer m) throws IOException, SQLException {
		
			String result;
			result = dao.addManufacturer(m);
			if(result.equals("Successful")){
			FacesContext.getCurrentInstance().getExternalContext().redirect("manageManufacturer.xhtml");
			}
			else{
				FacesMessage message = new FacesMessage(result);
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
	
		
	} //addManufacturer
	public void deleteManufacturer(Manufacturer m) throws IOException, SQLException {
		
		String result;
		result = dao.deleteManufacturer(m);
		if(result.equals("Successful")){
		FacesContext.getCurrentInstance().getExternalContext().redirect("manageManufacturer.xhtml");
		}
		else{
			FacesMessage message = new FacesMessage(result);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	
} //deleteManufacturer
	public String updateManufacturerData() throws Exception{
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		System.out.println("Here");
		Map<String,Object> params = externalContext.getRequestMap();
		params.put("test", temp);
		System.out.println(temp);
		return "updateManufacturer";
	}//updateMaunufacturerData 
	public void updateManufacturer(Manufacturer m) throws IOException, SQLException {	
		String result;
		result = dao.updateManufacturer(m);
		if(result.equals("Successful")){
		FacesContext.getCurrentInstance().getExternalContext().redirect("manageManufacturer.xhtml");
		}
		else{
			FacesMessage message = new FacesMessage(result);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	
} //deleteManufacturer
	public Manufacturer getTemp() {
		return temp;
	}
	public void setTemp(Manufacturer temp) {
		this.temp=temp;
	}
}
