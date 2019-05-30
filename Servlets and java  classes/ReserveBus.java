package com.samson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class ReserveBus
 */
@WebServlet("/ReserveBus")
public class ReserveBus extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//get the id of the bus to reserve
		String id = request.getParameter("id");
		
		//get the date to reserve the bus
		String date1 = request.getParameter("trip_date");
		
		System.out.println(date1);
		//first get the details of the bus to reserve
		try{
			DAOHandler dao = new DAOHandler();
			Connection con = dao.getConnection();
			//create table if it does not exist
			dao.createTable();
			
			String query1 = "SELECT * FROM buses where id='"+id+"'";
			PreparedStatement stmt = con.prepareStatement(query1);
			ResultSet rs = stmt.executeQuery();
			System.out.println("I have executed the first query");
			
			PrintWriter out = response.getWriter();
			while(rs.next()){
				String plate_no = rs.getString("number_plate");
				int capacity = rs.getInt("capacity");
				//first check if there is another trip scheduled so
				String query2 = "SELECT * FROM reserved_buses WHERE number_plate=? and reserved_date=?";
				PreparedStatement stmt2 = con.prepareStatement(query2);
				System.out.println("I have executed the  query 2");
				stmt2.setString(1, plate_no);
				stmt2.setString(2, date1);
				ResultSet rs2 = stmt2.executeQuery();
				if(rs2.next()){
					
					out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
					out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){");
					out.println("swal('Oops', 'The bus is scheduled for that day!', 'error')");
					out.println("});");
					out.println("</script>");
					
					RequestDispatcher rd = request.getRequestDispatcher("ScheduleBus.jsp");
					rd.include(request, response);
					
					request.setAttribute("message", "The bus is scheduled for that day, ");
				} else{
					//insert the data to the reserved vehicles
					String query3 = "INSERT INTO reserved_buses(number_plate, capacity, reserved_date) VALUES(?,?,?)";
					PreparedStatement stmt3 = con.prepareStatement(query3);
					stmt3.setString(1, plate_no);
					stmt3.setInt(2, capacity);
					stmt3.setString(3, date1);
					int row = stmt3.executeUpdate();
					System.out.println(row +" affected");
				}
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}

}
