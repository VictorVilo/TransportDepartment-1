package com.samson;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditCar
 */
@WebServlet("/EditCar")
public class EditCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the details of the bus
				int id  = Integer.parseInt(request.getParameter("id"));
				String number_plate = request.getParameter("number_plate");
				String insurance_company = request.getParameter("insurance_company");
				int premium = Integer.parseInt(request.getParameter("premium"));
				String condition = request.getParameter("condition");
				String purchase_date = request.getParameter("purchase_date");
				String assigned_driver = request.getParameter("assigned_driver");
				
				//check if there are any empty fields
				if(number_plate.equals("") || insurance_company.equals("") || premium < 0 || condition.equals("") || purchase_date.equals(""))  {
					request.setAttribute("message1", "Failed to update record! Invalid details or empty fields");
					request.getRequestDispatcher("viewCars.jsp").forward(request, response);
				} else{
				
					//create an instance of DAOHandler
					DAOHandler editCar = new DAOHandler();
					int result = editCar.edit_car(id, number_plate, insurance_company, premium, condition, purchase_date, assigned_driver);
					
					if(result > 0){
						request.setAttribute("message", "Record updated successfuly");
						request.getRequestDispatcher("viewCars.jsp").forward(request, response);
					} else {
						request.setAttribute("message1", "Failed to update record");
						request.getRequestDispatcher("viewCars.jsp").forward(request, response);
					}
				}
					
	}

}
