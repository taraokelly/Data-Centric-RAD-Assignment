package com.github.taraokelly;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
/*
 * Tara O'Kelly - G00322214
 * Vehicle Details Controller.
 * Handles Communication to the dao.
 * Bean is Session Scoped and therefore the data should remain
 * intact until HTTP Session is terminated or times out.
 */
@ManagedBean
@SessionScoped
public class VehicleDetailsController {
	//Variables
	private Vehicle vehicleDetails;	
	private DAO dao;
	//Constructor
		public VehicleDetailsController() {
			try {
				dao = new DAO();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//Getters, setters & methods
		public Vehicle getVehicleDetails() {
			return vehicleDetails;
		}
			
		public void setVehicleDetails(Vehicle v) throws Exception {
			this.vehicleDetails = dao.getVehicleFullDetails(v);
		}
		
		public String vehicleDetailsData() throws Exception{
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String,Object> params = externalContext.getRequestMap();
			params.put("vDetails", vehicleDetails);
			return "viewVehicleDetails";
		}//updateMaunufacturerData 
}
