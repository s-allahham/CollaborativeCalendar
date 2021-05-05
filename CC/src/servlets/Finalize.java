package servlets;


import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import application.CCApplication;
import dbadapter.Appointment;




/**
 * Class responsible for displaying the appointments in progress
 * 
 * @author swe.uni-due.de
 *
 */
public class Finalize extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("navtype", "finalizeAppointment");
		request.setAttribute("pagetitle", "finalize Appointment");
		
		// Catch error if there is no page contained in the request
		String action = (request.getParameter("action") == null) ? "" : request.getParameter("action");	
		ArrayList<Appointment> appointments =null;
			
			// Call application to request the results
			try {
				new CCApplication();
				appointments= CCApplication.getInstance().getFinalizedAppointments();
				
				// Dispatch results to template engine
				request.setAttribute("Fappointments", appointments);
				request.getRequestDispatcher("/templates/finalizedappointment.ftl").forward(request, response);

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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		doGet(request, response);
	}

}

