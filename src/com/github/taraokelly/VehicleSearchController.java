package com.github.taraokelly;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
/*
 * Tara O'Kelly - G00322214
 * Vehicle Search Controller.
 * Handles Communication to the dao.
 * Bean is Session Scoped and therefore the data should remain
 * intact until HTTP Session is terminated or times out.
 */
@ManagedBean
@SessionScoped
public class VehicleSearchController {
	//Variables
	private ArrayList<Vehicle> searchResults;
	private DAO dao;
	//Constructor
	public VehicleSearchController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Getters, setters & methods
	public ArrayList<Vehicle> getSearchResults() {
		return searchResults;
	}
	public void setSearchResults(Search s) throws Exception {
		this.searchResults = dao.getSearchDetails(s);
	}
	public String vehicleSearchData() throws Exception{
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String,Object> params = externalContext.getRequestMap();
		params.put("sDetails", searchResults);
		return "searchVehicleResults";
	}//updateMaunufacturerData 
}
