/*
* Title: OtterLibrarySystemFrame.java
* Abstract: This file includes all the frame and all panels of this program.
* Author: Marcus Dixon
* ID: 0721
* Date: 5/10/2015
*/

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;



public class OtterLibrarySystemFrame extends JFrame
{
	OtterLibrarySystem a = new OtterLibrarySystem();
	
	private boolean flag = false;
	
	private JComboBox monthComboBox1, yearComboBox1, dayComboBox1, timeComboBox1,
						monthComboBox2, yearComboBox2, dayComboBox2, timeComboBox2;
	
	DecimalFormat df = new DecimalFormat("0.00");
	
	private JList bookList, reList;
	 
    JPanel panel1 = new OtterLibrarySystemPanel();
    JPanel panel2 = new CreateAccountPanel();
    JPanel panel3 = new PlaceHoldPanel();
    JPanel panel4 = new CancelHoldPanel();
    JPanel panel5 = new ManageSystemPanel();
    JPanel suc = new SuccessPanel();
    JPanel login = new LogInPanel();
    JPanel phlogin = new PHLogInPanel();
    JPanel ch = new ConfirmHoldPanel();
    JPanel nFP = new nameFailPanel();
    JPanel nFP2 = new nameFailPanel2();
    JPanel DLP = new DisplayLogPanel();
    JPanel ABP = new AddBookPanel();
    JPanel TRP1 = new TimeRentPanel1();
    JPanel TRP2 = new TimeRentPanel2();
    JPanel CH = new CHLogInPanel();
    JPanel cFP = new copyFailPanel();
    JPanel cFP2 = new copyFailPanel2();
    JPanel msFP1 = new msFailPanel1();
    JPanel msFP2 = new msFailPanel2();
    JPanel ABGP = new AddBookGoodPanel();
    JPanel ABFP = new AddBookFailPanel();
    JPanel CHFP1 = new CHFailPanel1();
    JPanel CHFP2 = new CHFailPanel2();
    JPanel CHFP3 = new CHFailPanel3();
    JPanel CHGP = new CHGoodPanel();
    JPanel DFP11 = new DateFailPanel11();
    JPanel DFP12 = new DateFailPanel12();
    JPanel DFP21 = new DateFailPanel21();
    JPanel DFP22 = new DateFailPanel22();
    JPanel WFP = new WeekFailPanel();
    JPanel PHGP = new PHGoodPanel();
    JPanel NBFP = new NoBookFailPanel();
    JPanel PHFP1 = new PHFailPanel1();
    JPanel PHFP2 = new PHFailPanel2();
    
    private String month1, month2, day1, day2, year1, year2, hour1, hour2, ausername, abook, CHusername;
    
    private JTextField 	text1, text2, username, password, btitle, bauthor, bisbn, bfee,
						mUsername, mPassword, phUsername, phPassword, CHUsername, CHPassword;
    
	private JTextArea dLog, bLog, chold;
   	
