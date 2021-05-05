package dbadapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import datatypes.MemberData;

/**
 * Class representing a Group
 * 
 * @author swe.uni-due.de
 *
 */
public class Group {

	int id;
	String name;
	String description;
	Timestamp appointments;
	int participants;
	String memberslist;
	
	public Group(int id, String name, String description, Timestamp appointment, int participants, String memberslist) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.appointments = appointment;
		this.participants = participants;
		this.memberslist = memberslist;
	
	}
	
	public Group(String memberslist, String name ) {
		super();
		this.memberslist = memberslist;
		this.name = name;				
	
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Timestamp getAppointments() {
		return appointments;
	}
	public void setAppointment(Timestamp appointments) {
		this.appointments = appointments;
	}

	public int getParticipants() {
		return participants;
	}
	public void setParticipants(int participants) {
		this.participants = participants;
	}
	
	public String getMemberslist() {
		return memberslist;
	}
	public void setMemberslist(String memberslist) {
		this.memberslist = memberslist;
	}
}
	/**
	 * Checks if this booking overlaps with the given timespace.
	 * 
	 * @param arrivalTime
	 * @param departureTime
	 * @return
	 */
	