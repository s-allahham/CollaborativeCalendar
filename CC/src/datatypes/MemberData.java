package datatypes;

/**
 * Contains the necessary informations about a GroupMember.
 * 
 * @author swe.uni-due.de
 *
 */
public class MemberData {
	private String name;
	private int id;

	public MemberData(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getID() {
		return id;
	}
}
