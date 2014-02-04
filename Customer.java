/* 
   Customer.java
*/
public class Customer
{
	// Variables for all table fields
	public String name;
	public String memberID;
	public String phoneNum;
	public String address;
	public String email;
	// I decided to say that any account can have up to
	// 3 additional members...
	public String[] additionalMembers = new String[3];
	// accountStatus is either "revoked" or "active"
	public String accountStatus;
	public int maxNumMovies;
	public int maxNumGames;
	public double lateFees;
	// Once too many late fees, rental privileges revoked, so keep total
	public int totalLateFeesEver;

	// Default Constructor needed for initializing in GUI
	public Customer()
	{
		// When this is called, it will create a new entry in the table
		// If it never gets set, remove the values from the database
		name = null;
		memberID = null;
		phoneNum = null;
		address = null;
		email = null;
		additionalMembers = null;
		accountStatus = null;
		maxNumMovies = -1;
		maxNumGames = -1;
		lateFees = -1.0;
		totalLateFeesEver = -1;
	}

	// Constructor for creation of an object using memberID
	public Customer(String memberID)
	{
		this.memberID = memberID;
		// if the memberID can't be found, set to null and do not
		// set any other fields.  I'll have the GUI check for null
		// in this field as an error check.
	}

	// Constructor for creation of an object using name and phone #
	public Customer(String name, String phoneNum)
	{
		this.name = name;
		this.phoneNum = phoneNum;
		// if the name and phone can't be found, set memberID and do not
		// set any other fields.  I'll have the GUI check for null
		// in these fields as an error check.
	}

	// Accessor methods:
	//
	// When an object is created, all fields must be set by looking
	// up the member's information in the table.
	public String getName()
	{
		return name;
	}

	public String getMemberID()
	{
		return memberID;
	}

	public String getPhoneNum()
	{
		return phoneNum;
	}

	public String getAddress()
	{
		return address;
	}

	public String getEmail()
	{
		return email;
	}

	public String[] getAdditionalMembers()
	{
		return additionalMembers;
	}

	public String getAccountStatus()
	{
		return accountStatus;
	}

	public int getMaxNumMovies()
	{
		return maxNumMovies;
	}

	public int getMaxNumGames()
	{
		return maxNumGames;
	}

	public double getLateFees()
	{
		return lateFees;
	}

	public int getTotalLateFeesEver()
	{
		return totalLateFeesEver;
	}

	// Mutator methods:
	//
	// When these methods are called, the information in the table
	// must also be updated.
	public void setName(String name)
	{
		this.name = name;
	}

	public void setMemberID(String memberID)
	{
		this.memberID = memberID;
	}

	public void setPhoneNum(String phoneNum)
	{
		this.phoneNum = phoneNum;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setAdditionalMembers(String[] additionalMembers)
	{
		this.additionalMembers = additionalMembers;
	}

	public void setAccountStatus(String accountStatus)
	{
		this.accountStatus = accountStatus;
	}

	public void setMaxNumMovies(int maxNumMovies)
	{
		this.maxNumMovies = maxNumMovies;
	}

	public void setMaxNumGames(int maxNumGames)
	{
		this.maxNumGames = maxNumGames;
	}

	public void setLateFees(double lateFees)
	{
		this.lateFees = lateFees;
	}

	public void setTotalLateFeesEver(int totalLateFeesEver)
	{
		this.totalLateFeesEver = totalLateFeesEver;
	}
}