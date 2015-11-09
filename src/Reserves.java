/*
* Title: Reserves.java
* Abstract: This holds all the reserve data.
* Author: Marcus Dixon
* ID: 0721
* Date: 5/10/2015
*/

public class Reserves 
{
	private String name;
	private String bookTitle;
	private int reservNum = 0;
	private String author;
	private String ISBN;
	private Double fee;
	
	public Reserves(String name, String bookTitle, String author, String isbn, Double fee, int num)
	{
		this.name = name;
		this.bookTitle = bookTitle;
		this.author = author;
		this.ISBN = isbn;
		this.fee = fee;
		this.reservNum = num;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getBookTitle()
	{
		return this.bookTitle;
	}
	
	public int getResevNum()
	{
		return this.reservNum;
	}
	
	public String getAuthor()
	{
		return this.author;
	}
	
	public String getISBN()
	{
		return this.ISBN;
	}
	
	public Double getfee()
	{
		return this.fee;
	}
}
