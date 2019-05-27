package com.samson;
/*
 * This class is used to handle all database requests apart from the 
 * log in and sign up databases tables
 */

import java.io.InputStream;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

public class DAOHandler {
	
	//the database details
	private String url="jdbc:mysql://localhost:3306/group_project";
	private String dbname = "root";
	private String pass = "";
		
		
		
		
		//a method that is used to insert data from the academic trip details to the database
		public void insert_academic_details(String destination, String departure_date, String return_date,
				int passengers, String faculty, String department, InputStream inputStream){
			
			try{
				
				//load the drivers
				Class.forName("com.mysql.jdbc.Driver");
				//create a connection
				Connection con = DriverManager.getConnection(url, dbname, pass);
				
				//a query for inserting data to the database
				String query1 = "INSERT INTO academic_booking(destination, departure_date, return_date, passengers, faculty, department, file_name) VALUES (?,?,?,?,?,?,?)";
				
				//prepare a statement
				PreparedStatement st = con.prepareStatement(query1);
				
				//set the data
				st.setString(1, destination);
				st.setString(2, departure_date);
				st.setString(3, return_date);
				st.setInt(4, passengers);
				st.setString(5, faculty);
				st.setString(6, department);
				st.setBlob(7, inputStream);
				
				//execute the query and return the number of rows affected
				int rows = st.executeUpdate();
				
				System.out.println(rows + "affected");
				
				st.close();
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
}

		public void register_driver(String first_name, String last_name, int id_no, String emp_id,
				String driving_licence){
			
			try{
				
				//load the drivers
				Class.forName("com.mysql.jdbc.Driver");
				//create a connection
				Connection con = DriverManager.getConnection(url, dbname, pass);
				
				//a query for inserting data to the database
				String query2 = "INSERT INTO drivers_details VALUES (?,?,?,?,?)";
				
				//prepare a statement
				PreparedStatement st = con.prepareStatement(query2);
				
				//set the data
				st.setString(1, first_name);
				st.setString(2, last_name);
				st.setInt(3, id_no);
				st.setString(4, emp_id);
				st.setString(5, driving_licence);
				
				//execute the query and return the number of rows affected
				int rows = st.executeUpdate();
				
				System.out.println(rows + "affected");
				
				st.close();
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		public void insert_bus_details(int capacity, String number_plate, String insurance_company,
				int premium, String condition, String purchase_date){
			
			try{
				
				//load the drivers
				Class.forName("com.mysql.jdbc.Driver");
				//create a connection
				Connection con = DriverManager.getConnection(url, dbname, pass);
				
				//a query for inserting data to the database
				String query3 = "INSERT INTO bus(capacity, number_plate, insurance_company, premium, bus_condition, purchase_date) VALUES (?,?,?,?,?,?)";
				
				//prepare a statement
				PreparedStatement st = con.prepareStatement(query3);
				
				//set the data
				st.setInt(1, capacity);
				st.setString(2, number_plate);
				st.setString(3, insurance_company);
				st.setInt(4, premium);
				st.setString(5, condition);
				st.setString(6, purchase_date);
				
				
				//execute the query and return the number of rows affected
				int rows = st.executeUpdate();
				System.out.println("what about the rows??");
				
				System.out.println(rows + "affected");
				
				st.close();
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public void edit_bus_details(int id, int capacity, String number_plate, String insurance_company,
				int premium, String condition, String purchase_date){
			
			try{
				
				//load the drivers
				Class.forName("com.mysql.jdbc.Driver");
				//create a connection
				Connection con = DriverManager.getConnection(url, dbname, pass);
				
				//a query for inserting data to the database
				String query3 = "update bus set capacity = ?, number_plate = ?, insurance_company = ?, premium = ?, bus_condition = ?, purchase_date = ? where id='"+id+"'";
				
				//prepare a statement
				PreparedStatement st = con.prepareStatement(query3);
				
				//set the data
				st.setInt(1, capacity);
				st.setString(2, number_plate);
				st.setString(3, insurance_company);
				st.setInt(4, premium);
				st.setString(5, condition);
				st.setString(6, purchase_date);
				
				
				//execute the query and return the number of rows affected
				int rows = st.executeUpdate();
				System.out.println("what about the rows??");
				
				System.out.println(rows + "affected");
				
				st.close();
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public void insert_local_bookings(String required_date, String return_date, String vehicle_type,
				String purpose){
			
			try{
				
				//load the drivers
				Class.forName("com.mysql.jdbc.Driver");
				//create a connection
				Connection con = DriverManager.getConnection(url, dbname, pass);
				
				//a query for inserting data to the database
				String query4 = "INSERT INTO local_bookings VALUES (?,?,?,?)";
				
				//prepare a statement
				PreparedStatement st = con.prepareStatement(query4);
				
				//set the data
				st.setString(1, required_date);
				st.setString(2, return_date);
				st.setString(3, vehicle_type);
				st.setString(4, purpose);
				
				//execute the query and return the number of rows affected
				int rows = st.executeUpdate();
				
				System.out.println(rows + "affected");
				
				st.close();
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
		public void insert_car(String number_plate, String insurance_company,
				int premium, String condition, String purchase_date, String assigned_driver){
			
			try{
				
				//load the drivers
				Class.forName("com.mysql.jdbc.Driver");
				//create a connection
				Connection con = DriverManager.getConnection(url, dbname, pass);
				
				//a query for inserting data to the database
				String query5 = "INSERT INTO cars(number_plate, insurance_company, premium, vehicle_condition, purchase_date, assigned_driver) VALUES (?,?,?,?,?,?)";
				//prepare a statement
				PreparedStatement st = con.prepareStatement(query5);
				
				//set the data
				st.setString(1, number_plate);
				st.setString(2, insurance_company);
				st.setInt(3, premium);
				st.setString(4, condition);
				st.setString(5, purchase_date);
				st.setString(6, assigned_driver);
				
				//execute the query and return the number of rows affected
				int rows = st.executeUpdate();
				
				System.out.println(rows + "affected");
				
				st.close();
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public void edit_car(int id, String number_plate, String insurance_company,
				int premium, String condition, String purchase_date, String assigned_driver){
			
			try{
				
				//load the drivers
				Class.forName("com.mysql.jdbc.Driver");
				//create a connection
				Connection con = DriverManager.getConnection(url, dbname, pass);
				
				//a query for inserting data to the database
				String query5 =  "UPDATE cars SET number_plate=?, insurance_company=?, premium=?, vehicle_condition=?, purchase_date=?, assigned_driver=? WHERE id='"+id+"'";
				//prepare a statement
				PreparedStatement st = con.prepareStatement(query5);
				
				//set the data
				st.setString(1, number_plate);
				st.setString(2, insurance_company);
				st.setInt(3, premium);
				st.setString(4, condition);
				st.setString(5, purchase_date);
				st.setString(6, assigned_driver);
				
				
				//execute the query and return the number of rows affected
				int rows = st.executeUpdate();
				
				System.out.println(rows + "affected");
				
				st.close();
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public void insert_lorry(String number_plate, String insurance_company,
				int premium, String condition, String purchase_date, String assigned_driver){
			
			try{
				
				//load the drivers
				Class.forName("com.mysql.jdbc.Driver");
				//create a connection
				Connection con = DriverManager.getConnection(url, dbname, pass);
				
				//a query for inserting data to the database
				String query5 = "INSERT INTO lorries(number_plate, insurance_company, premium, vehicle_condition, purchase_date, assigned_driver) VALUES (?,?,?,?,?,?)";
				//prepare a statement
				PreparedStatement st = con.prepareStatement(query5);
				
				//set the data
				st.setString(1, number_plate);
				st.setString(2, insurance_company);
				st.setInt(3, premium);
				st.setString(4, condition);
				st.setString(5, purchase_date);
				st.setString(6, assigned_driver);
				
				//execute the query and return the number of rows affected
				int rows = st.executeUpdate();
				
				System.out.println(rows + "affected");
				
				st.close();
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		public void edit_lorry(int id, String number_plate, String insurance_company,
				int premium, String condition, String purchase_date, String assigned_driver){
			
			try{
				
				//load the drivers
				Class.forName("com.mysql.jdbc.Driver");
				//create a connection
				Connection con = DriverManager.getConnection(url, dbname, pass);
				
				//a query for inserting data to the database
				String query5 =  "UPDATE lorries SET number_plate=?, insurance_company=?, premium=?, vehicle_condition=?, purchase_date=?, assigned_driver=? WHERE id='"+id+"'";
				//prepare a statement
				PreparedStatement st = con.prepareStatement(query5);
				
				//set the data
				st.setString(1, number_plate);
				st.setString(2, insurance_company);
				st.setInt(3, premium);
				st.setString(4, condition);
				st.setString(5, purchase_date);
				st.setString(6, assigned_driver);
				
				
				//execute the query and return the number of rows affected
				int rows = st.executeUpdate();
				
				System.out.println(rows + "affected");
				
				st.close();
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		public void insert_tractor(String number_plate, String insurance_company,
				int premium, String condition, String purchase_date, String assigned_driver){
			
			try{
				
				//load the drivers
				Class.forName("com.mysql.jdbc.Driver");
				//create a connection
				Connection con = DriverManager.getConnection(url, dbname, pass);
				
				//a query for inserting data to the database
				String query5 = "INSERT INTO tractors(number_plate, insurance_company, premium, vehicle_condition, purchase_date, assigned_driver) VALUES (?,?,?,?,?,?)";
				//prepare a statement
				PreparedStatement st = con.prepareStatement(query5);
				
				//set the data
				st.setString(1, number_plate);
				st.setString(2, insurance_company);
				st.setInt(3, premium);
				st.setString(4, condition);
				st.setString(5, purchase_date);
				st.setString(6, assigned_driver);
				
				//execute the query and return the number of rows affected
				int rows = st.executeUpdate();
				
				System.out.println(rows + "affected");
				
				st.close();
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public void edit_tractor(int id, String number_plate, String insurance_company,
				int premium, String condition, String purchase_date, String assigned_driver){
			
			try{
				
				//load the drivers
				Class.forName("com.mysql.jdbc.Driver");
				//create a connection
				Connection con = DriverManager.getConnection(url, dbname, pass);
				
				//a query for inserting data to the database
				String query5 =  "UPDATE tractors SET number_plate=?, insurance_company=?, premium=?, vehicle_condition=?, purchase_date=?, assigned_driver=? WHERE id='"+id+"'";
				//prepare a statement
				PreparedStatement st = con.prepareStatement(query5);
				
				//set the data
				st.setString(1, number_plate);
				st.setString(2, insurance_company);
				st.setInt(3, premium);
				st.setString(4, condition);
				st.setString(5, purchase_date);
				st.setString(6, assigned_driver);
				
				
				//execute the query and return the number of rows affected
				int rows = st.executeUpdate();
				
				System.out.println(rows + "affected");
				
				st.close();
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		/*
		 * A method for updating local vehicles  details from the edited form
		 */
		public void editLocalVehicle(int id, String number_plate, String insurance_company,
				int premium, String condition, String purchase_date, String assigned_driver){
			
			try{
				
				//load the drivers
				Class.forName("com.mysql.jdbc.Driver");
				//create a connection
				Connection con = DriverManager.getConnection(url, dbname, pass);
				
				//a query for inserting data to the database
				String query5 = "UPDATE  local_vehicles SET number_plate=?, insurance_company=?, premium=?, vehicle_condition=?, purchase_date=?, assigned_driver=? WHERE id='"+id+"'";
				//prepare a statement
				PreparedStatement st = con.prepareStatement(query5);
				
				//set the data
				st.setString(1, number_plate);
				st.setString(2, insurance_company);
				st.setInt(3, premium);
				st.setString(4, condition);
				st.setString(5, purchase_date);
				st.setString(6, assigned_driver);
				
				//execute the query and return the number of rows affected
				int rows = st.executeUpdate();
				
				System.out.println(rows + "affected");
				
				st.close();
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		
}

