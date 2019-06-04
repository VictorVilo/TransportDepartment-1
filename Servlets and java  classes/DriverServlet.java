package com.transport;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DriverServlet
 */
@WebServlet("/DriverServlet")
public class DriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String dateoftrip= request.getParameter("dateoftrip");
		int driverno= Integer.parseInt(request.getParameter("driverno"));
		String detailsofjourney= request.getParameter("detailsofjourney");
		int oildrawn = Integer.parseInt(request.getParameter("oildrawn"));
		int fueldrawn = Integer.parseInt(request.getParameter("fueldrawn"));
		int cashreceipt = Integer.parseInt(request.getParameter("cahsreceipt"));
		String timeout = request.getParameter("timeout");
		String timein = request.getParameter("timein");
		int begmileage = Integer.parseInt(request.getParameter("begmileage"));
		int endmileage = Integer.parseInt(request.getParameter("endmileage"));
		String defects = request.getParameter("defects");
		
		DriverDB db = new DriverDB();
		
		db.postdb(dateoftrip, driverno, detailsofjourney, oildrawn, fueldrawn, cashreceipt, timeout, timein, begmileage, endmileage, defects);
		
	}

}
