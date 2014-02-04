/* 
   Database.java
*/
import java.util.*;

public class Database
{
	public Customer searchCustomerByID(String memberID)
	{
		// *********  Dummy code ***********
		//
		// This function must search for the customer by the memberID.
		// It then returns the fully initialized (all fields set from
		// the info found in the table) Customer object.
		Customer customer = new Customer(memberID);
		customer.setName("John Doe");
		customer.setPhoneNum("555-555-5555");
		customer.setAddress("555 W 55th St.");
		customer.setEmail("johndoe@yahoo.com");
		String[] add = {"Jane Doe", "Johnny Doe", "Jenny Doe"};
		customer.setAdditionalMembers(add);
		customer.setAccountStatus("active");
		customer.setMaxNumMovies(5);
		customer.setMaxNumGames(2);
		customer.setLateFees(0.00);
		customer.setTotalLateFeesEver(1);

		return customer;
	}

	public Customer searchCustomerByNameAndPhone(String name, String phoneNum)
	{
		// *********  Dummy code ***********
		//
		// This function must search for the customer by the name and phoneNum.
		// It then returns the fully initialized (all fields set from
		// the info found in the table) Customer object.
		Customer customer = new Customer(name, phoneNum);
		customer.setMemberID("12345");
		customer.setAddress("555 W 55th St.");
		customer.setEmail("johndoe@yahoo.com");
		String[] add = {"Jane Doe", "Johnny Doe", "Jenny Doe"};
		customer.setAdditionalMembers(add);
		customer.setAccountStatus("active");
		customer.setMaxNumMovies(5);
		customer.setMaxNumGames(3);
		customer.setLateFees(0.00);
		customer.setTotalLateFeesEver(1);

		return customer;
	}

	public int getLastTransactionNumber()
	{
		// *********  Dummy code ***********
		//
		// This function must look through the transactions databases
		// and find the max transactionNum used so that a new transactionNum
		// with a unique number can be created.
		return 1;
	}

	public Movie searchMovieBySerialNum(String serialNum)
	{
		// *********  Dummy code ***********
		//
		// This function must search for the movie by the serialNum.
		// It then returns the fully initialized (all fields set from
		// the info found in the table) Movie object.
		Movie movie = new Movie(serialNum);
		movie.setTitle("28 Days Later");
		movie.setDescription("Ilia's favorite movie!");
		movie.setFormat("DVD");
		movie.setNumCopies(2);
		movie.setAvailable(true);
		movie.setPrice(1.99);
		movie.setLengthRental(34);
		movie.setLocation("Horror");
		movie.setType("video");
		movie.setUPC("345-90-2455");

		return movie;
	}

	public ReturnTransaction searchReturnTransBySerialNum(String serialNum)
	{
		// *********  Dummy code ***********
		//
		// This function must search for the transaction by the serialNum
		// It then returns the fully initialized (all fields set from
		// the info found in the table) ReturnTransaction object.
		ReturnTransaction returnTran = new ReturnTransaction(serialNum);
		Date date = new Date();
		returnTran.setDateReturned(date.toString());
		returnTran.setTransactionNum(11111);
		returnTran.setStoreNum("3456885");
		returnTran.setUPC("345-3-56");
		returnTran.setMemberID("345");

		return returnTran;
	}

	public Merchandise searchMerchBySerialNum(String serialNum)
	{
		// *********  Dummy code ***********
		//
		// This function must search for the item by the serialNum.
		// It then returns the fully initialized (all fields set from
		// the info found in the table) Merchandise object.
		Merchandise merch = new Merchandise(serialNum);
		merch.setType("candy");
		merch.setUPC("345-255'235");
		merch.setPrice(1.29);
		merch.setInventory(5);

		return merch;
	}

	public double getTotalByTransactionNum(int transactionNum)
	{
		// *********** Dummy Code ***********
		// This function searches database for all Transactions and MerchandiseTransactions
		// with matching transactionNum, and adds all to totals to return
		// the total for the sale.

		return 10.00;
	}

	public int getNumberMoviesRent()
	{
		// *********** Dummy Code ***********
		// This function searches database and returns the number of all Movies
		// of type "movie"
		return 546;
	}

	public int getNumberGamesRent()
	{
		// *********** Dummy Code ***********
		// This function searches database and returns the number of all Movies
		// of type "game"
		return 237;
	}

