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
import interfaces.IGroup;

public class accessGroup implements IGroup {
	private static accessGroup  instance;
	
	private accessGroup() {
		try {
			Class.forName("com." + Configuration.getType() + ".jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static accessGroup getInstance() {
		if (instance == null) {
			instance = new accessGroup();
		}
		return instance;
	}
		
	public static void setInstance (accessGroup group) {
	
			instance = group;
	}
	
	
	public  ArrayList<Group> CheckAccess(String memberslist)
	{
		ArrayList<Group> result= new ArrayList<Group>();
		String sqlSelectB = "SELECT * FROM group1 WHERE memberslist = ?";
		try (Connection connection = DriverManager
				.getConnection(
						"jdbc:" + Configuration.getType() + "://" + Configuration.getServer() + ":"
								+ Configuration.getPort() + "/" + Configuration.getDatabase(),
						Configuration.getUser(), Configuration.getPassword())) {

			try (PreparedStatement ps = connection.prepareStatement(sqlSelectB)) {
			
					
				ps.setString(1, memberslist);
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						String name = rs.getString(2);
						
						result.add(new Group(memberslist, name));
					}
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		} catch (Exception e) {
					e.printStackTrace();
				}
			
		return result;
		}
	
}


