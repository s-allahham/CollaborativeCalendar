package dbadapter;

import java.sql.Timestamp;
import java.util.ArrayList;
import datatypes.AddressData;

/**
 * Class representing an offer
 * 
 * @author swe.uni-due.de
 *
 */
public class Appointment {

	private int id;
	private String name;
	private String description;
	private Timestamp startTime;
	private Timestamp endTime;
	private AddressData location;
	private Timestamp dates;
	private Timestamp deadline; 
	private int participants;
	private String street;
	private String town;
	private ArrayList<Appointment> AP;
	private static Appointment instance;

	public Appointment(int id, String name, String description, Timestamp startTime, Timestamp endTime, AddressData location, int participants,
			Timestamp dates, Timestamp deadline) {
		super();
		this.id = id;
		this.name=name;
		this.description = description;
		this.dates = dates;
		this.deadline = deadline;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.participants = participants ;
		this.AP = new ArrayList<Appointment>();
	}
	public Appointment(String name, Timestamp startTime, Timestamp endTime,String description, AddressData location)  {
		super();
		this.name=name;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.AP = new ArrayList<Appointment>();
	}

	public Appointment(String name, Timestamp startTime, Timestamp endTime,String description, String street, String town )  {
		super();
		this.name=name;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.street= getLocation().getStreet();
		this.town= getLocation().getTown();
		this.AP = new ArrayList<Appointment>();
	}
	public Appointment(String name, Timestamp startTime, Timestamp endTime,String description, AddressData location,int id )  {
		super();
		this.name=name;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.id=id;
	}
	
	public Appointment(String name, Timestamp startTime, Timestamp endTime,String description, String street,String town, int participants )  {
		super();
		this.name=name;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.street= getLocation().getStreet();
		this.town= getLocation().getTown();
	    this.participants=participants;
	}
	
	public Appointment(String name, String description, Timestamp startTime, Timestamp endTime, AddressData location, int participants,
			 Timestamp deadline) {
		super();
		this.name=name;
		this.description = description;
		this.deadline = deadline;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.participants = participants ;
		this.AP = new ArrayList<Appointment>();
	}
	
	public Appointment(String name, Timestamp startTime, Timestamp endTime,String description, String street, String town,int participants,Timestamp deadline)  {
		super();
		this.name=name;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.street= street;
		this.town= town;
	    this.participants=participants;
	    this.deadline=deadline;
	}
	
	
	private Appointment() {
		try {
			Class.forName("com." + Configuration.getType() + ".jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public static Appointment getInstance() {
		if (instance == null) {
			instance = new Appointment();
		}
		return instance;
	}
		
	public static void setInstance(Appointment appointment) {
			instance = appointment;
	}
		
		
	

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public String getStreet() {
		return name;
	}public String getTown() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
	public Timestamp getDates() {
		return dates;
	}
	
	public Timestamp getDeadline() {
		return deadline;
	}
	
	public Timestamp getStartTime() {
		return startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public AddressData getLocation() {
		return location;
	}

	public int getParticipants() {
		return participants;
	}
	
	public ArrayList<Appointment> getAP() {
		return AP;
	}

	public void setAP(ArrayList<Appointment> AP) {
		this.AP = AP;
	}
}

	/**
	 * Checking if this offer is available. All bookings for this offer are
	 * iteratively checked.
	 * 
	 * @param arrivalTime
	 * @param departureTime
	 * @return
	 */
