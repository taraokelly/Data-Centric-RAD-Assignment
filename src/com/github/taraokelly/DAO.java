package com.github.taraokelly;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
/*
 * Tara O'Kelly - G00322214
 * DAO (Data Access Object) class, responsible for the communication with the database.
 */
public class DAO {
	private DataSource mysqlDS;
	//Constructor(s)
	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/garage";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}//constructor	
	
	  //Add Methods.
	  //Adds a new data from objects to the database.
	  //Returns an error if unsuccessful. 
	public String addManufacturer(Manufacturer m) throws SQLException {
		//Get connection  and create prepared statement
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("INSERT INTO manufacturer values(?, ?, ?)");	
		//pass variables from he manufacturer object into the prepared statement and execute
		try{
			myStmt.setString(1, m.getManu_code());
			myStmt.setString(2, m.getManu_name());
			myStmt.setString(3, m.getManu_details());

			myStmt.executeUpdate();
		}
		catch(SQLException e){
			return "Error: " + e;
		}
		catch(Exception e){
			return "Error: " + e;
		}
		return "Successful";
	}//addManufacturer
	public String addModel(Model m) throws SQLException {
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("INSERT INTO model values(?, ?, ?, ?)");
		
		
		try{
			myStmt.setString(1, m.getManu_code());
			myStmt.setString(2, m.getModel_code());
			myStmt.setString(3, m.getModel_name());
			myStmt.setString(4, m.getModel_desc());

			myStmt.executeUpdate();
		}
		catch(SQLException e){
			return "Error: " + e;
		}
		catch(Exception e){
			return "Error: " + e;
		}
		return "Successful";
	}//addModel
	public String addVehicle(Vehicle v) throws SQLException {
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("INSERT INTO vehicle values(?, ?, ?, ?, ?, ?, ?)");
		try{
			myStmt.setString(1, v.getReg());
			myStmt.setString(2, v.getManu_code());
			myStmt.setString(3, v.getModel_code());
			myStmt.setInt(4, v.getMileage());
			myStmt.setDouble(5, v.getPrice());
			myStmt.setString(6, v.getColour());
			myStmt.setString(7, v.getFuel());

			myStmt.executeUpdate();
		}
		catch(SQLException e){
			return "Error: " + e;
		}
		catch(Exception e){
			return "Error: " + e;
		}
		return "Successful";
	}//addVehicle
	//Update Method.
	//Updates existing manufacturer data in the database.
	//Returns error if unsuccessful.
	public String updateManufacturer(Manufacturer m) throws SQLException {
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("update manufacturer set manu_name=?, manu_details=? where manu_code=?");
		try{
			myStmt.setString(1, m.getManu_name());
			myStmt.setString(2, m.getManu_details());
			myStmt.setString(3, m.getManu_code());

			myStmt.executeUpdate();
		}
		catch(SQLException e){
			return "Error: " + e;
		}
		catch(Exception e){
			return "Error: " + e;
		}
		return "Successful";
	}//updateManufacturer
	//Delete method.
	//Removes a row of manufacturer data from the database.
	//Returns error if unsuccessful.
	public String deleteManufacturer(Manufacturer m) throws SQLException {
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("delete from manufacturer where manu_code = ? AND manu_name = ? AND manu_details = ?");
		try{
			myStmt.setString(1, m.getManu_code());
			myStmt.setString(2, m.getManu_name());
			myStmt.setString(3, m.getManu_details());

			myStmt.executeUpdate();
		}
		catch(SQLException e){
			System.out.println(e);
			return "Error: " + e;
		}
		catch(Exception e){
			System.out.println(e);
			return "Error: " + e;
		}
		return "Successful";
	}//deleteManufacturer
	//Methods for populating data tables.
	//Creates and populates an array of specified object.
	//Uses Statement as opposed to PrepareStatement as there is no specific conditions. 
	public ArrayList<Manufacturer> getManufacturerDetails() throws Exception {
		ArrayList<Manufacturer> manufacturers = new ArrayList<>();
		Connection conn = mysqlDS.getConnection();
		Statement myStmt = conn.createStatement();
		String query = "select * from manufacturer";

		ResultSet rs = myStmt.executeQuery(query);

		while (rs.next()) {
			String mCode = rs.getString("manu_code");
			String mName = rs.getString("manu_name");
			String mDetails = rs.getString("manu_details");
			manufacturers.add(new Manufacturer(mCode, mName, mDetails));
		}
		return manufacturers;
	}//getManufacturerDetails
	public ArrayList<Model> getModelDetails() throws Exception {
		ArrayList<Model> models = new ArrayList<>();
		Connection conn = mysqlDS.getConnection();
		Statement myStmt = conn.createStatement();
		String query = "select * from model";

		ResultSet rs = myStmt.executeQuery(query);

		while (rs.next()) {
			String manCode = rs.getString("manu_code");
			String mCode = rs.getString("model_code");
			String mName = rs.getString("model_name");
			String mDesc = rs.getString("model_desc");
			models.add(new Model(manCode, mCode, mName, mDesc));
		}
		return models;
	}//getModelDetails
	public ArrayList<Vehicle> getVehicleDetails() throws Exception {
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		Connection conn = mysqlDS.getConnection();
		Statement myStmt = conn.createStatement();
		String query = "select * from vehicle";

		ResultSet rs = myStmt.executeQuery(query);

		while (rs.next()) {
			String reg = rs.getString("reg");
			String manCode = rs.getString("manu_code");
			String mCode = rs.getString("model_code");
			Integer mileage = rs.getInt("mileage");
			Double price = rs.getDouble("price");
			String colour = rs.getString("colour");
			String fuel = rs.getString("fuel");
			vehicles.add(new Vehicle(reg, manCode, mCode, mileage, price, colour, fuel));
		}	
		return vehicles;
	}//getVehicleDetails
	//Search Method - Returns the an arraylist results of the search.
	//Uses a Prepared Statement to query the distinct searches.
	public ArrayList<Vehicle> getSearchDetails(Search s) throws Exception {
		ArrayList<Vehicle> vehicles = new ArrayList<>();
	    //If price is not defined in search, set to any number above or equal to zero	
		if(s.getPrice()==null || s.getPrice()==0){
			s.setPrice((0.00));
			s.setOperator(">=");
		}
		//If colour isn't defined, query all colours.
		if(s.getColour().equals(null) || s.getColour().equals(""))
			s.setColour("%");
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select v.reg, man.manu_code, man.manu_name, m.model_code, m.model_name, v.mileage, v.price, v.colour, v.fuel from manufacturer man Inner Join vehicle v on man.manu_code = v.manu_code Inner Join model m on v.model_code=m.model_code WHERE price "+s.getOperator() + " ? and colour like ? AND fuel = ?");
		
		myStmt.setDouble(1, s.getPrice());
		myStmt.setString(2, s.getColour());
		myStmt.setString(3, s.getFuel());
		
		ResultSet rs = myStmt.executeQuery();

		while (rs.next()) {
			String reg = rs.getString("reg");
			String manCode = rs.getString("manu_code");
			String manName = rs.getString("manu_name");
			String mCode = rs.getString("model_code");
			String mName = rs.getString("model_name");
			Integer mileage = rs.getInt("mileage");
			Double price = rs.getDouble("price");
			String colour = rs.getString("colour");
			String fuel = rs.getString("fuel");
			vehicles.add(new Vehicle(reg, manCode, manName, mCode, mName, mileage, price, colour, fuel));
		}	
		return vehicles;
	}//getSearchDetails
	//Full Vehicle Details Method.
	//Populates single object with all correlating data in database.
	public Vehicle getVehicleFullDetails(Vehicle v) throws Exception {
		Vehicle vehicleDetails = null;
		Connection conn = mysqlDS.getConnection();
		PreparedStatement myStmt = conn.prepareStatement("select v.reg, man.manu_code, man.manu_name, man.manu_details, m.model_code, m.model_name, m.model_desc, v.mileage, v.price, v.colour, v.fuel from manufacturer man Inner Join vehicle v on man.manu_code = v.manu_code Inner Join model m on v.model_code=m.model_code where v.reg = ?");

		myStmt.setString(1, v.getReg());
		
		ResultSet rs = myStmt.executeQuery();
		
		while (rs.next()) {
			String reg = rs.getString("reg");
			String manCode = rs.getString("manu_code");
			String manName = rs.getString("manu_name");
			String manDetails = rs.getString("manu_details");
			String mCode = rs.getString("model_code");
			String mName = rs.getString("model_name");
			String mDesc = rs.getString("model_desc");
			Integer mileage = rs.getInt("mileage");
			Double price = rs.getDouble("price");
			String colour = rs.getString("colour");
			String fuel = rs.getString("fuel");
			vehicleDetails = new Vehicle(reg, manCode, manName, manDetails, mCode, mName, mDesc, mileage, price, colour, fuel);
		}
		return vehicleDetails;
	}//getVehicleFullDetails
}
