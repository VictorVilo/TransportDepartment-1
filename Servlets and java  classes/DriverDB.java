package com.transport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DriverDB {
	
	String url="jdbc:mysql://localhost:3306/transportdepartment";
	String usernm="root";
	String pass="Kelvin@5257";
	
	
	public void postdb(String dateoftrip, int driverno, String detailsofjourney, int oildrawn, int fueldrawn, int cashreceipt, String timeout, String timein, int begmileage, int endmileage, String defects) {
	
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con= DriverManager.getConnection(url, usernm, pass);
			String query = "insert into drivertable values(?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement st= con.prepareStatement(query);
			
			st.setString(1, dateoftrip);
			st.setInt(2, driverno); /*Will be used as primary key*/
			st.setString(3, detailsofjourney);
			st.setInt(4, oildrawn);
			st.setInt(5, fueldrawn);
			st.setInt(6, cashreceipt);
			st.setString(7, timeout);
			st.setString(8, timein);
			st.setInt(9, begmileage);
			st.setInt(10, endmileage);
			st.setString(11, defects);
			
			
			
			int rows=st.executeUpdate();
			
			System.out.println(rows+"affected");
			
			st.close();
			con.close();
		
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}
		
	}

}
