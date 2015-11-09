/*
* Title: Usernames.java
* Abstract: This holds all the username data.
* Author: Marcus Dixon
* ID: 0721
* Date: 5/10/2015
*/

public class Usernames 
{	
	private String name;
	private String password;
	
	public Usernames(String name, String word)
	{
		this.name = name;
		this.password = word;
	}
	
	public void setUsername(String name)
	{
		this.name = name;
	}
	
	public void setPassword(String word)
	{
		this.password = word;
	}
	
	public String getUsername()
	{
		return this.name;
	}
	
	public String getPassword()
	{
		return this.password;
	}
}
