/*
* Title: OtterLibrarySystem.java
* Abstract: This file serves as the main back-end file for the GUI.
* Author: Marcus Dixon
* ID: 0721
* Date: 5/10/2015
*/

import java.text.DecimalFormat;
import java.util.*;


public class OtterLibrarySystem 
{
	Integer hours = 0;
	private ArrayList<Usernames> username = new ArrayList<Usernames>(10);
	private ArrayList<Book> books = new ArrayList<Book>(10);
	private ArrayList<TimeStamp> timestamp = new ArrayList<TimeStamp>(10);
	private ArrayList<Reserves> reserve = new ArrayList<Reserves>(10);
	DecimalFormat df = new DecimalFormat("0.00");
	
	public OtterLibrarySystem()
	{
		Usernames name1 = new Usernames("a@lice5", "@csit100");
		Usernames name2 = new Usernames("$brian7", "123abc##");
		Usernames name3 = new Usernames("!chris12!", "CHRIS12!!");
	
		username.add(name1);
		username.add(name2);
		username.add(name3);
		
		Book book1 = new Book("Hot Java", "S. Narayanan", "123-ABC-101", 0.05);
		Book book2 = new Book("Fun Java", "Y. Byun", "ABCDEF-09", 1.00);
		Book book3 = new Book("Algorithm for Java", "K. Alice", "CDE-777-123", 0.25);
		
		books.add(book1);
		books.add(book2);
		books.add(book3);
	}
	
	public String createAccount(String name, String word)
	{
		boolean flag = true;
		
		if(name.equals("!admin2"))
			return "cF";
		
		for (Usernames element: username)
		{
			if (element.getUsername().equals(name))
			{
				flag = false;
			}
		}
		
		if(flag)
		{
			if(name.matches(".*[!@#$]+.*"))
			{
				if(word.matches(".*[!@#$]+.*"))
				{
					if(name.matches(".*[a-zA-Z]{3,}.*"))
					{
						if(word.matches(".*[a-zA-Z]{3,}.*"))
						{
							if(name.matches(".*\\d+.*"))
							{
								if(word.matches(".*\\d+.*"))
								{
									Usernames username = new Usernames(name, word);
									this.username.add(username);
									TimeStamp timeStamp = new TimeStamp("New Account", name);
									timestamp.add(timeStamp);
									return "ok";
								}
							}
						}
					}
				}
			}
		}
		else
			return "cF";
		return "fn";
	}
	
	public String[] getBookLog()
	{
		int i = 0;
		String[] tmp = new String[20];
		for (Book element: books)
		{
			tmp[i] = (element.getBookTitle() + " - " + element.getAuthor() + " - $" + df.format(element.getfee()));
			i++;
		}
		return tmp;
	}
	
	public String addBook(String title, String author, String isbn, Double fee)
	{
		boolean flag = true;
		
		for (Book element: books)
		{
			if (element.getBookTitle().equals(title))
			{
				if (element.getAuthor().equals(author))
				{
					if (element.getISBN().equals(isbn))
					{
						if (element.getfee().equals(fee))
						{
							flag = false;
						}
					}
				}
			}
		}
		
		if (flag)
		{
			Book nbook = new Book(title, author, isbn, fee);
		
			this.books.add(nbook);
			return "ok";
		}
		return "fa";
	}
	
	public void setReserve(String name, String title)
	{
		for (Book element: books)
		{
			if(element.getBookTitle().equals(title))
			{
				Reserves re = new Reserves(name, title, element.getAuthor(), 
						element.getISBN(), element.getfee(), (reserve.size() + 1));
				reserve.add(re);
				TimeStamp timeStamp = new TimeStamp("Hold", name);
				timeStamp.setBookTitle(title);
				timestamp.add(timeStamp);
			}
		}
		
		for (int i = 0; i < books.size(); i++)
		{
			if(books.get(i).getBookTitle().equals(title))
			{
				books.remove(i);
				i--;
			}
		}
	}
	
	
	public boolean checkDate(String month, String day, String year)
	{
		if(month.equals("February"))
		{
			if(year.equals("2016") || year.equals("2020"))
			{
				if(Integer.valueOf(day) < 30)
					return true;
			}
			else
			{
				if(Integer.valueOf(day) < 29)
					return true;
			}
		}
	
		if(month.equals("January") || month.equals("March") || month.equals("May") || 
				month.equals("July") || month.equals("August") || month.equals("October") || 
				month.equals("December"))
			return true;
			
		if(month.equals("April") || month.equals("June") || month.equals("September") || 
				month.equals("November"))
			if(Integer.valueOf(day) < 31)
				return true;

		return false;
	}
	
