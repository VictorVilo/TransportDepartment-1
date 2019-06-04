package com.samson;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteLocalVehicle
 */
@WebServlet("/DeleteCar")
public class DeleteCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the id of the bus record you want to delete
				String id = request.getParameter("id");
				//convert the id to integer type
				int car_id = Integer.parseInt(id);
				
				//the database details
				String url="jdbc:mysql://localhost:3306/group_project";
				String dbname = "root";
				String pass = "";
				
				try{
					
					//load the drivers
					Class.forName("com.mysql.jdbc.Driver");
					//create a connection
					Connection con = DriverManager.getConnection(url, dbname, pass);
					
					//a query for inserting data to the database
					String query1 = "DELETE FROM cars WHERE id='"+car_id+"'";
					
					//prepare a statement
					PreparedStatement st = con.prepareStatement(query1);
					
					
					//execute the query and return the number of rows affected
					int rows = st.executeUpdate();
					
					System.out.println(rows + "affected");
					
					st.close();
					con.close();
					
					response.sendRedirect("viewCars.jsp");
				}
				catch(Exception e){
					e.printStackTrace();
				}
	}

}
