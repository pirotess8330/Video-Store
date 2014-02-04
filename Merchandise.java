/*
   Merchandise.java
*/
public class Merchandise
{
	// Variables for all table fields
	//
	// type can be "candy", "snack", "audio", "movie" (for movies for sale),
	// "game" (games for sale), "partySupply", "misc".
	public String type;
	public String UPC;
	public double price;
	public int inventory;
	public String serialNum;

	// Default constructor for use in GUI
	public Merchandise()
	{
		type = null;
		UPC = null;
		price = -1.0;
		inventory = -1;
		serialNum = null;
	}

	// Constructor for creation of an object using serialNum
	public Merchandise(String serialNum)
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
	public String getType()
	{
		return type;
	}

	public String getUPC()
	{
		return UPC;
	}

	public double getPrice()
	{
		return price;
	}

	public int getInventory()
	{
		return inventory;
	}

	public String getSerialNum()
	{
		return serialNum;
	}

	// Mutator methods:
	//
	// When these methods are called, the information in the table
	// must also be updated.
	public void setType(String type)
	{
		this.type = type;
	}

	public void setUPC(String UPC)
	{
		this.UPC = UPC;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public void setInventory(int inventory)
	{
		this.inventory = inventory;
	}

	public void setSerialNum(String serialNum)
	{
		this.serialNum = serialNum;
	}
}