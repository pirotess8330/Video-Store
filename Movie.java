/* 
   Movie.java
   Includes info games too!
*/
public class Movie
{
	// Variables for all table fields
	public String title;
	public String UPC;
	public String description;
	// format can be "DVD" or "VHS" or "both"
	public String format;
	public int numCopies;
	// Need info for sale and rent -or-
	// we put movies also in Merchandise for ones that are for sale
	public boolean available;
	public double price;
	public int lengthRental;
	public String location;
	// type is "video" and "game"
	public String type;
	public String serialNum;

	// Default constructor for initialization of GUI
	public Movie()
	{
		title = null;
		UPC = null;
		description = null;
		format = null;
		numCopies = -1;
		available = false;
		price = -1;
		lengthRental = -1;
		location = null;
		type = null;
		serialNum = null;
	}

	// Constructor for creation of an object using UPC
	// This will only have to be used if there are two movies
	// with the same name
	public Movie(String UPC, String title)
	{
		this.UPC = UPC;
		this.title = title;
		// if the UPC can't be found, set to null and do not
		// set any other fields.  I'll have the GUI check for null
		// in this field as an error check.
	}

	// Constructor for creation of an object using name
	public Movie(String serialNum)
	{
		this.serialNum = serialNum;
		// if the serialNum can't be found, set to null and do not
		// set any other fields.  I'll have the GUI check for null
		// in this field as an error check.
	}

	// Accessor methods:
	//
	// When an object is created, all fields must be set by looking
	// up the member's information in the table.
	public String getTitle()
	{
		return title;
	}

	public String getType()
	{
		return type;
	}

	public String getUPC()
	{
		return UPC;
	}

	// Optional method
	public String getDescription()
	{
		return description;
	}

	public String getFormat()
	{
		return format;
	}

	public int getNumCopies()
	{
		return numCopies;
	}

	public boolean getAvailable()
	{
		return available;
	}

	public double getPrice()
	{
		return price;
	}

	public int getLengthRental()
	{
		return lengthRental;
	}

	public String getLocation()
	{
		return location;
	}

	public String getSerialNum()
	{
		return serialNum;
	}

	// Mutator methods:
	//
	// When these methods are called, the information in the table
	// must also be updated.
	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public void setUPC(String UPC)
	{
		this.UPC = UPC;
	}

	// Optional method
	public void setDescription(String description)
	{
		this.description = description;
	}

	public void setFormat(String format)
	{
		this.format = format;
	}

	public void setNumCopies(int numCopies)
	{
		this.numCopies = numCopies;
	}

	public void setAvailable(boolean available)
	{
		this.available = available;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public void setLengthRental(int lengthRental)
	{
		this.lengthRental = lengthRental;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public void setSerialNum(String serialNum)
	{
		this.serialNum = serialNum;
	}
}