	public int getNumRentedMovie(String memberID)
	{
		// *********** Dummy Code ***********
		// This function searches database for all movie Transactions that have not been returned
		// with memberID
		return 4;
	}

	public int getNumRentedGame(String memberID)
	{
		// *********** Dummy Code ***********
		// This function searches database for all game Transactions that
		// have not been retured with memberID.
		return 2;
	}

	public int getNumberStores()
	{
		// *********** Dummy Code ***********
		// This function searches database and returns number of stores.
		return 6;
	}

	public int getRentedDaily()
	{
		// *********** Dummy Code ***********
		// This function searches database, finds the number of movies
		// rented daily, and gets the total of all stores.
		return 66;
	}

	public int getRentedMonthly()
	{
		// *********** Dummy Code ***********
		// This function searches database, finds the number of movies
		// rented monthly, and gets the total of all stores.
		return 2134;
	}

	public int getRentedYearly()
	{
		// *********** Dummy Code ***********
		// This function searches database, finds the number of movies
		// rented yearly, and gets the total of all stores.
		return 44634;
	}

	public double getDailyEarnings()
	{
		// *********** Dummy Code ***********
		// This function searches database, finds the daily earnings
		// for each store, and gets the total of all stores.
		return 800.00;
	}

	public double getMonthlyEarnings()
	{
		// *********** Dummy Code ***********
		// This function searches database, finds the monthly earnings
		// for each store, and gets the total of all stores.
		return 24000.00;
	}

	public double getYearlyEarnings()
	{
		// *********** Dummy Code ***********
		// This function searches database, finds the yearly earnings
		// for each store, and gets the total of all stores.
		return 167000.00;
	}

	public int getNumberMerchandise()
	{
		// *********** Dummy Code ***********
		// This function searches database, finds the total number
		// of merchandise items for sale, and returns that number
		return 1234;
	}

	public int getNumberMerchandiseOrder()
	{
		// *********** Dummy Code ***********
		// This function searches database, finds the total number
		// of merchandise items with zero inventory, and returns that number
		return 4;
	}

	public int getNumberCandy()
	{
		// *********** Dummy Code ***********
		// This function searches database, finds the total number
		// of merchandise items with type "candy", and returns that number
		return 259;
	}

	public int getNumberSnack()
	{
		// *********** Dummy Code ***********
		// This function searches database, finds the total number
		// of merchandise items with type "snack", and returns that number
		return 210;
	}

	public int getNumberAudio()
	{
		// *********** Dummy Code ***********
		// This function searches database, finds the total number
		// of merchandise items with type "audio", and returns that number
		return 160;
	}

	public int getNumberMovie()
	{
		// *********** Dummy Code ***********
		// This function searches database, finds the total number
		// of merchandise items with type "movie", and returns that number
		return 170;
	}

	public int getNumberGame()
	{
		// *********** Dummy Code ***********
		// This function searches database, finds the total number
		// of merchandise items with type "game", and returns that number
		return 135;
	}

	public int getNumberPartySupply()
	{
		// *********** Dummy Code ***********
		// This function searches database, finds the total number
		// of merchandise items with type "party supply", and returns that number
		return 150;
	}

	public int getNumberMisc()
	{
		// *********** Dummy Code ***********
		// This function searches database, finds the total number
		// of merchandise items with type "misc", and returns that number
		return 150;
	}

	public void removeCustomer(Customer currentCust)
	{
		// *********** Dummy Code ***********
		// This function removes the customer from the database.
	}

	public void removeStore(Store currentStore)
	{
		// *********** Dummy Code ***********
		// This function removes the store from the database.
	}

	public void removeMerchandise(Merchandise merch)
	{
		// *********** Dummy Code ***********
		// This function removes the merchandise from the database.
	}

	public void removeMovie(Movie movie)
	{
		// *********** Dummy Code ***********
		// This function removes the movie from the database.
	}

	public Store getStoreByStoreNum(String storeNum)
	{
		// *********  Dummy code ***********
		//
		// This function searches database to find the Store with the matching storeNum.
		Store store = new Store(storeNum);
		store.setPhoneNum("555-555-5555");
		store.setAddress("555 W. 5th");
		store.setManagerName("John Doe");
		store.setBonusPolicyMovie(12);
		store.setBonusPolicyGame(6);
		store.setMoviesRentedDaily(33);
		store.setMoviesRentedMonthly(990);
		store.setMoviesRentedYearly(11880);
		store.setDailyEarnings(200.0);
		store.setMonthlyEarnings(6000.0);
		store.setYearlyEarnings(72000.0);
		store.setTax(8.5);

		return store;
	}

