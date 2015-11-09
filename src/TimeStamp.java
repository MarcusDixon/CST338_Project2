/*
* Title: TimeStamp.java
* Abstract: This holds all the Log data.
* Author: Marcus Dixon
* ID: 0721
* Date: 5/10/2015
*/

import java.util.*;


public class TimeStamp 
{
	private String name;
	private String type;
	Calendar currentCalendar;
	Date currentTime;
	private String bookTitle = "Null";
	
	public TimeStamp(String type, String name)
	{
		this.name = name;
		this.type = type;
		this.currentCalendar = Calendar.getInstance();
		this.currentTime = currentCalendar.getTime();
	}
	
	public void setBookTitle(String bookTitle)
	{
		this.bookTitle = bookTitle;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public Calendar getCalendar()
	{
		return this.currentCalendar;
	}
	
	public Date getDate()
	{
		return this.currentTime;
	}
	
	public String getBookTitle()
	{
		return this.bookTitle;
	}
}
