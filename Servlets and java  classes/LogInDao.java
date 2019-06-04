package com.samson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/*
 * This class helps to check if the user credentials are already in the 
 * database, after signing up
 */
public class LogInDao {
	
	//the database details
	private String url="jdbc:mysql://localhost:3306/group_project";
	private String dbname = "root";
	private String pass = "";
	
	//check if the user is admin
	@SuppressWarnings("static-access")
	public boolean checkAdmin(String username, String password){
		try{
			DAOHandler dao = new DAOHandler();
			Connection con = dao.getConnection();
			String query2 = "select * from users where username=? and password=?";
			PreparedStatement stmt = con.prepareStatement(query2);
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			ResultSet rs1 = stmt.executeQuery();
			
			if(rs1.next()){
				
				return true;
			}
		} catch(Exception ex){
			System.out.println(ex);
		}
		
		return false;
		
	}
	
	//a method that returns a boolean value depending to the user details entered
	
	public boolean checkNormalUser(String username, String password){
		
		try {
			//load the drivers
			Class.forName("com.mysql.jdbc.Driver");
			//create a connection
			Connection con = DriverManager.getConnection(url, dbname, pass);
			//create a statement
			
			//database query
			String query1 = "select * from users where username=? and password=?";
			//load the mysql database drivers
			PreparedStatement st = con.prepareStatement(query1);
			//bind the values
			st.setString(1,username);
			st.setString(2,password);
			
			ResultSet rs = st.executeQuery();
			//check if there are any results
			if(rs.next()){
				return true;
			}
			
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		return false;
		

	}
	
	//a method that returns a boolean value depending to the user details entered
	
		public boolean checkDriver(String username, String password){
			
			try {
				//load the drivers
				Class.forName("com.mysql.jdbc.Driver");
				//create a connection
				Connection con = DriverManager.getConnection(url, dbname, pass);
				//create a statement
				
				//database query
				String query2 = "select * from drivers where emp_id=? and password=?";
				//load the mysql database drivers
				PreparedStatement st = con.prepareStatement(query2);
				//bind the values
				st.setString(1,username);
				st.setString(2,password);
				
				ResultSet rs = st.executeQuery();
				//check if there are any results
				if(rs.next()){
					return true;
				}
				
				st.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}
			
			return false;
			

		}
	
	@SuppressWarnings("static-access")
	public void insertData(String firstname, String lastname, String uname,
			String password, String email){
		
	
			//check if there is a user with that username
			Connection con;
			try {
				
					DAOHandler dao = new DAOHandler();
					con = dao.getConnection();
					dao.createTable();
					//insert the user details into the database
					con = DriverManager.getConnection(url, dbname, pass);
					String query3 = "insert into users(firstname, lastname, username, password, email) VALUES (?,?,?,?,?)";
					//prepare a statement
					PreparedStatement st1 = con.prepareStatement(query3);
					st1.setString(1, firstname);
					st1.setString(2, lastname);
					st1.setString(3, uname);
					st1.setString(4, password);
					st1.setString(5, email);
					
					//run the update and insert the data to the database
					int rows = st1.executeUpdate();
					
					System.out.println(rows + "affected");
					
					st1.close();
					con.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			
	}
	
	
}
