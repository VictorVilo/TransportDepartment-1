package com.samson;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*
;/**
 * Servlet implementation class EditTrip
 */
@WebServlet("/EditTrip")
public class EditTrip extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the data from the form
		int id =Integer.parseInt(request.getParameter("id"));
		String destination = request.getParameter("destination");
		String departure_date = request.getParameter("departure_date"); 
		String return_date = request.getParameter("return_date");
		int passengers =Integer.parseInt(request.getParameter("passengers"));
		String faculty = request.getParameter("faculty");
		String department = request.getParameter("department");
		
		try{

		
		//check if there are any empty fields
		if(destination.equals("") || departure_date.equals("") || passengers < 0 || faculty.equals("") || department.equals("") || return_date.equals(""))  {
			request.setAttribute("message1", "Failed to update record! Invalid details or empty fields");
			request.getRequestDispatcher("scheduled_trips.jsp").forward(request, response);
		} else{
			
			DAOHandler dao = new DAOHandler();
			Connection con = dao.getConnection();
			String query = "UPDATE scheduled_trips set destination=?, departure_date=?, return_date=?, no_of_students=?, faculty=?, department=? where id = '"+id+"'";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, destination);
			stmt.setString(2, departure_date);
			stmt.setString(3, return_date);
			stmt.setInt(4, passengers);
			stmt.setString(5, faculty);
			stmt.setString(6, department);
			
			int result = stmt.executeUpdate();
			
			if(result > 0){
				request.setAttribute("message", "Record updated successfuly");
				request.getRequestDispatcher("scheduled_trips.jsp").forward(request, response);
			} else {
				request.setAttribute("message1", "Failed to update record");
				request.getRequestDispatcher("scheduled_trips.jsp").forward(request, response);
			}
		}
		} catch (Exception ex){
			System.out.println(ex);
		}
		
	}

}
