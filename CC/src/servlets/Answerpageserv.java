package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.CCApplication;
import datatypes.AddressData;
import datatypes.MemberData;
import dbadapter.Appointment;
import dbadapter.Configuration;
import dbadapter.Group;
import dbadapter.addAppointment;

/**
 * Class responsible for displaying the appointments in progress
 * 
 * @author swe.uni-due.de
 *
 */
public class Answerpageserv extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("navtype", "Answerapp");
		request.setAttribute("pagetitle", "Answer app");
		
		// Catch error if there is no page contained in the request
		String action = (request.getParameter("action") == null) ? "" : request.getParameter("action");	
		ArrayList<Appointment> appointments =null;
			
			// Call application to request the results
			try {
				new CCApplication();
				appointments= CCApplication.getInstance().getAppointments();
				
				// Dispatch results to template engine
				request.setAttribute("appointments", appointments);
				request.getRequestDispatcher("/templates/answerPage.ftl").forward(request, response);

			} catch (Exception e1) {
				try {
					request.setAttribute("errormessage", "Database error: please contact the administator");
					request.getRequestDispatcher("/templates/error.ftl").forward(request, response);
				} catch (Exception e) {
					request.setAttribute("errormessage", "System error: please contact the administrator");
					e.printStackTrace();
				}
				e1.printStackTrace();
			}
		
			
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("navtype", "Answerapp");

		// Check whether the call is AccessGroup or not
		if (request.getParameter("action").equals("participate")) {
			String appname = (String) request.getParameter("name");
			
				new CCApplication().getAppointments(appname);
				
				try {
					request.setAttribute("pagetitle", "Answer app");
					request.setAttribute("message", "participation Done Succeccfully");
					request.getRequestDispatcher("/templates/showConfirmMake.ftl").forward(request, response);

				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
				// Call doGet if request is not equal to AddAppointment
			} else
				doGet(request, response);

		}
	}
