/* 
    Transaction.java
*/
import java.util.*;

public class Transaction
{
	// Variables for all table fields
	public int transactionNum;
	public String storeNum;
	public String memberID;
	// Date must be in format "Fri Nov 2 2007"
	public String dateRented;
	// type can be "game" or "video"
	public String type;
	public String title;
	public String UPC;
	// Date must be in format "Fri Nov 2 2007"
	public String dueDate;
	public double lateFee;
	public double totalPrice;
	public boolean returned;
	public String serialNum;

	public Transaction()
	{
		totalPrice = -1.0;
	}

	// Constructor for creation of an object using UPC
	//
	// Let me know if you think we also need a parameterless constructor
	public Transaction(int transactionNum)
	{
		this.transactionNum = transactionNum;
		// There will be multiple objects with same number
		// Do not search through database to set all fields because the GUI
		// will be creating the objects.
	}

	// Accessor methods:
	//
	// When an object is created, all fields must be set by looking
	// up the member's information in the table.
	public int getTransactionNum()
	{
		return transactionNum;
	}

	public String getUPC()
	{
		return UPC;
	}

	public double getTotalPrice()
	{
		return totalPrice;
	}

	public String getStoreNum()
	{
		return storeNum;
	}

	public String getMemberID()
	{
		return memberID;
	}

	public String getDateRented()
	{
		return dateRented;
	}

	public String getType()
	{
		return type;
	}

	public String getTitle()
	{
		return title;
	}

	public String getDueDate()
	{
		return dueDate;
	}

	public double getLateFee()
	{
		return lateFee;
	}

	public boolean getReturned()
	{
		return returned;
	}

	public String getSerialNum()
	{
		return serialNum;
	}

	// Mutator methods:
	//
	// When these methods are called, the information in the table
	// must also be updated.
	public void setTransactionNum(int transactionNum)
	{
		this.transactionNum = transactionNum;
	}

	public void setUPC(String UPC)
	{
		this.UPC = UPC;
	}

	public void setTotalPrice(double totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public void setStoreNum(String storeNum)
	{
		this.storeNum = storeNum;
	}

	public void setMemberID(String memberID)
	{
		this.memberID = memberID;
	}

	public void setDateRented(String dateRented)
	{
		this.dateRented = dateRented;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setDueDate(String dueDate)
	{
		this.dueDate = dueDate;
	}

	public void setLateFee(double lateFee)
	{
		this.lateFee = lateFee;
	}

	public void setReturned(boolean returned)
	{
		this.returned = returned;
	}

	public void setSerialNum(String serialNum)
	{
		this.serialNum = serialNum;
	}
}