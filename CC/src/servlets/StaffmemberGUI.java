package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.CCApplication;
import datatypes.AddressData;
import datatypes.MemberData;
import dbadapter.Appointment;

public class StaffmemberGUI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * doGet contains the insertOffer form
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		// set pagetitle und navtype
		request.setAttribute("navtype", "AddAppointment");
		request.setAttribute("pagetitle", "Add Appointment");

		// Dispatch request to template engine
		try {
			request.getRequestDispatcher("/templates/defaultWebpageS.ftl").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Contains handling of insertOffer call
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("navtype", "AddAppointment");

		// Check whether the call is insertOffer or not
		if (request.getParameter("action").equals("AddAppointment")) {

						// Append parameter of request
						String name = (String) request.getParameter("name");
						String startTime = (String) request.getParameter("startTime");
						String endTime = (String) request.getParameter("endTime");
						String description = (String) request.getParameter("description");
						String street = (String) request.getParameter("street");
						String town = (String) request.getParameter("town");
						
						



			// Call application to insert Appointment
			new CCApplication().insertNewAppointment(name,startTime, endTime, description, new AddressData(street, town));
			// Dispatch message to template engine
			try {
				request.setAttribute("pagetitle", "Add Appointment");
				request.setAttribute("message", "New Appointment successfully stored in the database.");
				request.getRequestDispatcher("/templates/showConfirmMake.ftl").forward(request, response);

			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			// Call doGet if request is not equal to AddAppointment
		} else
			doGet(request, response);

	}
}