	public double getTax(Store store)
	{
		double tax = store.getTax();
		tax = tax * 0.01;
		tax = tax + 1.0;
		return tax;
	}

	public int getBonusMovies(String memberID, String storeNum)
	{
		// *********  Dummy code ***********
		//
		// This function searches database (Transaction) for all video rentals by memberID
		// whether they have been returned or not.
		// This code must use the following algorithm to get the bonus policy info.
		//
		// num will be the total number of rentals by customer, this doesn't include
		// rentals that are free because of bonus policy (those transactions with a totalPrice
		// of 0.00)
		int num = 12;
		Store store = getStoreByStoreNum(storeNum);
		num = num % store.getBonusPolicyMovie();
		return num;

	}

	public int getBonusGames(String memberID, String storeNum)
	{
		// *********  Dummy code ***********
		//
		// This function searches database (Transaction) for all game rentals by memberID
		// whether they have been returned or not.
		// This code must use the following algorithm to get the bonus policy info.
		//
		// num will be the total number of rentals by customer, this doesn't include
		// rentals that are free because of bonus policy (those transactions with a totalPrice
		// of 0.00)
		int num = 33;
		Store store = getStoreByStoreNum(storeNum);
		num = num % store.getBonusPolicyGame();
		return num;

	}

	public Transaction getTransactionBySerialNum(String serialNum)
	{
		// *********  Dummy code ***********
		//
		// This function searches database to find the Transaction with matching
		// serialNum and returned == false
		// If not found set transactionNum to -1.
		Date date = new Date();
		Transaction trans = new Transaction(34566);
		trans.setUPC("355-45-2");
		trans.setTotalPrice(10.0);
		trans.setStoreNum("1111");
		trans.setMemberID("345");
		trans.setDateRented(date.toString());
		trans.setType("movie");
		trans.setTitle("28 Days Later");
		trans.setDueDate("Sat Nov 03 2007");
		trans.setLateFee(0.00);
		trans.setReturned(false);
		trans.setSerialNum(serialNum);

		return trans;
	}

	public int getNumberCustomers()
	{
		// *********  Dummy code ***********
		//
		// This function searches database and returns the number of
		// customers.
		return 200;
	}

	public int getNumberActiveCustomers()
	{
		// *********  Dummy code ***********
		//
		// This function searches database and returns the number of
		// customers with "active" status.
		return 192;
	}

	public int getNumberRevokedCustomers()
	{
		// *********  Dummy code ***********
		//
		// This function searches database and returns the number of
		// customers with "active" status.
		return 8;
	}

	public double getTotalLateFees()
	{
		// *********  Dummy code ***********
		//
		// This function searches database, finds the customers with late
		// fees, and returns the total amount of late fees withstanding.
		return 127.97;
	}

	public String getDate(String date)
	{
		StringTokenizer tokenizer = new StringTokenizer(date);
		String theDate = tokenizer.nextToken();
		int count = 0;

		while(count < 2)
		{
			String token = tokenizer.nextToken();
			theDate = theDate + " " + token;
			count++;
		}

		String token = tokenizer.nextToken();
		token = tokenizer.nextToken();
		token = tokenizer.nextToken();
		theDate = theDate + " " + token;
		//System.out.println(theDate);
		return theDate;
	}

