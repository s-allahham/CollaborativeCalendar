package interfaces;


import java.util.ArrayList;


import datatypes.MemberData;

import dbadapter.Group;

/**
 * Interface for DBFacade to provide all necessary database function.
 * 
 * @author swe.uni-due.de
 *
 */
public interface IGroup {

	public ArrayList<Group> CheckAccess(String memberslist);



}