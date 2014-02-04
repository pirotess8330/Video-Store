/* 
    ReturnTransaction.java
*/
import java.util.*;

public class ReturnTransaction
{
	// Variables for all table fields
	public int transactionNum;
	// Date must be in format "Fri Nov 2 2007"
	public String dateReturned;
	public String storeNum;
	public String memberID;
	public String UPC;
	public String serialNum;

	// Constructor for creation of an object using UPC
	//
	// Let me know if you think we also need a parameterless constructor
	public ReturnTransaction(String serialNum)
	{
		this.serialNum = serialNum;
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

	public String getDateReturned()
	{
		return dateReturned;
	}

	public String getUPC()
	{
		return UPC;
	}

	public String getStoreNum()
	{
		return storeNum;
	}

	public String getMemberID()
	{
		return memberID;
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

	public void setDateReturned(String dateReturned)
	{
		this.dateReturned = dateReturned;
	}

	public void setUPC(String UPC)
	{
		this.UPC = UPC;
	}

	public void setStoreNum(String storeNum)
	{
		this.storeNum = storeNum;
	}

	public void setMemberID(String memberID)
	{
		this.memberID = memberID;
	}

	public void setSerialNum(String serialNum)
	{
		this.serialNum = serialNum;
	}
}