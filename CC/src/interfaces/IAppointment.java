package interfaces;

import java.sql.Timestamp;
import java.util.ArrayList;

import datatypes.AddressData;
import datatypes.MemberData;

import dbadapter.Appointment;

/**
 * Interface for DBFacade to provide all necessary database function.
 * 
 * @author swe.uni-due.de
 *
 */
public interface IAppointment {

	public void insertNewAppointment(String name,Timestamp startTime, Timestamp endTime,String appointmentDescription, AddressData destination);
	public ArrayList<Appointment> getAppointments();
	public void getAppointments(String name);
	

}
