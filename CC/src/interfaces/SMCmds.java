package interfaces;

import java.util.ArrayList;

import datatypes.AddressData;
import dbadapter.Appointment;

/**
 * Interface that provides all methods for the interaction with the staffmember.
 * 
 * @author swe.uni-due.de
 *
 */
public interface SMCmds {

	public void insertNewAppointment(String name, String startTime, String endTime,String appointmentDescription, AddressData destination);

	public ArrayList<Appointment> getAppointments();
	public void getAppointments(String name);
	
	public ArrayList<Appointment> getFinalizedAppointments();

}
