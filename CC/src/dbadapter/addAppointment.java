package dbadapter;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import datatypes.AddressData;
import interfaces.IAppointment;

public class addAppointment implements IAppointment {
	private static addAppointment  instance;
	
	private addAppointment() {
		try {
			Class.forName("com." + Configuration.getType() + ".jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static addAppointment getInstance() {
		if (instance == null) {
			instance = new addAppointment();
		}

		return instance;
	}

	public static void setInstance(addAppointment appointment) {
		instance = appointment;
	}
	
	
	public void insertNewAppointment(String name, Timestamp startTime, Timestamp endTime,String appointmentDescription, AddressData destination) {

		// Declare SQL query to insert offer.
		String sqlInsert = "INSERT INTO appointment (name,startTime,endTime,description,street,town,participants) VALUES (?,?,?,?,?,?,?)";
		String sqlDeadline ="UPDATE appointment SET deadline = current_timestamp + interval '14' day WHERE name=?";
		// Insert offer into database.
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {

			try (PreparedStatement ps = connection.prepareStatement(sqlInsert);
					PreparedStatement ps1 = connection.prepareStatement(sqlDeadline)) {
				
				ps.setString(1, name);
				ps.setTimestamp(2, startTime);
				ps.setTimestamp(3, endTime);
				ps.setString(4, appointmentDescription);
				ps.setString(5, destination.getStreet());
				ps.setString(6, destination.getTown());
				ps.setInt(7,0);
				ps.executeUpdate();
				
				ps1.setString(1,name);
				ps1.executeUpdate();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
public ArrayList<Appointment> getAppointments() {
		
		ArrayList<Appointment> result = new ArrayList<Appointment>();

		// Declare the necessary SQL queries.
		String sqlSelect = "SELECT name,startTime,endTime,description,street,town,participants,deadline FROM appointment where deadline > CURRENT_TIMESTAMP";
		
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {
			
			try (PreparedStatement ps = connection.prepareStatement(sqlSelect)) {
				
				
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Appointment app = new Appointment(rs.getString(1),rs.getTimestamp(2),rs.getTimestamp(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getTimestamp(8));
						result.add(app);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			} catch (Exception e)  {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return result;
	}
public void getAppointments(String name) {
	
	String query="UPDATE appointment SET participants = participants + 1 WHERE name=?";
	
	try (Connection connection = DriverManager
			.getConnection(
					"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
							+ Configuration.getPort() + "/" + Configuration.getDatabase(),
					Configuration.getUser(), Configuration.getPassword())) {

		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setString(1, name);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public ArrayList<Appointment> getFinalizedAppointments() {
	
	ArrayList<Appointment> result = new ArrayList<Appointment>();

	// Declare the necessary SQL queries.
	String sqlSelect = "SELECT name,startTime,endTime,description,street,town,participants,deadline FROM appointment where deadline < CURRENT_TIMESTAMP and participants > 0 ";
	
	try (Connection connection = DriverManager
			.getConnection(
					"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
							+ Configuration.getPort() + "/" + Configuration.getDatabase(),
					Configuration.getUser(), Configuration.getPassword())) {
		
		try (PreparedStatement ps = connection.prepareStatement(sqlSelect)) {
			
			
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Appointment app = new Appointment(rs.getString(1),rs.getTimestamp(2),rs.getTimestamp(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getTimestamp(8));
					result.add(app);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} catch (Exception e)  {
			e.printStackTrace();
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	// TODO Auto-generated method stub
	return result;
}
}
/*	@Override
	public void instertNewAppointment(String name, Timestamp startTime, Timestamp endTime,
			String appointmentDescription, AddressData destination) {
		// TODO Auto-generated method stub
		
	}
}*/