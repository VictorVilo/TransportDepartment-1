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
 * Servlet implementation class EditDriver
 */
@WebServlet("/EditDriver")
public class EditDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String emp_id = request.getParameter("emp_id");
		int id_no = Integer.parseInt(request.getParameter("id_no"));
		String password = request.getParameter("password");
		
		
		try{
			Connection con = DAOHandler.getConnection();
			
			//a query for inserting data to the database
			String query5 =  "UPDATE drivers SET first_name=?, last_name=?, emp_id=?, id_no=?, password=?WHERE id='"+id+"'";
			//prepare a statement
			PreparedStatement st = con.prepareStatement(query5);
			
			//set the data
			st.setString(1, first_name);
			st.setString(2, last_name);
			st.setString(3, emp_id);
			st.setInt(4, id_no);
			st.setString(5, password);
			
			
			//execute the query and return the number of rows affected
			int rows = st.executeUpdate();
			if(rows > 0){
				request.setAttribute("message", "Record updated successfully!");
				request.getRequestDispatcher("viewDrivers.jsp").forward(request, response);
			} else {
				request.setAttribute("message1", "Failed to update record!");
				request.getRequestDispatcher("viewDrivers.jsp").forward(request, response);
			}
		} catch(Exception ex){
			System.out.println(ex);
		}
	}

}
