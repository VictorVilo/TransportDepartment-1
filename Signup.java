package com.samson;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//get the data from the form
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try{
			//check if there is user with that username
			DAOHandler dao = new DAOHandler();
			Connection con = dao.getConnection();
			dao.createTable();
			String query1 = "select * from users where username=?";
			PreparedStatement stmt = con.prepareStatement(query1);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				//send error message to the user
				request.setAttribute("message", "Username is already taken!");
				request.getRequestDispatcher("signUp.jsp").forward(request, response);
			} else{
			
			//create an object of LoginDao class
			LogInDao dao1 = new LogInDao();
			dao1.insertData(firstname, lastname, username, password, email);
			
			response.sendRedirect("signIn.jsp");
			
			stmt.close();
			con.close();
			}
		} catch(Exception ex){
			System.out.println(ex);
		}
	}

}