	public String getDueDate(String date, int length)
	{
		StringTokenizer tokenizer = new StringTokenizer(date);
		String weekDay = tokenizer.nextToken();
		int weekday = -1;
		String month = tokenizer.nextToken();
		String day = tokenizer.nextToken();
		int theDay = Integer.parseInt(day);
		theDay = theDay + length;
		String year = tokenizer.nextToken();
		int theYear = Integer.parseInt(year);
		String dueDate;

		if(month.equals("Jan"))
		{
			if(theDay > 31)
			{
				month = "Feb";
				theDay = theDay - 31;
			}
		}

		else if(month.equals("Feb"))
		{
			if(theDay > 28)
			{
				month = "Mar";
				theDay = theDay - 28;
			}
		}

		else if(month.equals("Mar"))
		{
			if(theDay > 31)
			{
				month = "Apr";
				theDay = theDay - 31;
			}
		}

		else if(month.equals("Apr"))
		{
			if(theDay > 30)
			{
				month = "May";
				theDay = theDay - 30;
			}
		}

		else if(month.equals("May"))
		{
			if(theDay > 31)
			{
				month = "Jun";
				theDay = theDay - 31;
			}
		}

		else if(month.equals("Jun"))
		{
			if(theDay > 30)
			{
				month = "Jul";
				theDay = theDay - 30;
			}
		}

		else if(month.equals("Jul"))
		{
			if(theDay > 31)
			{
				month = "Aug";
				theDay = theDay - 31;
			}
		}

		else if(month.equals("Aug"))
		{
			if(theDay > 31)
			{
				month = "Sep";
				theDay = theDay - 31;
			}
		}

		else if(month.equals("Sep"))
		{
			if(theDay > 30)
			{
				month = "Oct";
				theDay = theDay - 30;
			}
		}

		else if(month.equals("Oct"))
		{
			if(theDay > 31)
			{
				month = "Nov";
				theDay = theDay - 31;
			}
		}

		else if(month.equals("Nov"))
		{
			if(theDay > 30)
			{
				month = "Dec";
				theDay = theDay - 30;
			}
		}

		else if(month.equals("Dec"))
		{
			if(theDay > 31)
			{
				month = "Jan";
				theDay = theDay - 31;
				theYear++;
			}
		}

		System.out.println(weekDay);
		if(weekDay.equals("Mon"))
		{
			weekday = 1;
		}

		else if(weekDay.equals("Tue"))
		{
			weekday = 2;
		}

		else if(weekDay.equals("Wed"))
		{
			weekday = 3;
		}

		else if(weekDay.equals("Thu"))
		{
			weekday = 4;
		}

		else if(weekDay.equals("Fri"))
		{
			weekday = 5;
		}

		else if(weekDay.equals("Sat"))
		{
			weekday = 6;
		}

		else if(weekDay.equals("Sun"))
		{
			weekday = 7;
		}

		System.out.println(weekday);
		weekday = weekday + length;
		System.out.println(weekday);

		if(weekday > 7)
		{
			weekday = weekday % 7;
			System.out.println(weekday);
		}

		//weekday--;
		System.out.println(weekday);

		if(weekday == 1)
		{
			weekDay = "Mon";
		}

		else if(weekday == 2)
		{
			weekDay = "Tue";
		}

		else if(weekday == 3)
		{
			weekDay = "Wed";
		}

		else if(weekday == 4)
		{
			weekDay = "Thu";
		}

		else if(weekday == 5)
		{
			weekDay = "Fri";
		}

		else if(weekday == 6)
		{
			weekDay = "Sat";
		}

		else if(weekday == 7)
		{
			weekDay = "Sun";
		}

		if(theDay < 10)
		{
			day = "0" + theDay;
			dueDate = weekDay + " " + month + " " + day + " " + theYear;
		}

		else
		{
			dueDate = weekDay + " " + month + " " + theDay + " " + theYear;
		}

		return dueDate;
	}

	public boolean isLateFee(String dueDate, String dateReturned)
	{
		boolean lateFee = false;
		//System.out.println(dueDate);
		//System.out.println(dateReturned);

		StringTokenizer dueTokenizer = new StringTokenizer(dueDate);
		String dueWeekDay = dueTokenizer.nextToken();
		String dueMonth = dueTokenizer.nextToken();
		String dueDay = dueTokenizer.nextToken();
		String dueYear = dueTokenizer.nextToken();

		StringTokenizer retTokenizer = new StringTokenizer(dateReturned);
		String retWeekDay = retTokenizer.nextToken();
		String retMonth = retTokenizer.nextToken();
		String retDay = retTokenizer.nextToken();
		String retYear = retTokenizer.nextToken();

		if(dueDate.equals(dateReturned))
		{
			lateFee = false;
		}

		else
		{
			int theDueDay = Integer.parseInt(dueDay);
			//System.out.println(theDueDay);
			int theRetDay = Integer.parseInt(retDay);
			//System.out.println(theRetDay);
			if(theRetDay > theDueDay)
			{
				lateFee = true;
			}

			if(!dueMonth.equals(retMonth))
			{
				lateFee = true;
			}

			if(!dueYear.equals(retYear))
			{
				lateFee = true;
			}
		}

		return lateFee;
	}
}