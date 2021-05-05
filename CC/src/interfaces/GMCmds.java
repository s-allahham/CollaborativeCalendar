package interfaces;

import java.util.ArrayList;

import datatypes.AddressData;
import datatypes.MemberData;
import dbadapter.Appointment;
import dbadapter.Group;


/**
 * Interface that provides all method to interact with a guest.
 * 
 * @author swe.uni-due.de
 *
 */
public interface GMCmds {

	public ArrayList<Group> AccessCalendar(String memberslist);

	

	

}
