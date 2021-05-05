package application;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import datatypes.AddressData;
import dbadapter.Appointment;
import dbadapter.Group;
import dbadapter.accessGroup;
import dbadapter.addAppointment;
import interfaces.GMCmds;
import interfaces.IAppointment;
import interfaces.IGroup;
import interfaces.SMCmds;


/**
 * This class contains the VRApplication which acts as the interface between all
 * components.
 * 
 * @author swe.uni-due.de
 *
 */



public class CCApplication implements GMCmds,SMCmds {

	private static CCApplication instance;

	/**
	 * Implementation of the Singleton pattern.
	 * 
	 * @return
	 */
	public static CCApplication getInstance() {
		if (instance == null) {
			instance = new CCApplication();
		}

		return instance;
	}


	
	@Override
	public ArrayList<Group> AccessCalendar(String memberslist) {
		ArrayList<Group> result = null;

		// Parse string attributes to correct datatype
		try {
		result = accessGroup.getInstance().CheckAccess(memberslist);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result; 
}
	
	
	
	


	@Override
	public void insertNewAppointment(String name,String startTime, String endTime,String appointmentDescription, AddressData destination) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = dateFormat.parse(startTime);
			long time = date.getTime();
			Timestamp startTimeSQL = new Timestamp(time);
			date = dateFormat.parse(endTime);
			time = date.getTime();
			Timestamp endTimeSQL = new Timestamp(time);
			addAppointment.getInstance().insertNewAppointment(name,startTimeSQL,endTimeSQL, appointmentDescription, destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return ap;
	}
	
	@Override
	public ArrayList<Appointment> getAppointments() {
		ArrayList<Appointment> result = null;
		
		try {
			
			result = addAppointment.getInstance().getAppointments();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; 
	}
	
	@Override
	public ArrayList<Appointment> getFinalizedAppointments() {
		ArrayList<Appointment> result = null;
		
		try {
			
			result = addAppointment.getInstance().getFinalizedAppointments();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; 
	}
	
	@Override
	public void getAppointments(String name) {
		
		try {
		 addAppointment.getInstance().getAppointments(name);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}

	