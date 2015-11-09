/*
* Title: Book.java
* Abstract: This holds all the book data.
* Author: Marcus Dixon
* ID: 0721
* Date: 5/10/2015
*/

public class Book 
{
	private String bookTitle;
	private String author;
	private String ISBN;
	private Double fee;
	
	public Book(String title, String author, String isbn, Double fee)
	{
		this.bookTitle = title;
		this.author = author;
		this.ISBN = isbn;
		this.fee = fee;
	}
	
	public void setBookTitle(String title)
	{
		this.bookTitle = title;
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public void setISBN(String isbn)
	{
		this.ISBN = isbn;
	}
	
	public void setfee(Double fee)
	{
		this.fee = fee;
	}
	
	public String getBookTitle()
	{
		return this.bookTitle;
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
