package testing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datatypes.AddressData;
import dbadapter.Configuration;
import dbadapter.addAppointment;
import dbadapter.Appointment;
import junit.framework.TestCase;



public class addAppointmentTest extends TestCase {
	private Appointment testApp;
	
	@Before
	public void setUp() {
	
		testApp = new Appointment( "Test Appointment", Timestamp.valueOf("2021-01-01 00:00:00"), Timestamp.valueOf("2021-12-31 00:00:00"), "Test description",new AddressData ("testStreet", "testTown"),1); 
		ArrayList<Appointment> testApps = new ArrayList<Appointment>();
		testApps.add(testApp);
		String sqlCleanDB = "DROP TABLE IF EXISTS appointment";
		String sqlCreateTableAppointment = "CREATE TABLE appointment (name VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL, startTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,startEnd TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, description VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,street VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL, town VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL ,id INT(11) NOT NULL AUTO_INCREMENT, PRIMARY KEY(id));";
		String sqlInsertAppointment = "INSERT INTO appointment (name,startTime,startEnd,description,street,town,id) VALUES (?,?,?,?,?,?,?)";
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {

			try (PreparedStatement psClean = connection.prepareStatement(sqlCleanDB)) {
				psClean.executeUpdate();
			}
			try (PreparedStatement psCreateApp = connection.prepareStatement(sqlCreateTableAppointment)) {
				psCreateApp.executeUpdate();
			}
			try (PreparedStatement psInsertAppointment = connection.prepareStatement(sqlInsertAppointment)) {
				psInsertAppointment.setString(1, testApp.getName());
				psInsertAppointment.setTimestamp(2, testApp.getStartTime());
				psInsertAppointment.setTimestamp(3, testApp.getEndTime());
				psInsertAppointment.setString(4, testApp.getDescription());
				psInsertAppointment.setString(5, testApp.getLocation().getStreet());
				psInsertAppointment.setString(6, testApp.getLocation().getTown());
				psInsertAppointment.setInt(7, testApp.getId());
				psInsertAppointment.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void testGetAppointments() {

		
		ArrayList<Appointment> apps = addAppointment.getInstance().getAppointments();

		// Verify return values
		assertTrue(apps.size() == 1);
		assertTrue(apps.get(0).getId() == testApp.getId());
		assertTrue(apps.get(0).getName().equals(testApp.getName()));
		assertTrue(apps.get(0).getStartTime().equals(testApp.getStartTime()));
		assertTrue(apps.get(0).getEndTime().equals(testApp.getEndTime()));
		assertTrue(apps.get(0).getDescription().equals(testApp.getDescription()));
		assertTrue(apps.get(0).getLocation().getStreet().equals(testApp.getLocation().getStreet()));
		assertTrue(apps.get(0).getLocation().getTown().equals(testApp.getLocation().getTown()));
	}
	
	
	
	@After
	public void tearDown() {

		// SQL statements
		String sqlCleanDB = "DROP TABLE IF EXISTS appointment";
		
		// Perform database updates
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {

			try (PreparedStatement psClean = connection.prepareStatement(sqlCleanDB)) {
				psClean.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}


