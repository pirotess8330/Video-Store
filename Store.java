/* 
    Store.java
*/
public class Store
{
	// Variables for all table fields
	public String storeNum;
	// The number of movies needed before one is free
	public int bonusPolicyMovie;
	// The number of movies needed before one is free
	public int bonusPolicyGame;
	public String address;
	public String managerName;
	public String phoneNum;
	// The following are set using the transactions.
	// Daily info is set by the current day.
	// Monthly info is set by the current month.
	// Yearly info is set by the current year.
	public int moviesRentedDaily;
	public int moviesRentedMonthly;
	public int moviesRentedYearly;
	public double dailyEarnings;
	public double monthlyEarnings;
	public double yearlyEarnings;
	// This number will be put in like "8.5"
	// A function in Database will convert it to proper format
	public double tax;

	// Default constructor for use in GUI
	public Store()
	{
		// When this is called, it will create a new entry in the table
		// If it never gets set, remove the values from the database
		storeNum = null;
		bonusPolicyMovie = -1;
		bonusPolicyGame = -1;
		address = null;
		managerName = null;
		phoneNum = null;
		moviesRentedDaily = -1;
		moviesRentedMonthly = -1;
		moviesRentedYearly = -1;
		dailyEarnings = -1.0;
		monthlyEarnings = -1.0;
		yearlyEarnings = -1.0;
		tax = -1.0;
	}

	// Constructor for creation of an object using storeNum
	public Store(String storeNum)
	{
		this.storeNum = storeNum;
		// if the storeNum can't be found, set to null and do not
		// set any other fields.  I'll have the GUI check for null
		// in this field as an error check.
	}

	// Accessor methods:
	//
	// When an object is created, all fields must be set by looking
	// up the member's information in the table.
	public String getStoreNum()
	{
		return storeNum;
	}

	public String getPhoneNum()
	{
		return phoneNum;
	}

	public String getAddress()
	{
		return address;
	}

	public String getManagerName()
	{
		return managerName;
	}

	public int getBonusPolicyMovie()
	{
		return bonusPolicyMovie;
	}

	public int getBonusPolicyGame()
	{
		return bonusPolicyGame;
	}

	public int getMoviesRentedDaily()
	{
		return moviesRentedDaily;
	}

	public int getMoviesRentedMonthly()
	{
		return moviesRentedMonthly;
	}

	public int getMoviesRentedYearly()
	{
		return moviesRentedYearly;
	}

	public double getDailyEarnings()
	{
		return dailyEarnings;
	}

	public double getMonthlyEarnings()
	{
		return monthlyEarnings;
	}

	public double getYearlyEarnings()
	{
		return yearlyEarnings;
	}

	public double getTax()
	{
		return tax;
	}

	// Mutator methods:
	//
	// When these methods are called, the information in the table
	// must also be updated.
	public void setPhoneNum(String phoneNum)
	{
		this.phoneNum = phoneNum;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public void setStoreNum(String storeNum)
	{
		this.storeNum = storeNum;
	}

	public void setManagerName(String managerName)
	{
		this.managerName = managerName;
	}

	public void setBonusPolicyMovie(int bonusPolicyMovie)
	{
		this.bonusPolicyMovie = bonusPolicyMovie;
	}

	public void setBonusPolicyGame(int bonusPolicyGame)
	{
		this.bonusPolicyGame = bonusPolicyGame;
	}

	public void setMoviesRentedDaily(int moviesRentedDaily)
	{
		this.moviesRentedDaily = moviesRentedDaily;
	}

	public void setMoviesRentedMonthly(int moviesRentedMonthly)
	{
		this.moviesRentedMonthly = moviesRentedMonthly;
	}

	public void setMoviesRentedYearly(int moviesRentedYearly)
	{
		this.moviesRentedYearly = moviesRentedYearly;
	}

	public void setDailyEarnings(double dailyEarnings)
	{
		this.dailyEarnings = dailyEarnings;
	}

	public void setMonthlyEarnings(double monthlyEarnings)
	{
		this.monthlyEarnings = monthlyEarnings;
	}

	public void setYearlyEarnings(double yearlyEarnings)
	{
		this.yearlyEarnings = yearlyEarnings;
	}

	public void setTax(double tax)
	{
		this.tax = tax;
	}
}