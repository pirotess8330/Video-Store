/* 
   GUI.java
*/
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

public class GUI extends JFrame
{
	// Variables declaration
	//
	// variables for size of window
	int width = 700;
	int length = 700;
	// the current store number
	String myStoreNum = null;
	// make sure all items in same transaction have same transaction number
	boolean sameTransaction = true;
	boolean getBonus = false;
	Date theDate = new Date();
	Double transactionTotal = new Double(-1.0);
	// object declarations
	Database db = new Database();
	Store currentStore = new Store();
	Store store = new Store();
	Customer currentCust = new Customer();
	Movie currentMovie = new Movie();
	Transaction transaction = new Transaction();
	ReturnTransaction returnTrans;
	MerchandiseTransaction merchTrans = new MerchandiseTransaction();
	Merchandise currentMerch = new Merchandise();
	// get first transaction number of the day
	int transactionNum = db.getLastTransactionNumber() + 1;
	// choice for first combo box in transaction tab
	int itemChoice = -1;
	// choice for update combo boxes
	int updateChoice = -1;
	int merchOrMovie = -1;
	// current sales tax
	double tax = db.getTax(store);

	String date = db.getDate(theDate.toString());

	// Panels
	private JTabbedPane tabPane1;
	private JPanel contentPane;

	// Tabs
	private JPanel TransactionTab;
	private JPanel MemberTab;
	private JPanel StoreTab;
	private JPanel MerchandiseTab;

	// Buttons
	private JButton transTabEnter1;
	private JButton transTabEnter2;
	private JButton transDone;
	private JButton transGetChange;
	private JButton transPrint;
	private JButton custGetGen;
	private JButton custEnterID;
	private JButton custEnterName;
	private JButton custRemove;
	private JButton custUpdateInfo;
	private JButton custAdd;
	private JButton storeGetGen;
	private JButton storeEnterNum;
	private JButton storeMyEnter;
	private JButton storeRemove;
	private JButton storeUpdateInfo;
	private JButton storeAdd;
	private JButton merchGetGen;
	private JButton merchEnter1;
	private JButton merchEnter2;
	private JButton merchRemove;
	private JButton merchUpdateInfo;
	private JButton merchAddSale;
	private JButton merchAddRent;

	// Text Fields
	private JTextField transTabCustomer;
	private JTextArea transCustInfo;
	private JScrollPane transCustScroll;
	private JTextField transTabSale;
	private JTextArea transSaleInfo;
	private JScrollPane transSaleScroll;
	private JTextArea transPaymentTotal;
	private JTextField transPayment;
	private JTextArea transChangeDue;
	private JTextArea custGenInfo;
	private JTextField custIndID;
	private JTextField custIndName;
	private JTextArea custIndInfo;
	private JScrollPane custIndScroll;
	private JTextArea custCurrent;
	private JTextField custUpdated;
	private JTextArea storeGenInfo;
	private JScrollPane storeGenScroll;
	private JTextField storeIndNum;
	private JTextArea storeInfo;
	private JTextArea storeCurrent;
	private JTextField storeUpdated;
	private JTextArea merchGenInfo;
	private JScrollPane merchGenScroll;
	private JTextField merchSale;
	private JTextField merchRent;
	private JTextArea merchInfo;
	private JTextArea merchCurrent;
	private JTextField merchUpdated;

	// Separators
	private JSeparator transCustSep;
	private JSeparator transMerchSep;
	private JSeparator transPaySep;
	private JSeparator transPaySpace;
	private JSeparator custGenSep;
	private JSeparator custIndSep;
	private JSeparator custUpdateSep;
	private JSeparator storeGenSep;
	private JSeparator storeIndSep;
	private JSeparator storeUpdateSep;
	private JSeparator merchGenSep;
	private JSeparator merchIndSep;
	private JSeparator merchUpdateSep;

	// Labels
	private JLabel transCust;
	private JLabel transMerch;
	private JLabel transPay;
	private JLabel transTendered;
	private JLabel transChange;
	private JLabel custGen;
	private JLabel custInd;
	private JLabel custOR;
	private JLabel custUpdate;
	private JLabel custCurr;
	private JLabel custUp;
	private JLabel merchGen;
	private JLabel merchInd;
	private JLabel merchOR;
	private JLabel merchUpdate;
	private JLabel merchCurr;
	private JLabel merchUp;
	private JLabel storeGen;
	private JLabel storeInd;
	private JLabel storeOR;
	private JLabel storeUpdate;
	private JLabel storeCurr;
	private JLabel storeUp;

	// Combo boxes
	private JComboBox transItemChoice;
	private JComboBox transPaymentChoice;
	private JComboBox custUpdateChoice;
	private JComboBox storeUpdateChoice;
	private JComboBox merchUpdateChoice;

	// Constructor
	public GUI()
	{
		super();
		// Login
		login();
		initializeComponent();
		this.setVisible(true);
	}

