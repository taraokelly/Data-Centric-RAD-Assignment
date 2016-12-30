package com.github.taraokelly;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
/*
 * Tara O'Kelly - G00322214
 * Model Controller.
 * Handles Communication to the dao.
 */
@ManagedBean
public class ModelController {
	//Variables
	private ArrayList<Model> models;
	private DAO dao;
	//Constructor
	 public ModelController() {
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Getters, setters & methods
	public ArrayList<Model> getModels() {
		return models;
	}

	public void loadModels() throws Exception {
		models = dao.getModelDetails();
	}
	public void addModel(Model m) throws IOException, SQLException {
		
		String result;
		result = dao.addModel(m);
		if(result.equals("Successful")){
		FacesContext.getCurrentInstance().getExternalContext().redirect("manageModel.xhtml");
		}
		else{
			FacesMessage message = new FacesMessage(result);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}

	} //addModel
}