	public boolean checkWeek(String month1, String day1, String year1, String time1,
							String month2, String day2, String year2, String time2)
	{
		Calendar something1 = Calendar.getInstance();
		Calendar something2 = Calendar.getInstance();
		
		Integer m1 = null, m2 = null, t1 = null, t2 = null;
		String apm, apm2;
		
		switch(month1)
		{
		case "January": m1 = 0;
			break;
		case "February": m1 = 1;
			break;
		case "March": m1 = 2;
			break;
		case "April": m1 = 3;
			break;
		case "May": m1 = 4;
			break;
		case "June": m1 = 5;
			break;
		case "July": m1 = 6;
			break;
		case "August": m1 = 7;
			break;
		case "September": m1 = 8;
			break;
		case "October": m1 = 9;
			break;
		case "November": m1 = 10;
			break;
		case "December": m1 = 11;
			break;
		}
		switch(month2)
		{
		case "January": m2 = 0;
			break;
		case "February": m2 = 1;
			break;
		case "March": m2 = 2;
			break;
		case "April": m2 = 3;
			break;
		case "May": m2 = 4;
			break;
		case "June": m2 = 5;
			break;
		case "July": m2 = 6;
			break;
		case "August": m2 = 7;
			break;
		case "September": m2 = 8;
			break;
		case "October": m2 = 9;
			break;
		case "November": m2 = 10;
			break;
		case "December": m2 = 11;
			break;
		}
		switch(time1)
		{
		case "7 AM":{t1 = 7; apm = "AM";}
			break;
		case "8 AM":{t1 = 8; apm = "AM";}
			break;
		case "9 AM":{t1 = 9; apm = "AM";}
			break;
		case "10 AM":{t1 = 10; apm = "AM";}
			break;
		case "11 AM":{t1 = 11; apm = "AM";}
			break;
		case "12 PM":{t1 = 12; apm = "PM";}
			break;
		case "1 PM":{t1 = 13; apm = "PM";}
			break;
		case"2 PM":{t1 = 14; apm = "PM";}
			break;
		case "3 PM":{t1 = 15; apm = "PM";}
			break;
		case "4 PM":{t1 = 16; apm = "PM";}
			break;
		case "5 PM":{t1 = 17; apm = "PM";}
			break;
		case "6 PM":{t1 = 18; apm = "PM";}
			break;
		case "7 PM":{t1 = 19; apm = "PM";}
			break;
		case "8 PM":{t1 = 20; apm = "PM";}
			break;
		}
		switch(time2)
		{
		case "7 AM":{t2 = 7; apm2 = "AM";}
		break;
	case "8 AM":{t2 = 8; apm2 = "AM";}
		break;
	case "9 AM":{t2 = 9; apm2 = "AM";}
		break;
	case "10 AM":{t2 = 10; apm2 = "AM";}
		break;
	case "11 AM":{t2 = 11; apm2 = "AM";}
		break;
	case "12 PM":{t2 = 12; apm2 = "PM";}
		break;
	case "1 PM":{t2 = 13; apm2 = "PM";}
		break;
	case"2 PM":{t2 = 14; apm2 = "PM";}
		break;
	case "3 PM":{t2 = 15; apm2 = "PM";}
		break;
	case "4 PM":{t2 = 16; apm2 = "PM";}
		break;
	case "5 PM":{t2 = 17; apm2 = "PM";}
		break;
	case "6 PM":{t2 = 18; apm2 = "PM";}
		break;
	case "7 PM":{t2 = 19; apm2 = "PM";}
		break;
	case "8 PM":{t2 = 20; apm2 = "PM";}
		break;
	}
		something1.set(Integer.valueOf(year1), m1, Integer.valueOf(day1),t1,0);
		something2.set(Integer.valueOf(year2), m2, Integer.valueOf(day2),t2,0);

		if(something2.get(Calendar.YEAR) - something1.get(Calendar.YEAR) < 0 || 
				something2.get(Calendar.YEAR) - something1.get(Calendar.YEAR) > 1)
			return false;
		if(something2.get(Calendar.YEAR) - something1.get(Calendar.YEAR) == 0)
		{
			if(something2.get(Calendar.DAY_OF_YEAR) - something1.get(Calendar.DAY_OF_YEAR) > 0 &&
					something2.get(Calendar.DAY_OF_YEAR) - something1.get(Calendar.DAY_OF_YEAR) < 8)
			{
				hours = ((something2.get(Calendar.DAY_OF_YEAR) - something1.get(Calendar.DAY_OF_YEAR)) * 24)
						+ (t2 - t1);
				return true;
			}
			else if(something2.get(Calendar.DAY_OF_YEAR) - something1.get(Calendar.DAY_OF_YEAR) == 0)
			{
				if (t2 - t1 > -1)
				{
					hours = t2 - t1;
					return true;
				}
			}
		}
		else
		{
			if(something1.getActualMaximum(Calendar.DAY_OF_YEAR) - something1.get(Calendar.DAY_OF_YEAR)
				+ something2.get(Calendar.DAY_OF_YEAR) < 8)
			{
				hours = (something1.getActualMaximum(Calendar.DAY_OF_YEAR) - something1.get(Calendar.DAY_OF_YEAR)
						+ something2.get(Calendar.DAY_OF_YEAR)) * 24;
				return true;
			}
		}
		
		return false;
	}
	
