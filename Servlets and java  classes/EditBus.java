package com.samson;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditBus
 */
@WebServlet("/EditBus")
public class EditBus extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the details of the bus
		int id = Integer.parseInt(request.getParameter("id"));
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		String number_plate = request.getParameter("number_plate");
		String insurance_company = request.getParameter("insurance_company");
		int premium = Integer.parseInt(request.getParameter("premium"));
		String condition = request.getParameter("condition");
		String purchase_date = request.getParameter("purchase_date");
		
		
		//check if there are any empty fields
				if(number_plate.equals("") || insurance_company.equals("") || premium < 0 || condition.equals("") || purchase_date.equals("") || capacity <30)  {
					request.setAttribute("message1", "Failed to update record! Invalid details or empty fields");
					request.getRequestDispatcher("Busses.jsp").forward(request, response);
				} else{
				
					DAOHandler editBusDao = new DAOHandler();
					
					int result = editBusDao.edit_bus_details(id, capacity, number_plate, insurance_company, premium, condition, purchase_date);
					if(result > 0){
						request.setAttribute("message", "Record updated successfuly");
						request.getRequestDispatcher("Busses.jsp").forward(request, response);
					} else {
						request.setAttribute("message1", "Failed to update record");
						request.getRequestDispatcher("Busses.jsp").forward(request, response);
					}
				}
		
	
	}

}