	private void initializeComponent()
	{
		// Create panels
		tabPane1 = new JTabbedPane();
		contentPane = (JPanel)this.getContentPane();

		// Create tabs
		TransactionTab = new JPanel();
		MemberTab = new JPanel();
		StoreTab = new JPanel();
		MerchandiseTab = new JPanel();

		// Create buttons
		transTabEnter1 = new JButton();
		transTabEnter2 = new JButton();
		transDone = new JButton();
		transGetChange = new JButton();
		transPrint = new JButton();
		custGetGen = new JButton();
		custEnterID = new JButton();
		custEnterName = new JButton();
		custRemove = new JButton();
		custUpdateInfo = new JButton();
		custAdd = new JButton();
		storeGetGen = new JButton();
		storeEnterNum = new JButton();
		storeMyEnter = new JButton();
		storeRemove = new JButton();
		storeUpdateInfo = new JButton();
		storeAdd = new JButton();
		merchGetGen = new JButton();
		merchEnter1 = new JButton();
		merchEnter2 = new JButton();
		merchRemove = new JButton();
		merchUpdateInfo = new JButton();
		merchAddSale = new JButton();
		merchAddRent = new JButton();

		// Create text fields
		transTabCustomer = new JTextField();
		transCustInfo = new JTextArea();
		transCustScroll = new JScrollPane();
		transTabSale = new JTextField();
		transSaleInfo = new JTextArea();
		transSaleScroll = new JScrollPane();
		transPaymentTotal = new JTextArea();
		transPayment = new JTextField();
		transChangeDue = new JTextArea();
		custGenInfo = new JTextArea();
		custIndID = new JTextField();
		custIndName = new JTextField();
		custIndInfo = new JTextArea();
		custIndScroll = new JScrollPane();
		custCurrent = new JTextArea();
		custUpdated = new JTextField();
		storeGenInfo = new JTextArea();
		storeGenScroll = new JScrollPane();
		storeIndNum = new JTextField();
		storeInfo = new JTextArea();
		storeCurrent = new JTextArea();
		storeUpdated = new JTextField();
		merchGenInfo = new JTextArea();
		merchGenScroll = new JScrollPane();
		merchSale = new JTextField();
		merchRent = new JTextField();
		merchInfo = new JTextArea();
		merchCurrent = new JTextArea();
		merchUpdated = new JTextField();

		// Create separators
		transCustSep = new JSeparator();
		transMerchSep = new JSeparator();
		transPaySep = new JSeparator();
		transPaySpace = new JSeparator();
		custGenSep = new JSeparator();
		custIndSep = new JSeparator();
		custUpdateSep = new JSeparator();
		storeGenSep = new JSeparator();
		storeIndSep = new JSeparator();
		storeUpdateSep = new JSeparator();
		merchGenSep = new JSeparator();
		merchIndSep = new JSeparator();
		merchUpdateSep = new JSeparator();

		// Create labels
		transCust = new JLabel();
		transMerch = new JLabel();
		transPay = new JLabel();
		transTendered = new JLabel();
		transChange = new JLabel();
		custGen = new JLabel();
		custInd = new JLabel();
		custOR = new JLabel();
		custUpdate = new JLabel();
		custCurr = new JLabel();
		custUp = new JLabel();
		storeGen = new JLabel();
		storeInd = new JLabel();
		storeOR = new JLabel();
		storeUpdate = new JLabel();
		storeCurr = new JLabel();
		storeUp = new JLabel();
		merchGen = new JLabel();
		merchInd = new JLabel();
		merchOR = new JLabel();
		merchUpdate = new JLabel();
		merchCurr = new JLabel();
		merchUp = new JLabel();

		// Create combo boxes
		transItemChoice = new JComboBox();
		transPaymentChoice = new JComboBox();
		custUpdateChoice = new JComboBox();
		storeUpdateChoice = new JComboBox();
		merchUpdateChoice = new JComboBox();

		// Add tabs to panel
		tabPane1.addTab("Transaction", TransactionTab);
		tabPane1.addTab("Member", MemberTab);
		tabPane1.addTab("Store", StoreTab);
		tabPane1.addTab("Merchandise", MerchandiseTab);

		// contentPane setup
		contentPane.setLayout(null);
		//addComponent(contentPane, tabPane1, 0, 0, width, length);
		addComponent(contentPane, tabPane1, 0, 0, 700, 700);

		// Set up text fields
		//
		// The text field to enter member ID on transaction tab
		transTabCustomer.setText("Enter member ID");
		// text field where customer info is displayed in transaction tab
		transCustInfo.setText("*******************************Customer Info*******************************");
		transCustScroll.setViewportView(transCustInfo);
		transCustScroll.setPreferredSize(new Dimension(400, 200));
		// text field to enter UPC in transaction
		transTabSale.setText("Enter item info");
		String receipt = "*******************************************************************************" +
						 "\n*\t\tReceipt\t\t            *" +
		                 "\n*******************************************************************************" +
		                 "\nName:\tFormat:\tDue Date:\t\tPrice:";
		// text field for displaying receipt info in transaction tab
		transSaleInfo.setText(receipt);
		// Add a scroll window for receipt info in transaction tab
		transSaleScroll.setViewportView(transSaleInfo);
		transSaleScroll.setPreferredSize(new Dimension(600, 200));
		// text field for displaying total in transaction tab
		transPaymentTotal.setText("Total");
		// text field for entering total payment in transaction tab
		transPayment.setText("    ");
		// Text field where change due will be displayed in Transaction tab
		transChangeDue.setText("    ");
		// Text field for displaying general customer information in member tab
		custGenInfo.setText("************General Customer Information************");
		custGenInfo.setPreferredSize(new Dimension(400, 100));
		// text field for entering customer ID in member tab
		custIndID.setText("Customer ID");
		// text field for entering customer ID in member tab
		custIndName.setText("Customer name and phone #");
		// text field for displaying individual customer info in member tab
		custIndInfo.setText("************Individual Customer Information*************");
		custIndScroll.setViewportView(custIndInfo);
		custIndScroll.setPreferredSize(new Dimension(400, 200));
		// text field for displaying the current customer value in member tab
		custCurrent.setText("Current Value");
		// text field for entering the new value in member tab
		custUpdated.setText("Enter new value");
		// Text field for displaying general store information in store tab
		storeGenInfo.setText("************General Store Information************");
		// Add a scroll to window for general information in member tab
		storeGenScroll.setViewportView(storeGenInfo);
		storeGenScroll.setPreferredSize(new Dimension(400, 150));
		// text field for entering store number in tab
		storeIndNum.setText("Store Number");
		// text field for displaying individual store info in store tab
		storeInfo.setText("************Individual Store Information*************");
		storeInfo.setPreferredSize(new Dimension(400, 200));
		// text field for displaying the current store value in store tab
		storeCurrent.setText("Current Value");
		// text field for entering the new value in store tab
		storeUpdated.setText("Enter new value");
		// Text field for displaying general merchandise information in merchandise tab
		merchGenInfo.setText("************General Merchandise Information************");
		// Add a scroll to window for general information in member tab
		merchGenScroll.setViewportView(merchGenInfo);
		merchGenScroll.setPreferredSize(new Dimension(400, 100));
		// text field for entering serialNum for items for sale in merchandise tab
		merchSale.setText("Enter Item for Sale Serial#");
		// text field for entering serialNum for items for rent in merchandise tab
		merchRent.setText("Enter Item for Rent Serial#");
		// text field for displaying individual merchandise info in merchandise tab
		merchInfo.setText("************Merchandise Information*************");
		merchInfo.setPreferredSize(new Dimension(400, 200));
		// text field for displaying the current merchandise value in merchandise tab
		merchCurrent.setText("Current Value");
		// text field for entering the new value in merchandise tab
		merchUpdated.setText("Enter new value");

		// Set up buttons
		//
		// The 1st enter button on transaction tab
		transTabEnter1.setText("Enter");
		transTabEnter1.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				transTabEnter1_mouseClicked(e);
			}
		});
		// The 2nd enter button on transaction tab
		transTabEnter2.setText("Enter");
		transTabEnter2.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				transTabEnter2_mouseClicked(e);
			}
		});
		// The done button on transaction tab
		transDone.setText("Done");
		transDone.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				transDone_mouseClicked(e);
			}
		});
		// The get change button on transaction tab
		transGetChange.setText("Get Change");
		transGetChange.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				transGetChange_mouseClicked(e);
			}
		});
		// The print receipt button on transaction tab
		transPrint.setText("Print Receipt");
		transPrint.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				transPrint_mouseClicked(e);
			}
		});
		// The get general info button in member tab
		custGetGen.setText("Get General Info");
		custGetGen.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				custGetGen_mouseClicked(e);
			}
		});
		// The enter button in member tab for customer ID
		custEnterID.setText("Enter");
		custEnterID.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				custEnterID_mouseClicked(e);
			}
		});
		// The enter button in member tab for customer name
		custEnterName.setText("Enter");
		custEnterName.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				custEnterName_mouseClicked(e);
			}
		});
		// The remove button in member tab
		custRemove.setText("Make Inactive");
		custRemove.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				custRemove_mouseClicked(e);
			}
		});
		// The update button in member tab
		custUpdateInfo.setText("Update");
		custUpdateInfo.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				custUpdateInfo_mouseClicked(e);
			}
		});
		// The add button in member tab
		custAdd.setText("Add a New Member");
		custAdd.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				custAdd_mouseClicked(e);
			}
		});
		// The get general info button in store tab
		storeGetGen.setText("Get General Info");
		storeGetGen.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				storeGetGen_mouseClicked(e);
			}
		});
		// The enter button to get individual store info in store tab
		storeEnterNum.setText("Enter");
		storeEnterNum.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				storeEnterNum_mouseClicked(e);
			}
		});
		// The enter button to get individual store info in store tab
		storeMyEnter.setText("Get Info for Logged in Store");
		storeMyEnter.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				storeMyEnter_mouseClicked(e);
			}
		});
		// The remove button in store tab
		storeRemove.setText("Make Inactive");
		storeRemove.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				storeRemove_mouseClicked(e);
			}
		});
		// The update button in store tab
		storeUpdateInfo.setText("Update");
		storeUpdateInfo.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				storeUpdateInfo_mouseClicked(e);
			}
		});
		// The add button in store tab
		storeAdd.setText("Add a New Store");
		storeAdd.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				storeAdd_mouseClicked(e);
			}
		});
		// The get general info button in merchandise tab
		merchGetGen.setText("Get General Info");
		merchGetGen.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				merchGetGen_mouseClicked(e);
			}
		});
		// The enter button to get item for sale info in merchandise tab
		merchEnter1.setText("Enter");
		merchEnter1.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				merchEnter1_mouseClicked(e);
			}
		});
		// The enter button to get item for rent info in merchandise tab
		merchEnter2.setText("Enter");
		merchEnter2.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				merchEnter2_mouseClicked(e);
			}
		});
		// The remove button in merchandise tab
		merchRemove.setText("Make Inactive");
		merchRemove.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				merchRemove_mouseClicked(e);
			}
		});
		// The update button in merchandise tab
		merchUpdateInfo.setText("Update");
		merchUpdateInfo.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				merchUpdateInfo_mouseClicked(e);
			}
		});
		// The 1st add button in merchandise tab
		merchAddSale.setText("Add New Item for Sale");
		merchAddSale.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				merchAddSale_mouseClicked(e);
			}
		});
		// The 2st add button in merchandise tab
		merchAddRent.setText("Add New Item for Rent");
		merchAddRent.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				merchAddRent_mouseClicked(e);
			}
		});

		// Set up separators
		//
		// The first separator in Transaction tab
		transCustSep.setPreferredSize(new Dimension(500, 2));
		// The second separator in Transaction tab
		transMerchSep.setPreferredSize(new Dimension(530, 2));
		// The third separator in Transaction tab
		transPaySep.setPreferredSize(new Dimension(530, 2));
		// Spacing in payment section of transaction tab
		transPaySpace.setPreferredSize(new Dimension(350, 2));
		// The first separator in member tab
		custGenSep.setPreferredSize(new Dimension(400, 2));
		// The second separator in member tab
		custIndSep.setPreferredSize(new Dimension(400, 2));
		// The third separator in member tab
		custUpdateSep.setPreferredSize(new Dimension(400, 2));
		// The first separator in Store tab
		storeGenSep.setPreferredSize(new Dimension(390, 2));
		// The second separator in store tab
		storeIndSep.setPreferredSize(new Dimension(390, 2));
		// The third separator in store tab
		storeUpdateSep.setPreferredSize(new Dimension(390, 2));
		// The first separator in Merchandise tab
		merchGenSep.setPreferredSize(new Dimension(370, 2));
		// The second separator in merchandise tab
		merchIndSep.setPreferredSize(new Dimension(370, 2));
		// The third separator in merchandise tab
		merchUpdateSep.setPreferredSize(new Dimension(370, 2));

		// Set up labels
		//
		// The label before 1st separator in Transaction tab
		transCust.setText("Customer Info");
		// The label before 2st separator in Transaction tab
		transMerch.setText("Sale Info");
		// The label before 3rd separator in Transaction tab
		transPay.setText("Payment Info");
		// The label before amount tendered text box in Transaction tab
		transTendered.setText("Amount Tendered:");
		// The label before change text box in Transaction tab
		transChange.setText("Change Due:");
		// The label before 1st separator in member tab
		custGen.setText("General Customer Information");
		// The label before 2nd separator in member tab
		custInd.setText("Individual Customer Information");
		// "Or" label in member tab
		custOR.setText("Or");
		// The label before the 3rd separator in member tab
		custUpdate.setText("Update Customer Information");
		// "Current Value" label in member tab
		custCurr.setText("Current Value");
		// "Updated Value" label in member tab
		custUp.setText("                                                             Updated Value");
		// The label before 1st separator in Store tab
		storeGen.setText("General Store Information");
		// The label before 2nd separator in store tab
		storeInd.setText("Individual Store Information");
		// "Or" label in store tab
		storeOR.setText("               Or            ");
		// The label before the 3rd separator in store tab
		storeUpdate.setText("Update Store Information");
		// "Current Value" label in store tab
		storeCurr.setText("Current Value");
		// "Updated Value" label in store tab
		storeUp.setText("                                                             Updated Value");
		// The label before 1st separator in Merchandise tab
		merchGen.setText("General Merchandise Information");
		// The label before 2nd separator in merchandise tab
		merchInd.setText("Individual Merchandise Information");
		// "Or" label in merchandise tab
		merchOR.setText("Or");
		// The label before the 3rd separator in merchandise tab
		merchUpdate.setText("Update Merchandise Information");
		// "Current Value" label in merchandise tab
		merchCurr.setText("       Current Value");
		// "Updated Value" label in merchandise tab
		merchUp.setText("                                                                  Updated Value");


		// Set up combo boxes
		//
		// Combo box to choose rental or other in transaction tab
		transItemChoice.addItem("Movie/Game Rental");
		transItemChoice.addItem("Movie/Game Return");
		transItemChoice.addItem("Other");
		transItemChoice.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				transItemChoice_actionPerformed(e);
			}
		});
		// Combo box to choose payment option in transaction tab
		transPaymentChoice.addItem("Credit");
		transPaymentChoice.addItem("Debit");
		transPaymentChoice.addItem("Cash");
		transPaymentChoice.addItem("Check");
		transPaymentChoice.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				transPaymentChoice_actionPerformed(e);
			}
		});
		// Combo box to choose update option in member tab
		custUpdateChoice.addItem("Name");
		custUpdateChoice.addItem("Member ID");
		custUpdateChoice.addItem("Phone Number");
		custUpdateChoice.addItem("Address");
		custUpdateChoice.addItem("Email");
		custUpdateChoice.addItem("Additional Members");
		custUpdateChoice.addItem("Account Status");
		custUpdateChoice.addItem("Max Number Movies");
		custUpdateChoice.addItem("Max Number Games");
		custUpdateChoice.addItem("Late Fees");
		custUpdateChoice.addItem("Total Late Fees Ever");
		custUpdateChoice.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				custUpdateChoice_actionPerformed(e);
			}
		});
		// Combo box to choose update option in store tab
		storeUpdateChoice.addItem("Store Number");
		storeUpdateChoice.addItem("Address");
		storeUpdateChoice.addItem("Phone Number");
		storeUpdateChoice.addItem("Movie Bonus Policy");
		storeUpdateChoice.addItem("Game Bonus Policy");
		storeUpdateChoice.addItem("Manager Name");
		storeUpdateChoice.addItem("Movies Rented Daily");
		storeUpdateChoice.addItem("Movies Rented Monthly");
		storeUpdateChoice.addItem("Movies Rented Yearly");
		storeUpdateChoice.addItem("Daily Earnings");
		storeUpdateChoice.addItem("Monthly Earnings");
		storeUpdateChoice.addItem("Yearly Earnings");
		storeUpdateChoice.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				storeUpdateChoice_actionPerformed(e);
			}
		});

		// Combo box to choose update option in member tab
		merchUpdateChoice.addItem("If Sale Item:");
		merchUpdateChoice.addItem("   Type*");
		merchUpdateChoice.addItem("   UPC*");
		merchUpdateChoice.addItem("   Price*");
		//merchUpdateChoice.addItem("   Inventory");
		merchUpdateChoice.addItem("   Serial Number*");
		merchUpdateChoice.addItem("If Rental Item:");
		merchUpdateChoice.addItem("   Title");
		merchUpdateChoice.addItem("   UPC");
		merchUpdateChoice.addItem("   Description");
		merchUpdateChoice.addItem("   Format");
		merchUpdateChoice.addItem("   Number of Copies");
		merchUpdateChoice.addItem("   Available");
		merchUpdateChoice.addItem("   Price");
		merchUpdateChoice.addItem("   Length of Rental");
		merchUpdateChoice.addItem("   Location in Store");
		merchUpdateChoice.addItem("   Type");
		merchUpdateChoice.addItem("   Serial Number");
		merchUpdateChoice.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				merchUpdateChoice_actionPerformed(e);
			}
		});

		// Transaction Tab setup
		TransactionTab.setLayout(new FlowLayout(FlowLayout.LEADING, 40, 10));
		TransactionTab.add(transCust, 0);
		TransactionTab.add(transCustSep, 1);
		TransactionTab.add(transTabCustomer, 2);
		TransactionTab.add(transTabEnter1, 3);
		TransactionTab.add(transCustScroll, 4);
		TransactionTab.add(transMerch, 5);
		TransactionTab.add(transMerchSep, 6);
		TransactionTab.add(transItemChoice, 7);
		TransactionTab.add(transTabSale, 8);
		TransactionTab.add(transTabEnter2, 9);
		TransactionTab.add(transDone, 10);
		TransactionTab.add(transSaleScroll, 11);
		TransactionTab.add(transPay, 12);
		TransactionTab.add(transPaySep, 13);
		TransactionTab.add(transPaymentChoice, 14);
		TransactionTab.add(transPaymentTotal, 15);
		TransactionTab.add(transTendered, 16);
		TransactionTab.add(transPayment, 17);
		TransactionTab.add(transChange, 18);
		TransactionTab.add(transChangeDue, 19);
		TransactionTab.add(transPaySpace, 20);
		TransactionTab.add(transGetChange, 21);
		TransactionTab.add(transPrint, 22);
		TransactionTab.setOpaque(false);

		// Member Tab setup
		MemberTab.setLayout(new FlowLayout(FlowLayout.LEADING, 40, 10));
		MemberTab.add(custGen, 0);
		MemberTab.add(custGenSep, 1);
		MemberTab.add(custGetGen, 2);
		MemberTab.add(custGenInfo, 3);
		MemberTab.add(custInd, 4);
		MemberTab.add(custIndSep, 5);
		MemberTab.add(custIndID, 6);
		MemberTab.add(custEnterID, 7);
		MemberTab.add(custOR, 8);
		MemberTab.add(custIndName, 9);
		MemberTab.add(custEnterName, 10);
		MemberTab.add(custIndScroll, 11);
		MemberTab.add(custRemove, 12);
		MemberTab.add(custUpdate, 13);
		MemberTab.add(custUpdateSep, 14);
		MemberTab.add(custUpdateChoice, 15);
		MemberTab.add(custCurr, 16);
		MemberTab.add(custCurrent, 17);
		MemberTab.add(custUp, 18);
		MemberTab.add(custUpdated, 19);
		MemberTab.add(custUpdateInfo, 20);
		MemberTab.add(custAdd, 21);
		MemberTab.setOpaque(false);

		// Store Tab setup
		StoreTab.setLayout(new FlowLayout(FlowLayout.LEADING, 40, 10));
		StoreTab.add(storeGen, 0);
		StoreTab.add(storeGenSep, 1);
		StoreTab.add(storeGetGen, 2);
		StoreTab.add(storeGenScroll, 3);
		StoreTab.add(storeInd, 4);
		StoreTab.add(storeIndSep, 5);
		StoreTab.add(storeIndNum, 6);
		StoreTab.add(storeEnterNum, 7);
		StoreTab.add(storeOR, 8);
		StoreTab.add(storeMyEnter, 9);
		StoreTab.add(storeInfo, 10);
		StoreTab.add(storeRemove, 11);
		StoreTab.add(storeUpdate, 12);
		StoreTab.add(storeUpdateSep, 13);
		StoreTab.add(storeUpdateChoice, 14);
		StoreTab.add(storeCurr, 15);
		StoreTab.add(storeCurrent, 16);
		StoreTab.add(storeUp, 17);
		StoreTab.add(storeUpdated, 18);
		StoreTab.add(storeUpdateInfo, 19);
		StoreTab.add(storeAdd, 20);
		StoreTab.setOpaque(false);

		// Merchandise Tab setup
		MerchandiseTab.setLayout(new FlowLayout(FlowLayout.LEADING, 40, 10));
		MerchandiseTab.add(merchGen, 0);
		MerchandiseTab.add(merchGenSep, 1);
		MerchandiseTab.add(merchGetGen, 2);
		MerchandiseTab.add(merchGenScroll, 3);
		MerchandiseTab.add(merchInd, 4);
		MerchandiseTab.add(merchIndSep, 5);
		MerchandiseTab.add(merchSale, 6);
		MerchandiseTab.add(merchEnter1, 7);
		MerchandiseTab.add(merchOR, 8);
		MerchandiseTab.add(merchRent, 9);
		MerchandiseTab.add(merchEnter2, 10);
		MerchandiseTab.add(merchInfo, 11);
		MerchandiseTab.add(merchRemove, 12);
		MerchandiseTab.add(merchUpdate, 13);
		MerchandiseTab.add(merchUpdateSep, 14);
		MerchandiseTab.add(merchUpdateChoice, 15);
		MerchandiseTab.add(merchCurr, 16);
		MerchandiseTab.add(merchCurrent, 17);
		MerchandiseTab.add(merchUp, 18);
		MerchandiseTab.add(merchUpdated, 19);
		MerchandiseTab.add(merchUpdateInfo, 20);
		MerchandiseTab.add(merchAddSale, 21);
		MerchandiseTab.add(merchAddRent, 22);
		MerchandiseTab.setOpaque(false);

		// GUI title and setup
		this.setTitle("ACME");
		this.setLocation(new Point(0, 0));
		//this.setSize(new Dimension(width, length));
		this.setSize(new Dimension(700, 700));
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}

	/** Add Component Without a Layout Manager (Absolute Positioning) */
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

	// Event for first enter button on transaction tab
	// Once enter is pressed, member info will display in text area
	public void transTabEnter1_mouseClicked(MouseEvent e)
	{
		String memberID = transTabCustomer.getText();
		currentCust = db.searchCustomerByID(memberID);
		// Format for additional members printing
		if(currentCust.getMemberID() == null)
		{
			transCustInfo.setText("Customer not found!!!");
		}

		else
		{
			if(currentCust.getTotalLateFeesEver() > 10)
			{
				currentCust.setAccountStatus("revoked");
			}

			if(currentCust.getAccountStatus() == "revoked")
			{
				String toPrint = "Rental privileges for member ID " + currentCust.getMemberID() + " have been revoked!!!";
				transCustInfo.setText(toPrint);
			}

			else
			{
				// We need to decide if we want it to print all of this!!
				transCustInfo.setPreferredSize(new Dimension(410, 200));
				String printText = getTextToPrint(currentCust);
				transCustInfo.setText(printText);
			}
		}
	}

	// Event for the 2nd enter button on the transaction tab
	// Once enter is pressed, the receipt will update by adding the item with the
	// given serialNum.
	public void transTabEnter2_mouseClicked(MouseEvent e)
	{
		String serialNum = transTabSale.getText();
		// Make sure a valid memberID was previously entered
		if(currentCust.getMemberID() != null)
		{
			if(currentCust.getAccountStatus() != "revoked")
			{
				if(sameTransaction == true)
				{
					transactionNum = transactionNum;
				}

				else
				{
					transactionNum = transactionNum + 1;
				}

				// If "Movie/Game Rental" chosen in combo box
				if(itemChoice == 0)
				{
					transaction = new Transaction(transactionNum);
					sameTransaction = true;
					if(transaction.getTransactionNum() == -1)
					{
						transSaleInfo.setText("Error in system...");
					}

					else
					{
						currentMovie = db.searchMovieBySerialNum(serialNum);
						int numMoviesRented = -1;
						int numGamesRented = -1;
						int bonus = -1;
						boolean canRent = false;
						if(currentMovie.getType() == "game")
						{
							numGamesRented = db.getNumRentedGame(currentCust.getMemberID());
							bonus = db.getBonusGames(currentCust.getMemberID(), myStoreNum);
							if(numGamesRented < currentCust.getMaxNumGames())
							{
								canRent = true;
							}
						}

						if(currentMovie.getType() == "video")
						{
							numMoviesRented = db.getNumRentedMovie(currentCust.getMemberID());
							bonus = db.getBonusMovies(currentCust.getMemberID(), myStoreNum);
							if(numMoviesRented < currentCust.getMaxNumMovies())
							{
								canRent = true;
							}
						}

						if(canRent == true)
						{
							if(bonus == 0)
							{
								getBonus = true;
							}

							String dueDate = db.getDueDate(date, currentMovie.getLengthRental());
							//System.out.println(dueDate);

							int num = currentMovie.getNumCopies() - 1;
							currentMovie.setNumCopies(num);
							double total = -1.0;
							if(currentMovie.getNumCopies() == 0)
							{
								currentMovie.setAvailable(false);
							}
							String receipt = transSaleInfo.getText() +
											 "\n" + currentMovie.getTitle() +
							                 "\t" + currentMovie.getFormat() +
							                 "\t" + dueDate +
							                 "\t" + currentMovie.getPrice();
							transSaleInfo.setText(receipt);

							if(getBonus == true)
							{
								total = 0.0;
								receipt = transSaleInfo.getText() +
												 "\n\t\tBonus Policy :\t\t -" +
												 currentMovie.getPrice();
								transSaleInfo.setText(receipt);
							}

							else
							{
								total = currentMovie.getPrice();
								receipt = transSaleInfo.getText() +
										  "\n\tMovies toward Bonus Policy :\t" +
										  bonus;
								transSaleInfo.setText(receipt);
							}

							transaction.setStoreNum(myStoreNum);
							transaction.setMemberID(currentCust.getMemberID());
							transaction.setDateRented(date);
							transaction.setType(currentMovie.getType());
							transaction.setUPC(currentMovie.getUPC());
							transaction.setTitle(currentMovie.getTitle());
							transaction.setDueDate(dueDate);
							transaction.setLateFee(currentCust.getLateFees());
							transaction.setTotalPrice(total);
							transaction.setReturned(false);
							transaction.setSerialNum(currentMovie.getSerialNum());
						}

						else
						{
							String receipt = "Customer already has max rentals out!";
							transSaleInfo.setText(receipt);
						}
					}
				}

				// If "Other" chosen in combo box
				if(itemChoice == 2)
				{
					merchTrans = new MerchandiseTransaction(transactionNum);
					sameTransaction = true;
					if(merchTrans.getTransactionNum() == -1)
					{
						transSaleInfo.setText("Error in system...");
					}

					else
					{
						currentMerch = db.searchMerchBySerialNum(serialNum);
						int inv = currentMerch.getInventory() - 1;
						currentMerch.setInventory(inv);
						String receipt = transSaleInfo.getText() +
										 "\n" + currentMerch.getType() +
						                 "\t -"  +
						                 "\t -" +
						                 "\t" + currentMerch.getPrice();
						transSaleInfo.setText(receipt);

						merchTrans.setStoreNum(myStoreNum);
						merchTrans.setMemberID(currentCust.getMemberID());
						merchTrans.setDate(date);
						merchTrans.setUPC(currentMerch.getUPC());
						merchTrans.setTotalPrice(currentMerch.getPrice());
					}
				}
			}

			else
			{
				String toPrint = "Rental privileges for member ID " + currentCust.getMemberID() + " have been revoked!!!";
				transSaleInfo.setText(toPrint);
			}
		}

		// If "Movie/Game Return" chosen in combo box
		// Can be done even if member info was never entered
		if(itemChoice == 1)
		{
			returnTrans = new ReturnTransaction(serialNum);
			Transaction trans = db.getTransactionBySerialNum(serialNum);
			if(trans.getTransactionNum() == -1)
			{
				transSaleInfo.setText("Cannot find history for this rental!");
			}

			else
			{
				trans.setReturned(true);
				returnTrans.setStoreNum(myStoreNum);
				returnTrans.setDateReturned(date);
				returnTrans.setUPC(trans.getUPC());
				returnTrans.setMemberID(trans.getMemberID());
				boolean lateFee = db.isLateFee(trans.getDueDate(), returnTrans.getDateReturned());
				if(lateFee == true)
				{
					currentCust = db.searchCustomerByID(trans.getMemberID());
					double fees = currentCust.getLateFees() + trans.getTotalPrice();
					currentCust.setLateFees(fees);
					int totalLate = currentCust.getTotalLateFeesEver() + 1;
					currentCust.setTotalLateFeesEver(totalLate);
				}
				//System.out.println(lateFee);
				returnTrans.setTransactionNum(transactionNum);
				currentMovie = db.searchMovieBySerialNum(serialNum);
				currentMovie.setAvailable(true);
				int update = currentMovie.getNumCopies() + 1;
				currentMovie.setNumCopies(update);
				returnTrans.setDateReturned(date);
				String receipt = "********************************Return Receipt****************************" +
				                 "\nStore Number:\t" + returnTrans.getStoreNum() +
				                 "\nCustomer ID:\t" + returnTrans.getMemberID() +
				                 "\nDate Returned:\t" + returnTrans.getDateReturned() +
				                 "\nItem UPC:\t" + returnTrans.getUPC();
				transSaleInfo.setText(receipt);
			}
		}

		// Error message if memberID was invalid or never entered
		if((currentCust.getMemberID() == null) && (itemChoice != 1))
		{
			transSaleInfo.setText("Must enter accurate member ID!");
		}
	}

	// Event for done button on transaction tab
	// Once pressed, the receipt will get the total and print it
	public void transDone_mouseClicked(MouseEvent e)
	{
		sameTransaction = false;
		// Make sure a valid memberID was entered and some transaction was actually made
		if((currentCust.getMemberID() != null) && ((transaction.getTotalPrice() != -1.0) || (merchTrans.getTotalPrice() != -1.0)))
		{
			if(itemChoice != -1)
			{
				double subtotal = db.getTotalByTransactionNum(transactionNum) + currentCust.getLateFees();
				transactionTotal = new Double(subtotal * tax);

				String receipt = transSaleInfo.getText() +
								 "\n\nLate Fees:\t\t" + currentCust.getLateFees() +
								 "\nSubtotal:\t\t" + subtotal +
								 "\nTOTAL:\t\t" + transactionTotal.toString();
				transSaleInfo.setText(receipt);
				itemChoice = -1;
			}

			else
			{
				transSaleInfo.setText("Must choose payment option first!");
			}
		}

		// Reset receipt screen if conditions not met
		else
		{
			String receipt = "*******************************************************************************" +
						     "\n*\t\tReceipt\t\t            *" +
		                     "\n*******************************************************************************" +
		                     "\nName:\tFormat:\tDue Date:\tPrice:";
		    transSaleInfo.setPreferredSize(new Dimension(500, 50));
			transSaleInfo.setText(receipt);
		}
	}

	// Event for done button on transaction tab
	// Once pressed, the amount of change to be returned will display
	public void transGetChange_mouseClicked(MouseEvent e)
	{
		double change = Double.parseDouble(transPayment.getText());
		change = change - transactionTotal.doubleValue();
		Double display = new Double(change);
		if(change < 0.0)
		{
			change = change * -1.0;
			display = new Double(change);
			transPaymentTotal.setText(display.toString());
			transactionTotal = new Double(change);
			transChangeDue.setText("Insufficient Payment");
		}

		else
		{
			transChangeDue.setText(display.toString());
			transCustInfo.setText("*******************************Customer Info*******************************");
		}
	}

	// Event for print receipt button on transaction tab
	// Once pressed, a popup window with the receipt will display
	public void transPrint_mouseClicked(MouseEvent e)
	{
		transCustInfo.setText("*******************************Customer Info*******************************");
		transSaleInfo.setText("Printing Receipt.............");
	}

	// Event for get general info button on member tab
	// Once pressed, the general information will display
	// More statistics can be added here at any time.
	public void custGetGen_mouseClicked(MouseEvent e)
	{
		int numCust = db.getNumberCustomers();
		int numActiveCust = db.getNumberActiveCustomers();
		int numRevokedCust = db.getNumberRevokedCustomers();
		double lateFees = db.getTotalLateFees();
		String display = custGenInfo.getText() +
		                 "\n\nNumber of members:\t" + numCust +
		                 "\nNumber active members:\t" + numActiveCust +
		                 "\nNumber revoked members:\t" + numRevokedCust +
		                 "\nTotal outstanding late fees:\t" + lateFees;
		custGenInfo.setText(display);
	}

	// Event for getting customer info on member tab
	// Once pressed, the customer information will display by a
	// memberID search
	public void custEnterID_mouseClicked(MouseEvent e)
	{
		currentCust = db.searchCustomerByID(custIndID.getText());
		String text;
		if(currentCust.getMemberID() != null)
		{
			text = getTextToPrint(currentCust);
		}

		else
		{
			text = "Must enter valid member ID";
		}
		custIndInfo.setText(text);
	}

	// Event for getting customer info on member tab
	// Once pressed, the customer information will display by a
	// member name and phone # search
	public void custEnterName_mouseClicked(MouseEvent e)
	{
		StringTokenizer tokenizer = new StringTokenizer(custIndName.getText(), ",");
		String name = tokenizer.nextToken().trim();
		String phone = tokenizer.nextToken().trim();
		currentCust = db.searchCustomerByNameAndPhone(name, phone);
		String text;
		if(currentCust.getMemberID() != null)
		{
			text = getTextToPrint(currentCust);
		}

		else
		{
			text = "Must enter valid member name and phone number";
		}
		custIndInfo.setText(text);
	}

	// Event for removing a customer on member tab
	// Once pressed, the customer will be removed from
	// the database
	public void custRemove_mouseClicked(MouseEvent e)
	{
		if(currentCust.getMemberID() != null)
		{
			String input = input = JOptionPane.showInputDialog("Are you sure you want to delete this customer from active status? (Enter 'yes' or 'no'");
			if(input.equals("yes"))
			{
				db.removeCustomer(currentCust);
				custIndInfo.setText("Customer removed from active status");
			}
		}

		else
		{
			custIndInfo.setText("Must enter valid member before you can change its status.");
		}
	}

	// Event for updating a customer info on member tab
	// Once pressed, the correct field will be updated
	public void custUpdateInfo_mouseClicked(MouseEvent e)
	{
		if(currentCust.getMemberID() != null)
		{
			if(updateChoice != -1)
			{
				if(updateChoice == 0)
				{
					currentCust.setName(custUpdated.getText());
				}

				if(updateChoice == 1)
				{
					currentCust.setMemberID(custUpdated.getText());
				}

				if(updateChoice == 2)
				{
					currentCust.setPhoneNum(custUpdated.getText());
				}

				if(updateChoice == 3)
				{
					currentCust.setAddress(custUpdated.getText());
				}

				if(updateChoice == 4)
				{
					currentCust.setEmail(custUpdated.getText());
				}

				if(updateChoice == 5)
				{
					StringTokenizer tokenizer = new StringTokenizer(custUpdated.getText(), ",");
					String one;
					String two;
					String three;
					if(tokenizer.hasMoreTokens())
					{
						one = tokenizer.nextToken();
					}

					else
					{
						one = null;
					}

					if(tokenizer.hasMoreTokens())
					{
						two = tokenizer.nextToken();
					}

					else
					{
						two = null;
					}

					if(tokenizer.hasMoreTokens())
					{
						three = tokenizer.nextToken();
					}

					else
					{
						three = null;
					}

					String[] add = {one, two, three};
					currentCust.setAdditionalMembers(add);
				}

				if(updateChoice == 6)
				{
					currentCust.setAccountStatus(custUpdated.getText());
				}

				if(updateChoice == 7)
				{
					int max = Integer.parseInt(custUpdated.getText());
					currentCust.setMaxNumMovies(max);
				}

				if(updateChoice == 8)
				{
					int max = Integer.parseInt(custUpdated.getText());
					currentCust.setMaxNumGames(max);
				}

				if(updateChoice == 9)
				{
					double fee = Double.parseDouble(custUpdated.getText());
					currentCust.setLateFees(fee);
				}

				if(updateChoice == 10)
				{
					int fee = Integer.parseInt(custUpdated.getText());
					currentCust.setTotalLateFeesEver(fee);
				}

				String text = getTextToPrint(currentCust);
				custIndInfo.setText(text);
				updateChoice = -1;
			}

			else
			{
				custCurrent.setText("Enter update choice first!");
			}
		}

		else
		{
			custCurrent.setText("Enter member first!");
		}
	}

	// Event for adding a new customer
	public void custAdd_mouseClicked(MouseEvent e)
	{
		Customer newCust = new Customer();
		String name = JOptionPane.showInputDialog("Enter Name");
		String memberID = JOptionPane.showInputDialog("Enter Member ID");
		String phoneNum = JOptionPane.showInputDialog("Enter Phone Number");
		String address = JOptionPane.showInputDialog("Enter Address");
		String email = JOptionPane.showInputDialog("Enter Email");
		String additionalMembers = JOptionPane.showInputDialog("Enter Additional Members (Use format 'name', 'name', 'name')");
		StringTokenizer tokenizer = new StringTokenizer(additionalMembers, ",");
		String one;
		String two;
		String three;
		if(tokenizer.hasMoreTokens())
		{
			one = tokenizer.nextToken();
		}

		else
		{
			one = null;
		}

		if(tokenizer.hasMoreTokens())
		{
			two = tokenizer.nextToken();
		}

		else
		{
			two = null;
		}

		if(tokenizer.hasMoreTokens())
		{
			three = tokenizer.nextToken();
		}

		else
		{
			three = null;
		}

		String[] add = {one, two, three};
		String maxNumMovies = JOptionPane.showInputDialog("Enter Max Number Movies");
		int movies = Integer.parseInt(maxNumMovies);
		String maxNumGames = JOptionPane.showInputDialog("Enter Max Number Games");
		int games = Integer.parseInt(maxNumGames);

		newCust.setName(name);
		newCust.setMemberID(memberID);
		newCust.setPhoneNum(phoneNum);
		newCust.setAddress(address);
		newCust.setEmail(email);
		newCust.setAccountStatus("active");
		newCust.setAdditionalMembers(add);
		newCust.setMaxNumMovies(movies);
		newCust.setMaxNumGames(games);
		newCust.setLateFees(0.00);
		newCust.setTotalLateFeesEver(0);
		String input = getTextToPrint(newCust);
		custIndInfo.setText(input);
	}

	// Event for updating a store info on store tab
	// Once pressed, the correct field will be updated
	public void storeUpdateInfo_mouseClicked(MouseEvent e)
	{
		if(currentStore.getStoreNum() != null)
		{
			if(updateChoice != -1)
			{
				if(updateChoice == 0)
				{
					currentStore.setStoreNum(storeUpdated.getText());
				}

				if(updateChoice == 1)
				{
					currentStore.setAddress(storeUpdated.getText());
				}

				if(updateChoice == 2)
				{
					currentStore.setPhoneNum(storeUpdated.getText());
				}

				if(updateChoice == 3)
				{
					int policy = Integer.parseInt(storeUpdated.getText());
					currentStore.setBonusPolicyMovie(policy);
				}

				if(updateChoice == 4)
				{
					int policy = Integer.parseInt(storeUpdated.getText());
					currentStore.setBonusPolicyGame(policy);
				}

				if(updateChoice == 5)
				{
					currentStore.setManagerName(storeUpdated.getText());
				}

				if(updateChoice == 6)
				{
					int movies = Integer.parseInt(storeUpdated.getText());
					currentStore.setMoviesRentedDaily(movies);
				}

				if(updateChoice == 7)
				{
					int movies = Integer.parseInt(storeUpdated.getText());
					currentStore.setMoviesRentedMonthly(movies);
				}

				if(updateChoice == 8)
				{
					int movies = Integer.parseInt(storeUpdated.getText());
					currentStore.setMoviesRentedYearly(movies);
				}

				if(updateChoice == 9)
				{
					double fee = Double.parseDouble(custUpdated.getText());
					currentStore.setDailyEarnings(fee);
				}

				if(updateChoice == 10)
				{
					double fee = Double.parseDouble(custUpdated.getText());
					currentStore.setMonthlyEarnings(fee);
				}

				if(updateChoice == 11)
				{
					double fee = Double.parseDouble(custUpdated.getText());
					currentStore.setYearlyEarnings(fee);
				}

				storePrint(currentStore);
				updateChoice = -1;
			}

			else
			{
				storeCurrent.setText("Enter update choice first!");
			}
		}

		else
		{
			storeCurrent.setText("Enter member first!");
		}
	}

	// Event for get general info button on store tab
	// Once pressed, the general information will display
	// More statistics can be added here at any time.
	public void storeGetGen_mouseClicked(MouseEvent e)
	{
		int numStores = db.getNumberStores();
		int rentDaily = db.getRentedDaily();
		int rentMonthly = db.getRentedMonthly();
		int rentYearly = db.getRentedYearly();
		double daily = db.getDailyEarnings();
		double monthly = db.getMonthlyEarnings();
		double yearly = db.getYearlyEarnings();
		String display = "My Store:\t" + store.getStoreNum() +
						"\n\n" + storeGenInfo.getText() +
						"\n\nNumber stores:\t\t" + numStores +
						"\nTotal daily rentals:\t" + rentDaily +
						"\nTotal monthly rentals:\t" + rentMonthly +
						"\nTotal yearly rentals:\t" + rentYearly +
						"\nTotal daily sales:\t" + daily +
						"\nTotal monthly sales:\t" + monthly +
						"\nTotal yearly sales:\t" + yearly;
		storeGenInfo.setText(display);
	}

	// Event for getting store info on store tab
	// Once pressed, the store information will display by a
	// store num search
	public void storeEnterNum_mouseClicked(MouseEvent e)
	{
		currentStore = db.getStoreByStoreNum(storeIndNum.getText());
		if(currentStore.getStoreNum() != null)
		{
			storePrint(store);
		}

		else
		{
			storeInfo.setText("Must enter valid store number.");
		}
	}

	// Event for getting store info on store tab
	// Once pressed, the store information will display for
	// currently logged in store
	public void storeMyEnter_mouseClicked(MouseEvent e)
	{
		storePrint(store);
	}

	// Event for removing a store on store tab
	// Once pressed, the store will be removed from
	// the database
	public void storeRemove_mouseClicked(MouseEvent e)
	{
		if(currentStore.getStoreNum() != null)
		{
			String input = input = JOptionPane.showInputDialog("Are you sure you want to delete this store from active status? (Enter 'yes' or 'no'");
			if(input.equals("yes"))
			{
				db.removeStore(currentStore);
				storeInfo.setText("Store removed from active status");
			}
		}

		else
		{
			storeInfo.setText("Must enter valid store before you can change its status.");
		}
	}

	// Event for adding a new store
	public void storeAdd_mouseClicked(MouseEvent e)
	{
		Store newStore = new Store();
		String num = JOptionPane.showInputDialog("Enter Store Number");
		String managerName = JOptionPane.showInputDialog("Enter Manager Name");
		String phoneNum = JOptionPane.showInputDialog("Enter Phone Number");
		String address = JOptionPane.showInputDialog("Enter Address");
		String theTax = JOptionPane.showInputDialog("Enter Tax (Use format '8.5')");
		double tax = Double.parseDouble(theTax);

		newStore.setStoreNum(num);
		newStore.setBonusPolicyMovie(11);
		newStore.setBonusPolicyGame(1);
		newStore.setAddress(address);
		newStore.setManagerName(managerName);
		newStore.setPhoneNum(phoneNum);
		newStore.setMoviesRentedDaily(0);
		newStore.setMoviesRentedMonthly(0);
		newStore.setMoviesRentedYearly(0);
		newStore.setDailyEarnings(0.00);
		newStore.setMonthlyEarnings(0.00);
		newStore.setYearlyEarnings(0.00);
		newStore.setTax(tax);
		storePrint(newStore);
	}


	// Event for get general info button on merchandise tab
	// Once pressed, the general information will display
	// More statistics can be added here at any time.
	public void merchGetGen_mouseClicked(MouseEvent e)
	{
		int numMoviesRent = db.getNumberMoviesRent();
		int numGamesRent = db.getNumberGamesRent();
		int numMerch = db.getNumberMerchandise();
		int numOrder = db.getNumberMerchandiseOrder();
		int numCandy = db.getNumberCandy();
		int numSnack = db.getNumberSnack();
		int numAudio = db.getNumberAudio();
		int numMovie = db.getNumberMovie();
		int numGame = db.getNumberGame();
		int numPartySupply = db.getNumberPartySupply();
		int numMisc = db.getNumberMisc();
		String display = merchGenInfo.getText() +
						 "\n\nNumber of Movies for Rent:\t\t" + numMoviesRent +
						 "\nNumber of Games for Rent:\t\t" + numGamesRent +
						 "\nNumber of Merchandise for Sale:\t" + numMerch +
						 "\nNumber of Items Needing Ordering:\t" + numOrder +
						 "\nNumber of Candy for Sale:\t\t" + numCandy +
						 "\nNumber of Snacks for Sale:\t\t" + numSnack +
						 "\nNumber of Audio Items for Sale:\t\t" + numAudio +
						 "\nNumber of Movies for Sale:\t\t" + numMovie +
						 "\nNumber of Games for Sale:\t\t" + numGame +
						 "\nNumber of Party Supplies for Sale:\t" + numPartySupply +
						 "\nNumber of Misc Items for Sale:\t\t" + numMisc;
		merchGenInfo.setText(display);
	}

	// Event for first combo box in transaction tab
	// Once choice made, just set itemChoice just to let transTabEnter2_mouseClicked(MouseEvent e)
	// know which alternative to take
	public void transItemChoice_actionPerformed(ActionEvent e)
	{
		int x = transItemChoice.getSelectedIndex();
		if(x == 0)
		{
			transTabSale.setText("Enter rental serial number");
		}

		if(x == 1)
		{
			transTabSale.setText("Enter rental serial number");
		}

		if(x == 2)
		{
			transTabSale.setText("Enter item serial number");
		}

		itemChoice = x;
	}

	// Event for combo box in store tab
	// Once choice made, the current value displays in the following text box
	public void storeUpdateChoice_actionPerformed(ActionEvent e)
	{
		if(currentStore.getStoreNum() == null)
		{
			currentStore = store;
		}

		if(currentStore.getStoreNum() != null)
		{
			int x = storeUpdateChoice.getSelectedIndex();
			if(x == 0)
			{
				storeCurr.setText("Current Store Number");
				storeUp.setText("                                                             Updated Store Number");
				storeCurrent.setText(currentStore.getStoreNum());
			}

			if(x == 1)
			{
				storeCurr.setText("Current Address");
				storeUp.setText("                                                             Updated Address");
				storeCurrent.setText(currentStore.getAddress());
			}

			if(x == 2)
			{
				storeCurr.setText("Current Phone Number");
				storeUp.setText("                                                             Updated Phone Number");
				storeCurrent.setText(currentStore.getPhoneNum());
			}

			if(x == 3)
			{
				storeCurr.setText("Current Movie Bonus Policy");
				storeUp.setText("                                                             Updated Movie Bonus Policy");
				Integer policy = new Integer(currentStore.getBonusPolicyMovie());
				storeCurrent.setText(policy.toString());
			}

			if(x == 4)
			{
				storeCurr.setText("Current Game Bonus Policy");
				storeUp.setText("                                                             Updated Game Bonus Policy");
				Integer policy = new Integer(currentStore.getBonusPolicyGame());
				storeCurrent.setText(policy.toString());
			}

			if(x == 5)
			{
				storeCurr.setText("Current Manager Name");
				storeUp.setText("                                                             Updated Manager Name");
				storeCurrent.setText(currentStore.getManagerName());
			}

			if(x == 6)
			{
				storeCurr.setText("Current Movies Rented Daily");
				storeUp.setText("                                                             Updated Movies Rented Daily");
				Integer movies = new Integer(currentStore.getMoviesRentedDaily());
				storeCurrent.setText(movies.toString());
			}

			if(x == 7)
			{
				storeCurr.setText("Current Movies Rented Monthly");
				storeUp.setText("                                                             Updated Movies Rented Monthly");
				Integer movies = new Integer(currentStore.getMoviesRentedMonthly());
				storeCurrent.setText(movies.toString());
			}

			if(x == 8)
			{
				storeCurr.setText("Current Movies Rented Yearly");
				storeUp.setText("                                                             Updated Movies Rented Yearly");
				Integer movies = new Integer(currentStore.getMoviesRentedYearly());
				storeCurrent.setText(movies.toString());
			}

			if(x == 9)
			{
				storeCurr.setText("Current Daily Earnings");
				storeUp.setText("                                                             Updated Daily Earnings");
				Double earn = new Double(currentStore.getDailyEarnings());
				storeCurrent.setText(earn.toString());
			}

			if(x == 10)
			{
				storeCurr.setText("Current Monthly Earnings");
				storeUp.setText("                                                             Updated Monthly Earnings");
				Double earn = new Double(currentStore.getMonthlyEarnings());
				storeCurrent.setText(earn.toString());
			}

			if(x == 11)
			{
				storeCurr.setText("Current Yearly Earnings");
				storeUp.setText("                                                             Updated Yearly Earnings");
				Double earn = new Double(currentStore.getYearlyEarnings());
				storeCurrent.setText(earn.toString());
			}

			updateChoice = x;
		}

		else
		{
			custCurrent.setText("Enter member first!");
		}
	}

	// Event for combo box in member tab
	// Once choice made, the current value displayes in the following text box
	public void custUpdateChoice_actionPerformed(ActionEvent e)
	{
		if(currentCust.getMemberID() != null)
		{
			int x = custUpdateChoice.getSelectedIndex();
			if(x == 0)
			{
				custCurr.setText("Current Name");
				custUp.setText("                                                             Updated Name");
				custCurrent.setText(currentCust.getName());
			}

			if(x == 1)
			{
				custCurr.setText("Current Member ID");
				custUp.setText("                                                             Updated Member ID");
				custCurrent.setText(currentCust.getMemberID());
			}

			if(x == 2)
			{
				custCurr.setText("Current Phone Number");
				custUp.setText("                                                             Updated Phone Number");
				custCurrent.setText(currentCust.getPhoneNum());
			}

			if(x == 3)
			{
				custCurr.setText("Current Address");
				custUp.setText("                                                             Updated Address");
				custCurrent.setText(currentCust.getAddress());
			}

			if(x == 4)
			{
				custCurr.setText("Current Email");
				custUp.setText("                                                             Updated Email");
				custCurrent.setText(currentCust.getEmail());
			}

			if(x == 5)
			{
				custCurr.setText("Current Additional Members");
				custUp.setText("                                                             Updated Additional Members");
				String additionalMembers = new String();
				for(int i = 0; i < 3; i++)
				{
					String add = currentCust.getAdditionalMembers()[i];
					if(add != null)
					{
						additionalMembers = additionalMembers + "   " + add;
					}
				}
				custCurrent.setText(additionalMembers);
			}

			if(x == 6)
			{
				custCurr.setText("Current Account Status");
				custUp.setText("                                                             Updated Account Status");
				custCurrent.setText(currentCust.getAccountStatus());
			}

			if(x == 7)
			{
				custCurr.setText("Current Max Number Movies");
				custUp.setText("                                                             Updated Max Number Movies");
				Integer max = new Integer(currentCust.getMaxNumMovies());
				custCurrent.setText(max.toString());
			}

			if(x == 8)
			{
				custCurr.setText("Current Max Number Games");
				custUp.setText("                                                             Updated Max Number Games");
				Integer max = new Integer(currentCust.getMaxNumGames());
				custCurrent.setText(max.toString());
			}

			if(x == 9)
			{
				custCurr.setText("Current Late Fees");
				custUp.setText("                                                             Updated Late Fees");
				Double fees = new Double(currentCust.getLateFees());
				custCurrent.setText(fees.toString());
			}

			if(x == 10)
			{
				custCurr.setText("Current Total Late Fees Ever");
				custUp.setText("                                                             Updated Total Late Fees Ever");
				Integer fees = new Integer(currentCust.getTotalLateFeesEver());
				custCurrent.setText(fees.toString());
			}

			updateChoice = x;
		}

		else
		{
			custCurrent.setText("Enter member first!");
		}
	}

	// Event for enter button for items for sale in merchandise tab
	// Once button pressed, the item is found and displayed
	public void merchEnter1_mouseClicked(MouseEvent e)
	{
		currentMerch = db.searchMerchBySerialNum(merchSale.getText());
		if(currentMerch.getSerialNum() != null)
		{
			merchOrMovie = 1;
			merchPrint(currentMerch);
		}

		else
		{
			merchInfo.setText("Must enter valid serial number");
		}
	}

	// Event for enter button for items for rent in merchandise tab
	// Once button pressed, the item is found and displayed
	public void merchEnter2_mouseClicked(MouseEvent e)
	{
		currentMovie = db.searchMovieBySerialNum(merchRent.getText());
		if(currentMovie.getSerialNum() != null)
		{
			merchOrMovie = 2;
			moviePrint(currentMovie);
		}

		else
		{
			merchInfo.setText("Must enter valid serial number");
		}
	}

	// Event for removing merchandise on member tab
	// Once pressed, the customer will be removed from
	// the database
	public void merchRemove_mouseClicked(MouseEvent e)
	{
		if(merchOrMovie == 1)
		{
			Merchandise merch = db.searchMerchBySerialNum(merchSale.getText());
			if(merch.getSerialNum() != null)
			{
				String input = input = JOptionPane.showInputDialog("Are you sure you want to delete this item from active status? (Enter 'yes' or 'no'");
				if(input.equals("yes"))
				{
					db.removeMerchandise(merch);
					merchInfo.setText("Merchandise removed from active status");
				}
			}

			else
			{
				merchInfo.setText("Must enter valid member before you can change its status.");
			}
		}

		if(merchOrMovie == 2)
		{
			Movie movie = db.searchMovieBySerialNum(merchRent.getText());
			if(movie.getSerialNum() != null)
			{
				String input = input = JOptionPane.showInputDialog("Are you sure you want to delete this rental from active status? (Enter 'yes' or 'no'");
				if(input.equals("yes"))
				{
					db.removeMovie(movie);
					merchInfo.setText("Rental removed from active status");
				}
			}

			else
			{
				merchInfo.setText("Must enter valid member before you can change its status.");
			}
		}

		else
		{
			merchInfo.setText("Must enter valid member before you can change its status.");
		}
	}

	// Event for adding a new item for sale
	public void merchAddSale_mouseClicked(MouseEvent e)
	{
		Merchandise newMerchandise = new Merchandise();
		String type = JOptionPane.showInputDialog("Enter Type");
		String UPC = JOptionPane.showInputDialog("Enter UPC");
		String serial = JOptionPane.showInputDialog("Enter serial number");
		String thePrice = JOptionPane.showInputDialog("Enter Price");
		double price = Double.parseDouble(thePrice);
		//String inventory = JOptionPane.showInputDialog("Enter Inventory");
		//int inv = Integer.parseInt(inventory);

		newMerchandise.setType(type);
		newMerchandise.setUPC(UPC);
		newMerchandise.setPrice(price);
		newMerchandise.setInventory(1);
		newMerchandise.setSerialNum(serial);
		merchPrint(newMerchandise);
	}

	// Event for adding a new item for sale
	public void merchAddRent_mouseClicked(MouseEvent e)
	{
		Movie newMovie = new Movie();
		String title = JOptionPane.showInputDialog("Enter Title");
		String UPC = JOptionPane.showInputDialog("Enter UPC");
		String serial = JOptionPane.showInputDialog("Enter serial number");
		String desc = JOptionPane.showInputDialog("Enter Description");
		String format = JOptionPane.showInputDialog("Enter Format");
		String copies = JOptionPane.showInputDialog("Enter Number of Copies");
		int num = Integer.parseInt(copies);
		String lengthRent = JOptionPane.showInputDialog("Enter Length of Rental");
		int length = Integer.parseInt(lengthRent);
		String location = JOptionPane.showInputDialog("Enter Location in Store");
		String thePrice = JOptionPane.showInputDialog("Enter Price");
		double price = Double.parseDouble(thePrice);
		String type = JOptionPane.showInputDialog("Enter Type (either 'video' or 'game')");

		newMovie.setTitle(title);
		newMovie.setUPC(UPC);
		newMovie.setPrice(price);
		newMovie.setFormat(format);
		newMovie.setNumCopies(num);
		newMovie.setAvailable(true);
		newMovie.setLengthRental(length);
		newMovie.setLocation(location);
		newMovie.setType(type);
		newMovie.setDescription(desc);
		newMovie.setSerialNum(serial);
		moviePrint(newMovie);
	}


	// Event for second combo box in transaction tab
	// Once choice made, just set itemChoice just to let transTabEnter2_mouseClicked(MouseEvent e)
	// know which alternative to take
	public void transPaymentChoice_actionPerformed(ActionEvent e)
	{
		int x = transPaymentChoice.getSelectedIndex();
		transPaymentTotal.setText(transactionTotal.toString());

		if((x == 0) || (x == 1) || (x == 3))
		{
			transPayment.setText(transactionTotal.toString());
		}
	}

	// Event for combo box in merchandise tab
	// Once choice made, the current value displayes in the following text box
	public void merchUpdateInfo_mouseClicked(MouseEvent e)
	{
		if(merchOrMovie == 1)
		{
			if(updateChoice != -1)
			{
				if(updateChoice == 1)
				{
					currentMerch.setType(merchUpdated.getText());
				}

				if(updateChoice == 3)
				{
					double price = Double.parseDouble(merchUpdated.getText());
					currentMerch.setPrice(price);
				}

				if(updateChoice == 2)
				{
					currentMerch.setUPC(merchUpdated.getText());
				}

				/*if(updateChoice == 4)
				{
					int inv = Integer.parseInt(merchUpdated.getText());
					currentMerch.setInventory(inv);
				}*/

				if(updateChoice == 4)
				{
					currentMerch.setSerialNum(merchUpdated.getText());
				}

				merchPrint(currentMerch);
				updateChoice = -1;
			}

			else
			{
				merchCurrent.setText("Must enter valid option in combo box");
			}
		}

		if(merchOrMovie == 2)
		{
			if(updateChoice != -1)
			{
				if(updateChoice == 6)
				{
					currentMovie.setTitle(merchUpdated.getText());
				}

				if(updateChoice == 7)
				{
					currentMovie.setUPC(merchUpdated.getText());
				}

				if(updateChoice == 8)
				{
					currentMovie.setDescription(merchUpdated.getText());
				}

				if(updateChoice == 9)
				{
					currentMovie.setFormat(merchUpdated.getText());
				}

				if(updateChoice == 10)
				{
					int num = Integer.parseInt(merchUpdated.getText());
					currentMovie.setNumCopies(num);
				}

				if(updateChoice == 11)
				{
					Boolean avail = new Boolean(merchUpdated.getText());
					currentMovie.setAvailable(avail.booleanValue());
				}

				if(updateChoice == 12)
				{
					double price = Double.parseDouble(merchUpdated.getText());
					currentMovie.setPrice(price);
				}

				if(updateChoice == 13)
				{
					int length = Integer.parseInt(merchUpdated.getText());
					currentMovie.setLengthRental(length);
				}

				if(updateChoice == 14)
				{
					currentMovie.setType(merchUpdated.getText());
				}

				if(updateChoice == 15)
				{
					currentMovie.setLocation(merchUpdated.getText());
				}

				if(updateChoice == 16)
				{
					currentMovie.setSerialNum(merchUpdated.getText());
				}

				moviePrint(currentMovie);
				updateChoice = -1;
			}

			else
			{
				merchCurrent.setText("Must enter valid option in combo box");
			}
		}

		else
		{
			merchCurrent.setText("Blah!");
		}

		merchOrMovie = -1;
	}

	// Event for combo box in merchandise tab
	// Once choice made, the current value displays in the following text box
	public void merchUpdateChoice_actionPerformed(ActionEvent e)
	{
		int x = merchUpdateChoice.getSelectedIndex();
		if(merchOrMovie == 1)
		{
			if(x == 0)
			{
				merchCurrent.setText("Enter valid choice to update");
			}

			if(x == 1)
			{
				merchCurr.setText("       Current Type");
				merchUp.setText("                                                                  Updated Type");
				merchCurrent.setText(currentMerch.getType());
			}

			if(x == 3)
			{
				merchCurr.setText("       Current Price");
				merchUp.setText("                                                                  Updated Price");
				Double price = new Double(currentMerch.getPrice());
				merchCurrent.setText(price.toString());
			}

			if(x == 2)
			{
				merchCurr.setText("       Current UPC");
				merchUp.setText("                                                                  Updated UPC");
				merchCurrent.setText(currentMerch.getUPC());
			}

			/*if(x == 4)
			{
				merchCurr.setText("       Current Inventory");
				merchUp.setText("                                                                  Updated Inventory");
				Integer inv = new Integer(currentMerch.getInventory());
				merchCurrent.setText(inv.toString());
			}*/

			if(x == 4)
			{
				merchCurr.setText("       Current Serial Number");
				merchUp.setText("                                                                  Updated Serial Number");
				merchCurrent.setText(currentMerch.getSerialNum());
			}
		}

		if(merchOrMovie == 2)
		{
			if(x == 5)
			{
				merchCurrent.setText("Enter valid choice to update");
			}

			if(x == 6)
			{
				merchCurr.setText("       Current Title");
				merchUp.setText("                                                                  Updated Title");
				merchCurrent.setText(currentMovie.getTitle());
			}

			if(x == 7)
			{
				merchCurr.setText("       Current UPC");
				merchUp.setText("                                                                  Updated UPC");
				merchCurrent.setText(currentMovie.getUPC());
			}

			if(x == 8)
			{
				merchCurr.setText("       Current Description");
				merchUp.setText("                                                                  Updated Description");
				merchCurrent.setText(currentMovie.getDescription());
			}

			if(x == 9)
			{
				merchCurr.setText("       Current Format");
				merchUp.setText("                                                                  Updated Format");
				merchCurrent.setText(currentMovie.getFormat());
			}

			if(x == 10)
			{
				merchCurr.setText("       Current Number of Copies");
				merchUp.setText("                                                                  Updated Number of Copies");
				Integer num = new Integer(currentMovie.getNumCopies());
				merchCurrent.setText(num.toString());
			}

			if(x == 11)
			{
				merchCurr.setText("       Current Availability");
				merchUp.setText("                                                                  Updated Availability");
				Boolean avail = new Boolean(currentMovie.getAvailable());
				merchCurrent.setText(avail.toString());
			}

			if(x == 12)
			{
				merchCurr.setText("       Current Price");
				merchUp.setText("                                                                  Updated Price");
				Double price = new Double(currentMovie.getPrice());
				merchCurrent.setText(price.toString());
			}

			if(x == 13)
			{
				merchCurr.setText("       Current Length of Rental");
				merchUp.setText("                                                                  Updated Length of Rental");
				Integer length = new Integer(currentMovie.getLengthRental());
				merchCurrent.setText(length.toString());
			}

			if(x == 14)
			{
				merchCurr.setText("       Current Location in Store");
				merchUp.setText("                                                                  Updated Location in Store");
				merchCurrent.setText(currentMovie.getLocation());
			}

			if(x == 15)
			{
				merchCurr.setText("       Current Type");
				merchUp.setText("                                                                  Updated Type");
				merchCurrent.setText(currentMovie.getType());
			}

			if(x == 16)
			{
				merchCurr.setText("       Current Serial Number");
				merchUp.setText("                                                                  Updated Serial Number");
				merchCurrent.setText(currentMovie.getSerialNum());
			}
		}

		updateChoice = x;
	}

	// Function to get customer information for displaying
	public String getTextToPrint(Customer cust)
	{
		String additionalMembers = new String();
		for(int i = 0; i < 3; i++)
		{
			String add = cust.getAdditionalMembers()[i];
			if(add != null)
			{
				additionalMembers = additionalMembers + "   " + add;
			}
		}

		String text = "Name:\t\t" + cust.getName() +
						"\nID Number:\t\t" + cust.getMemberID() +
						"\nPhone #:\t\t" + cust.getPhoneNum() +
						"\nAddress:\t\t" + cust.getAddress() +
						"\nEmail:\t\t" + cust.getEmail() +
						"\nAdditional Members:\t" + additionalMembers +
						"\nAccount Status:\t\t" + cust.getAccountStatus() +
						"\nMax movies at a time:\t" + cust.getMaxNumMovies() +
						"\nMax games at a time:\t" + cust.getMaxNumGames() +
						"\nLate fees:\t\t" + cust.getLateFees() +
						"\nTotal late fees ever:\t" + cust.getTotalLateFeesEver();
		return text;
	}

	// Function to get store information for displaying
	public void storePrint(Store store)
	{
		String text = "Store Num:\t\t\t" + store.getStoreNum() +
					  "\nNumber for Movie Bonus Policy:\t\t" + store.getBonusPolicyMovie() +
					  "\nNumber for Game Bonus Policy:\t" + store.getBonusPolicyGame() +
					  "\nAddress:\t\t\t" + store.getAddress() +
					  "\nManager Name:\t\t" + store.getManagerName() +
					  "\nPhone Number:\t\t\t" + store.getPhoneNum() +
					  "\nMovies Rented Daily:\t\t" + store.getMoviesRentedDaily() +
					  "\nMovies Rented Monthly:\t\t" + store.getMoviesRentedMonthly() +
					  "\nMovies Rented Yearly:\t\t" + store.getMoviesRentedYearly() +
					  "\nDaily Earnings:\t\t\t" + store.getDailyEarnings() +
					  "\nMonthly Earnings:\t\t" + store.getMonthlyEarnings() +
					  "\nYearly Earnings:\t\t" + store.getYearlyEarnings();
		storeInfo.setText(text);
	}

	// Function to get merchandise information for displaying
	public void merchPrint(Merchandise merch)
	{
		String text = "*****************Merchandise Info******************" +
							 	  "\n\nType:\t" + merch.getType() +
							 	  "\nUPC:\t" + merch.getUPC() +
							 	  "\nPrice:\t" + merch.getPrice() +
							 	  //"\nInventory:\t" + merch.getInventory() +
							 	  "\nSerial Number:\t" + merch.getSerialNum();
		merchInfo.setText(text);
	}

	// Function to get movie information for displaying
	public void moviePrint(Movie currentMovie)
	{
		String text = "Title:\t\t" + currentMovie.getTitle() +
							  "\nSerial Number:\t\t" + currentMovie.getSerialNum() +
							  "\nUPC:\t\t" + currentMovie.getUPC() +
							  "\nDescription:\t\t" + currentMovie.getDescription() +
							  "\nFormat:\t\t" + currentMovie.getFormat() +
							  "\nNumber of Copies:\t" + currentMovie.getNumCopies() +
							  "\nAvailable:\t\t" + currentMovie.getAvailable() +
							  "\nPrice:\t\t" + currentMovie.getPrice() +
							  "\nLength of Rental:\t" + currentMovie.getLengthRental() +
							  "\nLocation in Store:\t" + currentMovie.getLocation() +
							  "\nType:\t\t" + currentMovie.getType();
		merchInfo.setText(text);
	}

	public void login()
	{
		int count = 0;
		myStoreNum  = JOptionPane.showInputDialog("Enter Store Number");
		store = db.getStoreByStoreNum(myStoreNum);
		while(count < 3)
		{
			if(store.getStoreNum() != null)
			{
				break;
			}

			else
			{
				myStoreNum = JOptionPane.showInputDialog("Try Store Number Again");
			}

			if(count == 2)
			{
				System.out.println("Failed to enter valid store number.  Exiting Program...");
				System.exit(1);
			}
			count++;
		}

		count = 0;
		String password = JOptionPane.showInputDialog("Enter Password (for this demo, enter 'a')");
		while(count < 3)
		{
			if(password.equals("a"))
			{
				break;
			}

			else
			{
				password = JOptionPane.showInputDialog("Try Password Again (for this demo, enter 'a')");
			}

			if(count == 2)
			{
				System.out.println("Failed to enter correct password.  Exiting Program...");
				System.exit(1);
			}
			count++;
		}
	}

	// Main to run GUI
	public static void main(String[] args)
	{
		new GUI();
	}
}