	public boolean checkReserve(String name)
	{
		boolean flag = false;
		for (Reserves element: reserve)
		{
			if (element.getName().equals(name))
			{
				flag = true;
			}
		}
		return flag;
	}
	
	public int getReseverNum(String name, String title)
	{
		return reserve.size() + 1;
	}
	
	public String[] getReseve(String name)
	{
		boolean flag = true; 
		int i = 0;
		String[] tmp = new String[20];
		for (Reserves element: reserve)
		{
			if (element.getName().equals(name))
			{
				tmp[i] = element.getBookTitle();
				i++;
				flag = false;
			}
		}
		if(flag)
		{
			String[] tmmp = new String[1];
			tmmp[0] = "No Reservations with this username";
		}
		return tmp;
	}
	
	public void canReserve(String name, String title)
	{
		for (int i = 0; i < reserve.size(); i++)
		{
			if(reserve.get(i).getName().equals(name))
			{
				if(reserve.get(i).getBookTitle().equals(title))
				{
					addBook(reserve.get(i).getBookTitle(), reserve.get(i).getAuthor(),
							reserve.get(i).getISBN(), reserve.get(i).getfee());
					reserve.remove(i);
					i--;
					
					TimeStamp timeStamp = new TimeStamp("Cancel Hold", name);
					timeStamp.setBookTitle(title);
					timestamp.add(timeStamp);
				}
			}
			
		}
	}
		
	public boolean login(String name, String word)
	{
		for (Usernames element: username)
		{
			if (element.getUsername().equals(name))
			{
				if (element.getPassword().equals(word))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public double getTotalFee(String name, String title)
	{
		for(Book element: books)
		{
			if(element.getBookTitle().equals(title))
			{
				return element.getfee() * hours;
			}
		}
			return 0;
	}
	
	public int getHours()
	{
		return this.hours;
	}
	
	public String getbookname(int ind)
	{
		return books.get(ind).getBookTitle();
	}
	
	public boolean checkBook()
	{
		if(books.isEmpty())
			return true;
		else
			return false;
	}
	
	public String getTimeLog()
	{
		int i = 1;
		String tmp = "";
		for (TimeStamp element: timestamp)
		{
			tmp += (element.getType());
			if(element.getBookTitle().equals("Null"))
			{
				
			}
			else
			{
				tmp += (" - Book: " + element.getBookTitle());
			}
			tmp += (" - Username: " + element.getName() + " - Date: " + element.getDate());
			
			tmp += "\n";
			i++;
		}
		return tmp;
	}
}