    public OtterLibrarySystemFrame()
    {
        setTitle("Otter Library System");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel1);
        this.pack();
        centerWindow(this);
        setSize(500, 300);
    }
    
    private GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int anchor)
    {
    	GridBagConstraints c = new GridBagConstraints();
    	c.insets = new Insets(5, 5, 5, 5);
    	c.ipadx = 0;
    	c.ipady = 0;
    	c.gridx = gridx;
    	c.gridy = gridy;
    	c.gridwidth = gridwidth;
    	c.gridheight = gridheight;
    	c.anchor = anchor;
    	return c;
    }

    private void centerWindow(Window w)
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width-w.getWidth())/2, (d.height-w.getHeight())/2);
    }
    
    private void panelswitch(JPanel panel1, JPanel panel2)
    {
    	this.remove(panel1);
    	this.add(panel2);
    	this.pack();
    	setSize(500, 300);
    }
    
    public class OtterLibrarySystemPanel extends JPanel
    {
    	public OtterLibrarySystemPanel()
    	{
    		setLayout(new GridBagLayout());
    		//setBackground(Color.);
    		
    		JLabel tiitle = new JLabel("Otter Library System");
    		JButton createAccountButton = new JButton("Create Account");
    		JButton placeHoldButton = new JButton("Place Hold");
    		JButton cancelHoldButton = new JButton("Cancel Hold");
    		JButton manageSystemButton = new JButton("Manage System");
    		
    		OtterLibrarySystemListener buttonEar = new OtterLibrarySystemListener();
    		
    		createAccountButton.addActionListener(buttonEar);
    		placeHoldButton.addActionListener(buttonEar);
    		cancelHoldButton.addActionListener(buttonEar);
    		manageSystemButton.addActionListener(buttonEar);
    		
    		add(tiitle, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(createAccountButton, getConstraints(0,1,3,1,GridBagConstraints.CENTER));
    		add(placeHoldButton, getConstraints(0,2,3,1,GridBagConstraints.CENTER));
    		add(cancelHoldButton, getConstraints(0,3,3,1,GridBagConstraints.CENTER));
    		add(manageSystemButton, getConstraints(0,4,3,1,GridBagConstraints.CENTER));
    		
    	}
    }
    
    public class OtterLibrarySystemListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		String actionCommand = e.getActionCommand();
    		
    		if (actionCommand.equals("Create Account"))
    		{
    			text1.setText("");
    			text2.setText("");
    			panel1.setVisible(false);
    			panelswitch(panel1, panel2);
    			panel2.setVisible(true);
    			
    		}
    		else if (actionCommand.equals("Place Hold"))
    		{
    			panel1.setVisible(false);
    			panelswitch(panel1, TRP1);
    			TRP1.setVisible(true);
    		}
    		else if (actionCommand.equals("Cancel Hold"))
    		{
    			panel1.setVisible(false);
    			panelswitch(panel1, CH);
    			CH.setVisible(true);
    		}
    		else if (actionCommand.equals("Manage System"))
    		{
    			panel1.setVisible(false);
    			panelswitch(panel1, login);
    			login.setVisible(true);
    		}
    		else
    		{
    			
    		}
    	}
    }

    public class CreateAccountPanel extends JPanel
    {
    	public CreateAccountPanel()
    	{
    		setLayout(new GridBagLayout());
    		
    		text1 = new JTextField(30);
    		text2 = new JTextField(30);
    		
    		JLabel makeAccount = new JLabel("Create Account");
    		JLabel usename = new JLabel("Username:");
    		JLabel pasword = new JLabel("Password:");
    		JButton createAccountButton = new JButton("Create the Account");
    		JButton mainMenuButton = new JButton("Main Menu");
    		
    		CreateAccountListener buttonEar = new CreateAccountListener();
    		
    		
    		createAccountButton.addActionListener(buttonEar);
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(makeAccount, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(usename, getConstraints(0,1,1,1,GridBagConstraints.EAST));
    		add(pasword, getConstraints(0,2,1,1,GridBagConstraints.EAST));
    		add(text1, getConstraints(1,1,2,1,GridBagConstraints.WEST));
    		add(text2, getConstraints(1,2,2,1,GridBagConstraints.WEST));
    		add(createAccountButton, getConstraints(1,5,1,1,GridBagConstraints.EAST));
    		add(mainMenuButton, getConstraints(2,5,1,1,GridBagConstraints.CENTER));
    	}
    }

    public class CreateAccountListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		String actionCommand = e.getActionCommand();
    		
    		if (actionCommand.equals("Create the Account"))
    		{
    			String tmp = a.createAccount(text1.getText(), text2.getText());
    			
    			if (tmp.equals("ok"))
    			{
    				panel2.setVisible(false);
    				panelswitch(panel2, suc);
    				suc.setVisible(true);
    			}
    			else if (tmp.equals("fn"))
    			{
    				if(flag)
    				{
    					panel2.setVisible(false);
    					panelswitch(panel2, nFP2);
    					nFP2.setVisible(true);
    					flag = false;
    				}
    				else
    				{
    					panel2.setVisible(false);
    					panelswitch(panel2, nFP);
    					nFP.setVisible(true);
    					flag = true;
    				}
    			}
    			else if (tmp.equals("cF"))
    			{
    				if(flag)
    				{
    					panel2.setVisible(false);
    					panelswitch(panel2, cFP2);
    					cFP2.setVisible(true);
    					flag = false;
    				}
    				else
    				{
        				panel2.setVisible(false);
        				panelswitch(panel2, cFP);
        				cFP.setVisible(true);
    					flag = true;
    				}
    			}
    		}
    		else if (actionCommand.equals("Main Menu"))
    		{
    			panel2.setVisible(false);
    			panelswitch(panel2, panel1);
    			panel1.setVisible(true);
    			flag = false;
    		}
    		else if (actionCommand.equals("Main Menu "))
    		{
    			suc.setVisible(false);
    			panelswitch(suc, panel1);
    			panel1.setVisible(true);
    			flag = false;
    		}
    		else if (actionCommand.equals("OK"))
    		{
    			text1.setText("");
    			text2.setText("");
    			nFP.setVisible(false);
    			panelswitch(nFP, panel2);
    			panel2.setVisible(true);
    		}
    		else if (actionCommand.equals("OK "))
    		{
    			text1.setText("");
    			text2.setText("");
    			cFP.setVisible(false);
    			panelswitch(cFP, panel2);
    			panel2.setVisible(true);
    		}
    		else if (actionCommand.equals(" Main Menu"))
    		{
    			nFP.setVisible(false);
    			panelswitch(nFP, panel1);
    			panel1.setVisible(true);
    			flag = false;
    		}
    		else if (actionCommand.equals(" Main Menu "))
    		{
    			cFP.setVisible(false);
    			panelswitch(cFP, panel1);
    			panel1.setVisible(true);
    			flag = false;
    		}
    		else if (actionCommand.equals("  Main Menu"))
    		{
    			nFP2.setVisible(false);
    			panelswitch(nFP2, panel1);
    			panel1.setVisible(true);
    			flag = false;
    		}
    		else if (actionCommand.equals("Main Menu  "))
    		{
    			cFP2.setVisible(false);
    			panelswitch(cFP2, panel1);
    			panel1.setVisible(true);
    			flag = false;
    		}
    		else
    		{
    			System.out.println("error");
    		}
    	}
    }
    
    public class SuccessPanel extends JPanel
    {
    	public SuccessPanel()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel accountSuccess = new JLabel("Account Created Successfully");
    		JButton mainMenuButton = new JButton("Main Menu ");
    		
    		CreateAccountListener buttonEar = new CreateAccountListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(accountSuccess, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(1,5,1,1,GridBagConstraints.EAST));
    	}
    }
    
    public class nameFailPanel extends JPanel
    {    	
    	public nameFailPanel()
    	{
    		setLayout(new GridBagLayout());
    		//setBackground(Color.red);
    		
    		JLabel fail = new JLabel("Account Not Created. Username and/or password incorrect format");
    		JLabel fail2 = new JLabel("1 symbol (!, @, #, or $), 1 number, and 3 letters");
    		JButton okayButton = new JButton("OK");
    		JButton mainMenuButton = new JButton(" Main Menu");
    		
    		CreateAccountListener buttonEar = new CreateAccountListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		okayButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,4,1,GridBagConstraints.CENTER));
    		add(fail2, getConstraints(0,1,4,1,GridBagConstraints.CENTER));
    		add(okayButton, getConstraints(0,2,1,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(1,2,2,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class nameFailPanel2 extends JPanel
    {    	
    	public nameFailPanel2()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("Account Not Created. Username and/or password incorrect format");
    		JLabel fail2 = new JLabel("1 symbol (!, @, #, or $), 1 number, and 3 letters");
    		JButton mainMenuButton = new JButton("  Main Menu");
    		
    		CreateAccountListener buttonEar = new CreateAccountListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(fail2, getConstraints(0,1,3,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(0,2,3,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class copyFailPanel extends JPanel
    {
    	public copyFailPanel()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("Account Not Created. Username already exists");
    		JButton okayButton = new JButton("OK ");
    		JButton mainMenuButton = new JButton(" Main Menu ");
    		
    		CreateAccountListener buttonEar = new CreateAccountListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		okayButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,4,1,GridBagConstraints.CENTER));
    		add(okayButton, getConstraints(0,2,1,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(1,2,2,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class copyFailPanel2 extends JPanel
    {
    	public copyFailPanel2()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("Account Not Created. Username already exists");
    		JButton mainMenuButton = new JButton("Main Menu  ");
    		
    		CreateAccountListener buttonEar = new CreateAccountListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(0,2,3,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class TimeRentPanel1 extends JPanel
    {
    	public TimeRentPanel1()
    	{
    		setLayout(new GridBagLayout());
    		
    		String[] months = { "January", "February", "March", "April", "May", "June",
    							"July", "August", "September", "October", "November", "December" };
    		
    		String[] years = {"2015", "2016", "2017", "2018", "2019", "2020",};
    		
    		String[] days = {	"1", "2", "3", "4", "5", "6", "7", "8", "9",
    							"10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
    							"20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
    							"30", "31"};
    		
    		String[] times = {	"7 AM", "8 AM", "9 AM", "10 AM", "11 AM",
    							"12 PM", "1 PM", "2 PM", "3 PM", "4 PM", "5 PM", "6 PM", "7 PM", "8 PM"};
    		
    		JButton confirmTimeButton = new JButton("Confirm");
    		JButton mainMenuButton = new JButton(" Main Menu");
    		JLabel makeAccount = new JLabel("Select a time for pick up");
    		
    		PlaceHoldListener buttonEar = new PlaceHoldListener();
    		monthComboBox1 = new JComboBox(months);
    		dayComboBox1 = new JComboBox(days);
    		yearComboBox1 = new JComboBox(years);
    		timeComboBox1 = new JComboBox(times);
    		
    		mainMenuButton.addActionListener(buttonEar);
    		confirmTimeButton.addActionListener(buttonEar);
    		
    		add(makeAccount, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(monthComboBox1, getConstraints(1,3,1,1, GridBagConstraints.WEST));
    		add(dayComboBox1, getConstraints(2,3,1,1, GridBagConstraints.WEST));
    		add(yearComboBox1, getConstraints(3,3,1,1, GridBagConstraints.WEST));
    		add(timeComboBox1, getConstraints(4,3,1,1, GridBagConstraints.WEST));
    		add(confirmTimeButton, getConstraints(1,5,1,1,GridBagConstraints.EAST));
    		add(mainMenuButton, getConstraints(3,5,2,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class TimeRentPanel2 extends JPanel
    {
    	public TimeRentPanel2()
    	{
    		setLayout(new GridBagLayout());
    		
    		String[] months = { "January", "February", "March", "April", "May", "June",
    							"July", "August", "September", "October", "November", "December" };
    		
    		String[] years = {"2015", "2016", "2017", "2018", "2019", "2020",};
    		
    		String[] days = {	"1", "2", "3", "4", "5", "6", "7", "8", "9",
    							"10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
    							"20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
    							"30", "31"};
    		
    		String[] times = {	"7 AM", "8 AM", "9 AM", "10 AM", "11 AM",
    							"12 PM", "1 PM", "2 PM", "3 PM", "4 PM", "5 PM", "6 PM", "7 PM", "8 PM"};
    		
    		JButton confirmTimeButton = new JButton("Confirm ");
    		JButton mainMenuButton = new JButton(" Main Menu ");
    		JLabel makeAccount = new JLabel("Select a time to return");
    		
    		PlaceHoldListener buttonEar = new PlaceHoldListener();
    		monthComboBox2 = new JComboBox(months);
    		dayComboBox2 = new JComboBox(days);
    		yearComboBox2 = new JComboBox(years);
    		timeComboBox2 = new JComboBox(times);
    		
    		mainMenuButton.addActionListener(buttonEar);
    		confirmTimeButton.addActionListener(buttonEar);
    		
    		add(makeAccount, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(monthComboBox2, getConstraints(1,3,1,1, GridBagConstraints.WEST));
    		add(dayComboBox2, getConstraints(2,3,1,1, GridBagConstraints.WEST));
    		add(yearComboBox2, getConstraints(3,3,1,1, GridBagConstraints.WEST));
    		add(timeComboBox2, getConstraints(4,3,1,1, GridBagConstraints.WEST));
    		add(confirmTimeButton, getConstraints(1,5,1,1,GridBagConstraints.EAST));
    		add(mainMenuButton, getConstraints(3,5,2,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class DateFailPanel11 extends JPanel
    {
    	public DateFailPanel11()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("Date entered is not valid.");
    		JButton okayButton = new JButton("OK");
    		JButton mainMenuButton = new JButton("Main Menu");
    		
    		PlaceHoldListener buttonEar = new PlaceHoldListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		okayButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,4,1,GridBagConstraints.CENTER));
    		add(okayButton, getConstraints(0,2,1,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(1,2,2,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class DateFailPanel12 extends JPanel
    {
    	public DateFailPanel12()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("Date entered is not valid.");
    		JButton mainMenuButton = new JButton("Main Menu");
    		
    		PlaceHoldListener buttonEar = new PlaceHoldListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(0,2,3,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class DateFailPanel21 extends JPanel
    {
    	public DateFailPanel21()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("Date entered is not valid.");
    		JButton okayButton = new JButton("OK ");
    		JButton mainMenuButton = new JButton("Main Menu");
    		
    		PlaceHoldListener buttonEar = new PlaceHoldListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		okayButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,4,1,GridBagConstraints.CENTER));
    		add(okayButton, getConstraints(0,2,1,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(1,2,2,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class DateFailPanel22 extends JPanel
    {
    	public DateFailPanel22()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("Date entered is not valid.");
    		JButton mainMenuButton = new JButton("Main Menu");
    		
    		PlaceHoldListener buttonEar = new PlaceHoldListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(0,2,3,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class NoBookFailPanel extends JPanel
    {
    	public NoBookFailPanel()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("No book to reserve.");
    		JButton mainMenuButton = new JButton("Main Menu");
    		
    		PlaceHoldListener buttonEar = new PlaceHoldListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(0,2,3,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class WeekFailPanel extends JPanel
    {
    	public WeekFailPanel()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("Books can't be reserved more than 7 days.");
    		JButton okayButton = new JButton(" OK");
    		JButton mainMenuButton = new JButton("Main Menu");
    		
    		PlaceHoldListener buttonEar = new PlaceHoldListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		okayButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,4,1,GridBagConstraints.CENTER));
    		add(okayButton, getConstraints(0,2,1,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(1,2,2,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class PlaceHoldPanel extends JPanel
    {
    	
    	public PlaceHoldPanel()
    	{
    		setLayout(new GridBagLayout());
    		
    		bookList = new JList();
    		
    		JLabel placeHold = new JLabel("Choose a book to hold");
    		JButton placeHoldButton = new JButton("place hold");
    		JButton mainMenuButton = new JButton("Main Menu");
    		
    		PlaceHoldListener buttonEar = new PlaceHoldListener();
    		
    		placeHoldButton.addActionListener(buttonEar);
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(bookList, getConstraints(1,1,4,1,GridBagConstraints.WEST));
    		add(placeHold, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(placeHoldButton, getConstraints(1,5,1,1,GridBagConstraints.EAST));
    		add(mainMenuButton, getConstraints(3,5,2,1,GridBagConstraints.CENTER));
    	}
    }

    public class PlaceHoldListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		String actionCommand = e.getActionCommand();
    		
    		if (actionCommand.equals("place hold"))
    		{
    			abook = a.getbookname(bookList.getSelectedIndex());
    			
    			panel3.setVisible(false);
    			panelswitch(panel3, phlogin);
    			phlogin.setVisible(true);
    		}
    		else if (actionCommand.equals("Main Menu"))
    		{
    			NBFP.setVisible(false);
    			PHGP.setVisible(false);
    			WFP.setVisible(false);
    			DFP11.setVisible(false);
    			DFP12.setVisible(false);
    			DFP21.setVisible(false);
    			DFP21.setVisible(false);
    			DFP22.setVisible(false);
    			panel3.setVisible(false);
    			panelswitch(panel3, panel1);
    			panel1.setVisible(true);
    			flag = false;
    		}
      		else if (actionCommand.equals("Confirm"))
    		{
      			month1 = monthComboBox1.getSelectedItem().toString();
      			day1 = dayComboBox1.getSelectedItem().toString();
      			year1 = yearComboBox1.getSelectedItem().toString();
      			hour1 = timeComboBox1.getSelectedItem().toString();
      			
      			if(a.checkDate(month1, day1, year1))
      			{
        			TRP1.setVisible(false);
        			panelswitch(TRP1, TRP2);
        			TRP2.setVisible(true);
        			flag = false;
      			}
      			else
      			{
    				if(flag)
    				{
    					TRP1.setVisible(false);
    					panelswitch(TRP1, DFP12);
    					DFP12.setVisible(true);
    					flag = false;
    				}
    				else
    				{
    					TRP1.setVisible(false);
    					panelswitch(TRP1, DFP11);
    					DFP11.setVisible(true);
    					flag = true;
    				}
      			}
      			

    		}
      		else if (actionCommand.equals("Confirm "))
    		{
      			month2 = monthComboBox2.getSelectedItem().toString();
      			day2 = dayComboBox2.getSelectedItem().toString();
      			year2 = yearComboBox2.getSelectedItem().toString();
      			hour2 = timeComboBox2.getSelectedItem().toString();
      			
      			if(a.checkBook())
      			{
  					TRP2.setVisible(false);
  					panelswitch(TRP2, NBFP);
  					NBFP.setVisible(true);
      			}
      			else
      			{
      				if(a.checkDate(month2, day2, year2))
      				{
      					if(a.checkWeek(month1, day1, year1, hour1, month2, day2, year2, hour2))
      					{
      						String[] tmpp = a.getBookLog();
      				
      						bookList.setListData(tmpp);
      						
      						TRP2.setVisible(false);
      						panelswitch(TRP2, panel3);
      						panel3.setVisible(true);
      						flag = false;
      					}
      					else
      					{
      						TRP2.setVisible(false);
      						panelswitch(TRP2, WFP);
      						WFP.setVisible(true);
      					}
      				}
      				else
      				{
      					if(flag)
      					{
      						TRP2.setVisible(false);
      						panelswitch(TRP2, DFP22);
      						DFP22.setVisible(true);
      						flag = false;
      					}
      					else
      					{
      						TRP2.setVisible(false);
    						panelswitch(TRP2, DFP21);
    						DFP21.setVisible(true);
    						flag = true;
      					}
      				}
      			}
    		}
    		else if (actionCommand.equals("Confirm Hold"))
    		{
    			a.setReserve(ausername, abook);
    			
    			ch.setVisible(false);
    			panelswitch(ch, PHGP);
    			PHGP.setVisible(true);
    		}
       		else if (actionCommand.equals("OK"))
    		{
       			DFP11.setVisible(false);
    			panelswitch(DFP11, TRP1);
    			TRP1.setVisible(true);
    		}
       		else if (actionCommand.equals("OK "))
    		{
       			DFP21.setVisible(false);
    			panelswitch(DFP21, TRP2);
    			TRP2.setVisible(true);
    		}
       		else if (actionCommand.equals(" OK"))
    		{
       			WFP.setVisible(false);
    			panelswitch(WFP, TRP1);
    			TRP1.setVisible(true);
    		}
    		else if (actionCommand.equals("Main Menu "))
    		{
    			ch.setVisible(false);
    			panelswitch(ch, panel1);
    			panel1.setVisible(true);
    		}
    		else if (actionCommand.equals(" Main Menu"))
    		{
    			TRP1.setVisible(false);
    			panelswitch(TRP1, panel1);
    			panel1.setVisible(true);
    			flag = false;
    		}
       		else if (actionCommand.equals(" Main Menu "))
    		{
    			TRP2.setVisible(false);
    			panelswitch(TRP2, panel1);
    			panel1.setVisible(true);
    			flag = false;
    		}
    		else
    		{
    			
    		}
    	}
    }
    
    public class PHLogInPanel extends JPanel
    {    	
    	public PHLogInPanel()
    	{
    		setLayout(new GridBagLayout());
    		
    		phUsername = new JTextField(30);
    		phPassword = new JTextField(30);
    		
    		JLabel makeAccount = new JLabel("Log In");
    		JLabel usename = new JLabel("Username:");
    		JLabel pasword = new JLabel("Password:");
    		JButton LogInButton = new JButton("Log In ");
    		JButton mainMenuButton = new JButton("Main Menu ");
    		
    		LogInListener buttonEar = new LogInListener();
    		
    		LogInButton.addActionListener(buttonEar);
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(makeAccount, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(usename, getConstraints(0,1,1,1,GridBagConstraints.EAST));
    		add(pasword, getConstraints(0,2,1,1,GridBagConstraints.EAST));
    		add(phUsername, getConstraints(1,1,2,1,GridBagConstraints.WEST));
    		add(phPassword, getConstraints(1,2,2,1,GridBagConstraints.WEST));
    		add(LogInButton, getConstraints(1,5,1,1,GridBagConstraints.EAST));
    		add(mainMenuButton, getConstraints(2,5,1,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class PHFailPanel1 extends JPanel
    {
    	public PHFailPanel1()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("Information entered is not valid.");
    		JButton okayButton = new JButton("OK ");
    		JButton mainMenuButton = new JButton("Main Menu");
    		
    		LogInListener buttonEar = new LogInListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		okayButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,4,1,GridBagConstraints.CENTER));
    		add(okayButton, getConstraints(0,2,1,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(1,2,2,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class PHFailPanel2 extends JPanel
    {
    	public PHFailPanel2()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("Information entered is not valid.");
    		JButton mainMenuButton = new JButton("Main Menu");
    		
    		LogInListener buttonEar = new LogInListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(0,2,3,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class ConfirmHoldPanel extends JPanel
    {
    	
    	public ConfirmHoldPanel()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel makeAccount = new JLabel("Confrim Hold");
    		chold = new JTextArea("");
    		JButton confirmHoldButton = new JButton("Confirm Hold");
    		JButton mainMenuButton = new JButton("Main Menu ");
    		
    		PlaceHoldListener buttonEar = new PlaceHoldListener();
    		
    		confirmHoldButton.addActionListener(buttonEar);
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(makeAccount, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(chold, getConstraints(0,1,5,1,GridBagConstraints.CENTER));
    		add(confirmHoldButton, getConstraints(0,3,1,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(2,3,1,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class PHGoodPanel extends JPanel
    {
    	public PHGoodPanel()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("Book has been reserved.");
    		JButton mainMenuButton = new JButton("Main Menu");
    		
    		PlaceHoldListener buttonEar = new PlaceHoldListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(0,2,3,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class CHLogInPanel extends JPanel
    {    	
    	public CHLogInPanel()
    	{
    		setLayout(new GridBagLayout());
    		
    		CHUsername = new JTextField(30);
    		CHPassword = new JTextField(30);
    		
    		JLabel makeAccount = new JLabel("Log In");
    		JLabel usename = new JLabel("Username:");
    		JLabel pasword = new JLabel("Password:");
    		JButton LogInButton = new JButton(" Log In ");
    		JButton mainMenuButton = new JButton(" Main Menu ");
    		
    		LogInListener buttonEar = new LogInListener();
    		
    		LogInButton.addActionListener(buttonEar);
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(makeAccount, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(usename, getConstraints(0,1,1,1,GridBagConstraints.EAST));
    		add(pasword, getConstraints(0,2,1,1,GridBagConstraints.EAST));
    		add(CHUsername, getConstraints(1,1,2,1,GridBagConstraints.WEST));
    		add(CHPassword, getConstraints(1,2,2,1,GridBagConstraints.WEST));
    		add(LogInButton, getConstraints(1,5,1,1,GridBagConstraints.EAST));
    		add(mainMenuButton, getConstraints(2,5,1,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class CHFailPanel1 extends JPanel
    {
    	public CHFailPanel1()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("Information entered is not valid.");
    		JButton okayButton = new JButton("OK");
    		JButton mainMenuButton = new JButton(" Main Menu");
    		
    		CancelHoldListener buttonEar = new CancelHoldListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		okayButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,4,1,GridBagConstraints.CENTER));
    		add(okayButton, getConstraints(0,2,1,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(1,2,2,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class CHFailPanel2 extends JPanel
    {
    	public CHFailPanel2()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("Information entered is not valid.");
    		JButton mainMenuButton = new JButton("Main Menu ");
    		
    		CancelHoldListener buttonEar = new CancelHoldListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(0,2,3,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class CHFailPanel3 extends JPanel
    {
    	public CHFailPanel3()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("Username doesn't have any reservations.");
    		JButton mainMenuButton = new JButton(" Main Menu ");
    		
    		CancelHoldListener buttonEar = new CancelHoldListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(0,2,3,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class CHGoodPanel extends JPanel
    {
    	public CHGoodPanel()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("Reservation cancelled.");
    		JButton mainMenuButton = new JButton("  Main Menu");
    		
    		CancelHoldListener buttonEar = new CancelHoldListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(0,2,3,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class CancelHoldPanel extends JPanel
    {

    	
    	public CancelHoldPanel()
    	{
    		setLayout(new GridBagLayout());
    		
    		reList = new JList();
    		
    		JLabel fail = new JLabel("Choose a book to cancel.");
    		JButton cancelHoldButton = new JButton("Cancel Hold");
    		JButton mainMenuButton = new JButton("Main Menu");
    		
    		CancelHoldListener buttonEar = new CancelHoldListener();
    		
    		cancelHoldButton.addActionListener(buttonEar);
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,4,1,GridBagConstraints.CENTER));
    		add(reList, getConstraints(0,1,4,1,GridBagConstraints.CENTER));
    		add(cancelHoldButton, getConstraints(0,2,2,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(2,2,2,1,GridBagConstraints.CENTER));
    	}
    }

    public class CancelHoldListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		String actionCommand = e.getActionCommand();
    		
    		if (actionCommand.equals("Cancel Hold"))
    		{
    			if(reList.getSelectedIndex() > reList.getMaxSelectionIndex())
    			{
    				
    			}
    			else if(reList.isSelectionEmpty())
    			{
    				
    			}
    			else
    			{
    				a.canReserve(CHusername, reList.getSelectedValue().toString());
    			
    				panel4.setVisible(false);
    				panelswitch(panel4, CHGP);
    				CHGP.setVisible(true);
    			}
    		}
    		else if (actionCommand.equals("OK"))
    		{
    			CHFP1.setVisible(false);
    			panelswitch(CHFP1, CH);
    			CH.setVisible(true);
    		}
    		else if (actionCommand.equals("Main Menu"))
    		{
    			panel4.setVisible(false);
    			panelswitch(panel4, panel1);
    			panel1.setVisible(true);
    		}
    		else if (actionCommand.equals(" Main Menu"))
    		{
    			CHFP1.setVisible(false);
    			panelswitch(CHFP1, panel1);
    			panel1.setVisible(true);
    			flag = false;
    		}
    		else if (actionCommand.equals("Main Menu "))
    		{
    			CHFP2.setVisible(false);
    			panelswitch(CHFP2, panel1);
    			panel1.setVisible(true);
    		}
    		else if (actionCommand.equals(" Main Menu "))
    		{
    			CHFP3.setVisible(false);
    			panelswitch(CHFP3, panel1);
    			panel1.setVisible(true);
    		}
    		else if (actionCommand.equals("  Main Menu"))
    		{
    			CHGP.setVisible(false);
    			panelswitch(CHGP, panel1);
    			panel1.setVisible(true);
    		}
    		else
    		{

    		}
    	}
    }
    
    public class ManageSystemPanel extends JPanel
    {	
    	public ManageSystemPanel()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel makeAccount = new JLabel("Manage System");
    		JButton displayLogButton = new JButton("Display Log");
    		JButton addNewBookButton = new JButton("Add New Book");
    		JButton mainMenuButton = new JButton("Main Menu");
    		
    		ManageSystemListener buttonEar = new ManageSystemListener();
    		
    		displayLogButton.addActionListener(buttonEar);
    		addNewBookButton.addActionListener(buttonEar);
    		mainMenuButton.addActionListener(buttonEar);

    		add(makeAccount, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(displayLogButton, getConstraints(0,1,3,1,GridBagConstraints.CENTER));
    		add(addNewBookButton, getConstraints(0,2,3,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(0,3,3,1,GridBagConstraints.CENTER));
    	}
    }

    public class ManageSystemListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		String actionCommand = e.getActionCommand();
    		
    		if (actionCommand.equals("Display Log"))
    		{
        		String ttmp = a.getTimeLog();
        	
        		dLog.setText(ttmp);
        		
    			panel5.setVisible(false);
    			panelswitch(panel5, DLP);
    			DLP.setVisible(true);
    		}
    		else if (actionCommand.equals("Add Book"))
    		{
    			if(btitle.getText().isEmpty() || bauthor.getText().isEmpty() || bisbn.getText().isEmpty() || bfee.getText().isEmpty())
    			{
    				ABP.setVisible(false);
    				panelswitch(ABP, ABFP);
    				ABFP.setVisible(true);
    			}
    			else
    			{
    				String ttmmpp = a.addBook(btitle.getText(), bauthor.getText(), bisbn.getText(), Double.parseDouble(bfee.getText()));
    			
    				if(ttmmpp.equals("ok"))
    				{
    					ABP.setVisible(false);
    					panelswitch(ABP, ABGP);
    					ABGP.setVisible(true);
    				}
    				else
    				{
    					ABP.setVisible(false);
    					panelswitch(ABP, ABFP);
    					ABFP.setVisible(true);
    				}
    			}
    		}
    		else if (actionCommand.equals("Add New Book"))
    		{
    			panel5.setVisible(false);
    			panelswitch(panel5, ABP);
    			ABP.setVisible(true);
    		}
    		else if (actionCommand.equals("OK"))
    		{
    			DLP.setVisible(false);
    			panelswitch(DLP, panel5);
    			panel5.setVisible(true);
    		}
    		else if (actionCommand.equals("OK "))
    		{
    			ABP.setVisible(false);
    			panelswitch(ABP, panel5);
    			panel5.setVisible(true);
    		}
    		else if (actionCommand.equals("Main Menu"))
    		{
    			panel5.setVisible(false);
    			panelswitch(panel5, panel1);
    			panel1.setVisible(true);
    		}
    		else if (actionCommand.equals("Main Menu "))
    		{
    			ABP.setVisible(false);
    			panelswitch(ABP, panel1);
    			panel1.setVisible(true);
    		}
    		else if (actionCommand.equals(" Main Menu"))
    		{
    			ABGP.setVisible(false);
    			panelswitch(ABGP, panel1);
    			panel1.setVisible(true);
    		}
    		else if (actionCommand.equals(" Main Menu "))
    		{
    			ABFP.setVisible(false);
    			panelswitch(ABFP, panel1);
    			panel1.setVisible(true);
    		}
    		else
    		{
    			
    		}
    	}
    }
    
    public class DisplayLogPanel extends JPanel
    {	
    	public DisplayLogPanel()
    	{
    		setLayout(new GridBagLayout());
    		
    		dLog = new JTextArea();
    		JLabel makeAccount = new JLabel("Log Display");
    		
    		JButton OKButton = new JButton("OK");
    		
    		dLog.setEditable(false);
    		dLog.setSize(200, 200);
    		
    		ManageSystemListener buttonEar = new ManageSystemListener();

    		OKButton.addActionListener(buttonEar);

    		add(makeAccount, getConstraints(1,0,2,1,GridBagConstraints.CENTER));
    		add(dLog, getConstraints(1,1,2,1,GridBagConstraints.WEST));
    		add(OKButton, getConstraints(1,5,1,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class AddBookPanel extends JPanel
    {	
    	public AddBookPanel()
    	{
    		setLayout(new GridBagLayout());
    		
    		btitle = new JTextField(30);
    		bauthor = new JTextField(30);
    		bisbn = new JTextField(30);
    		bfee = new JTextField(30);
    		
    		JLabel makeAccount = new JLabel("Add Book System");
    		JLabel btitlel = new JLabel("Title:");
    		JLabel bauthorl = new JLabel("Author:");
    		JLabel bisbnl = new JLabel("ISBN:");
    		JLabel bfeel = new JLabel("Fee:");
    		JButton OKButton = new JButton("Add Book");
    		JButton mainMenuButton = new JButton("Main Menu ");
    		
    		ManageSystemListener buttonEar = new ManageSystemListener();

    		OKButton.addActionListener(buttonEar);
    		mainMenuButton.addActionListener(buttonEar);

    		add(makeAccount, getConstraints(1,1,2,1,GridBagConstraints.CENTER));
    		add(btitlel, getConstraints(0,2,1,1, GridBagConstraints.EAST));
    		add(bauthorl, getConstraints(0,3,1,1, GridBagConstraints.EAST));
    		add(bisbnl, getConstraints(0,4,1,1, GridBagConstraints.EAST));
    		add(bfeel, getConstraints(0,5,1,1, GridBagConstraints.EAST));
    		add(btitle, getConstraints(1,2,4,1, GridBagConstraints.EAST));
    		add(bauthor, getConstraints(1,3,4,1, GridBagConstraints.EAST));
    		add(bisbn, getConstraints(1,4,4,1, GridBagConstraints.EAST));
    		add(bfee, getConstraints(1,5,4,1, GridBagConstraints.EAST));
    		add(OKButton, getConstraints(1,6,2,1,GridBagConstraints.WEST));
    		add(mainMenuButton, getConstraints(3,6,1,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class AddBookGoodPanel extends JPanel
    {
    	public AddBookGoodPanel()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("New Book Added.");
    		JButton mainMenuButton = new JButton(" Main Menu");
    		
    		ManageSystemListener buttonEar = new ManageSystemListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(0,2,3,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class AddBookFailPanel extends JPanel
    {
    	public AddBookFailPanel()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("Book NOT added. Information entered is not valid.");
    		JButton mainMenuButton = new JButton(" Main Menu ");
    		
    		ManageSystemListener buttonEar = new ManageSystemListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(0,2,3,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class LogInPanel extends JPanel
    {    	
    	public LogInPanel()
    	{
    		setLayout(new GridBagLayout());
    		
    		mUsername = new JTextField(30);
    		mPassword = new JTextField(30);
    		
    		JLabel makeAccount = new JLabel("Log In");
    		JLabel usename = new JLabel("Username:");
    		JLabel pasword = new JLabel("Password:");
    		JButton LogInButton = new JButton("Log In");
    		JButton mainMenuButton = new JButton("Main Menu");
    		
    		LogInListener buttonEar = new LogInListener();
    		
    		LogInButton.addActionListener(buttonEar);
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(makeAccount, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(usename, getConstraints(0,1,1,1,GridBagConstraints.EAST));
    		add(pasword, getConstraints(0,2,1,1,GridBagConstraints.EAST));
    		add(mUsername, getConstraints(1,1,2,1,GridBagConstraints.WEST));
    		add(mPassword, getConstraints(1,2,2,1,GridBagConstraints.WEST));
    		add(LogInButton, getConstraints(1,5,1,1,GridBagConstraints.EAST));
    		add(mainMenuButton, getConstraints(2,5,1,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class msFailPanel1 extends JPanel
    {
    	public msFailPanel1()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("Information entered is not valid.");
    		JButton okayButton = new JButton("OK");
    		JButton mainMenuButton = new JButton(" Main Menu");
    		
    		LogInListener buttonEar = new LogInListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		okayButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,4,1,GridBagConstraints.CENTER));
    		add(okayButton, getConstraints(0,2,1,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(1,2,2,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class msFailPanel2 extends JPanel
    {
    	public msFailPanel2()
    	{
    		setLayout(new GridBagLayout());
    		
    		JLabel fail = new JLabel("Information entered is not valid.");
    		JButton mainMenuButton = new JButton("Main Menu  ");
    		
    		LogInListener buttonEar = new LogInListener();
    		
    		mainMenuButton.addActionListener(buttonEar);
    		
    		add(fail, getConstraints(0,0,3,1,GridBagConstraints.CENTER));
    		add(mainMenuButton, getConstraints(0,2,3,1,GridBagConstraints.CENTER));
    	}
    }
    
    public class LogInListener implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		String actionCommand = e.getActionCommand();
 
    		if (actionCommand.equals("Log In"))
    		{
    			if(mUsername.getText().equals("!admin2") && mPassword.getText().equals("!admin2"))
    			{
        			login.setVisible(false);
        			panelswitch(login, panel5);
        			panel5.setVisible(true);
        			flag = false;
        			mUsername.setText("");
            		mPassword.setText("");
    			}
    			else
    			{
    				if(flag)
    				{
    					login.setVisible(false);
    					panelswitch(login, msFP2);
    					msFP2.setVisible(true);
    					flag = false;
            			mUsername.setText("");
                		mPassword.setText("");
    				}
    				else
    				{
    					login.setVisible(false);
    					panelswitch(login, msFP1);
    					msFP1.setVisible(true);
    					flag = true;
            			mUsername.setText("");
                		mPassword.setText("");
    				}
    			}
    		}
    		else if (actionCommand.equals("Log In "))
    		{
    			if(a.login(phUsername.getText(), phPassword.getText()))
    			{
    				ausername = phUsername.getText();
    				
    				chold.setText("Customer Username: " + ausername + 
    				"\nPickup date/time: " + month1 + " " + day1 + " " + year1 + " " + hour1 +
    				"\nReturn date/time: " + month2 + " " + day2 + " " + year2 + " " + hour2 +
    				"\nBook Title: " + abook + 
    				"\nReservtion Number: " + a.getReseverNum(ausername, abook) +
    				"\nTotal amount: $" + 
    				df.format(a.getTotalFee(ausername, abook))); 
    				//(a.getHours() ));
    				
        			phlogin.setVisible(false);
        			panelswitch(phlogin, ch);
        			ch.setVisible(true);
    			}
    			else
    			{
    				if(flag)
    				{
    					phlogin.setVisible(false);
    					panelswitch(phlogin, PHFP2);
    					PHFP2.setVisible(true);
    					flag = false;
    				}
    				else
    				{
    					phlogin.setVisible(false);
    					panelswitch(phlogin, PHFP1);
    					PHFP1.setVisible(true);
    					flag = true;
    				}
    			}
				phUsername.setText("");
				phPassword.setText("");
    		}
    		else if (actionCommand.equals(" Log In "))
    		{
    			if(a.login(CHUsername.getText(), CHPassword.getText()))
    			{
    				CHusername = CHUsername.getText();
    				
    				if(a.checkReserve(CHusername))
    				{
    					reList.setListData(a.getReseve(CHusername));
    					
    					CH.setVisible(false);
    					panelswitch(CH, panel4);
    					panel4.setVisible(true);
    				}
    				else
    				{
    					CH.setVisible(false);
    					panelswitch(CH, CHFP3);
    					CHFP3.setVisible(true);
    					flag = false;
    				}
					CHUsername.setText("");
					CHPassword.setText("");
    			}
    			else
    			{
    				if(flag)
    				{
    					CH.setVisible(false);
    					panelswitch(CH, CHFP2);
    					CHFP2.setVisible(true);
    					flag = false;
    					CHUsername.setText("");
    					CHPassword.setText("");
    				}
    				else
    				{
    					CH.setVisible(false);
    					panelswitch(CH, CHFP1);
    					CHFP1.setVisible(true);
    					flag = true;
    					CHUsername.setText("");
    					CHPassword.setText("");
    				}
    			}
    		}
    		else if (actionCommand.equals("OK"))
    		{
    			msFP1.setVisible(false);
    			panelswitch(msFP1, login);
    			login.setVisible(true);
    		}
    		else if (actionCommand.equals("OK "))
    		{
    			PHFP1.setVisible(false);
    			panelswitch(PHFP1, phlogin);
    			phlogin.setVisible(true);
    		}
    		else if (actionCommand.equals("Main Menu"))
    		{
    			PHFP1.setVisible(false);
    			PHFP2.setVisible(false);
    			login.setVisible(false);
    			panelswitch(login, panel1);
    			panel1.setVisible(true);
    			flag = false;
    		}
    		else if (actionCommand.equals("Main Menu "))
    		{
    			phlogin.setVisible(false);
    			panelswitch(phlogin, panel1);
    			panel1.setVisible(true);
    			flag = false;
    		}
    		else if (actionCommand.equals(" Main Menu "))
    		{
    			CH.setVisible(false);
    			panelswitch(CH, panel1);
    			panel1.setVisible(true);
    			flag = false;
    		}
    		else if (actionCommand.equals(" Main Menu"))
    		{
    			msFP1.setVisible(false);
    			panelswitch(msFP1, panel1);
    			panel1.setVisible(true);
    			flag = false;
    		}
    		else if (actionCommand.equals("Main Menu  "))
    		{
    			msFP2.setVisible(false);
    			panelswitch(msFP2, panel1);
    			panel1.setVisible(true);
    			flag = false;
    		}
    		else
    		{
    			
    		}
    	}
    }
}

