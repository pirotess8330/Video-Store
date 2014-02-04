/* 
   MerchandiseTransaction.java
*/
import java.util.*;

public class MerchandiseTransaction
{
	// Variables for all table fields
	public int transactionNum;
	// Date must be in format "Fri Nov 2 2007"
	public String date;
	public String storeNum;
	public String memberID;
	public String UPC;
	public double totalPrice;

	public MerchandiseTransaction()
	{
		totalPrice = -1.0;
	}

	// Constructor for creation of an object using UPC
	//
	// Let me know if you think we also need a parameterless constructor
	public MerchandiseTransaction(int transactionNum)
	{
		this.transactionNum = transactionNum;
		totalPrice = -1.0;
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

	public String getDate()
	{
		return date;
	}

	public double getTotalPrice()
	{
		return totalPrice;
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

	// Mutator methods:
	//
	// When these methods are called, the information in the table
	// must also be updated.
	public void setTransactionNum(int transactionNum)
	{
		this.transactionNum = transactionNum;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public void setTotalPrice(double totalPrice)
	{
		this.totalPrice = totalPrice;
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
}