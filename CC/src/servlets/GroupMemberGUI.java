package servlets;

import java.io.IOException;
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
import dbadapter.Group;

/**
 * Class responsible for the GUI of the guest
 * 
 * @author swe.uni-due.de
 *
 */
public class GroupMemberGUI extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("navtype", "AccessGroup");
		request.setAttribute("pagetitle", "Access Group");
		
		// Catch error if there is no page contained in the request
		String action = (request.getParameter("action") == null) ? "" : request.getParameter("action");
		
		try {
					request.getRequestDispatcher("/templates/defaultWebpageG.ftl").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}

			}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("navtype", "AccessGroup");

		// Check whether the call is AccessGroup or not
		if (request.getParameter("action").equals("AccessGroup")) {
			request.setAttribute("pagetitle", "Access Group");
			ArrayList<Group> Calendar =null;
			
			// Call application to request the results
			try {
				new CCApplication();
				Calendar= CCApplication.getInstance().AccessCalendar(request.getParameter("memberslist"));
				
				// Dispatch results to template engine
				request.setAttribute("Calendar", Calendar);
				request.getRequestDispatcher("/templates/offersRepresentation.ftl").forward(request, response);

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
			
		}  else
			doGet(request, response);
	}
}
		