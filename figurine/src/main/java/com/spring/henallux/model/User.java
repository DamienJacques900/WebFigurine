package com.spring.henallux.model;

import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.NotEmpty;

import com.spring.henallux.dataAccess.entity.CommandEntity;

//import javax.validation.constraints.*;

public class User 
{
	@NotEmpty
	@Size(min=5, max=30)
	@NotNull
	private String idUser;
	
	@NotEmpty
	@Size(min=5, max=30)
	@NotNull
	private String firstName;
	
	@NotEmpty
	@Size(min=5, max=50)
	@NotNull
	private String lastName;
	
	@NotEmpty
	@NotNull	
	private String email;
	
	private String numTel;
	
	private String numFax;
	
	@NotEmpty
	@Size(min=5, max=30)
	@NotNull
	private String street;
	
	@NotEmpty
	@Size(min=5, max=30)
	@NotNull
	private String city;
	
	@NotEmpty
	@Size(min=3, max=10)
	@NotNull
	private String postalCode;
	
	@NotEmpty
	@Size(min=5, max=30)
	@NotNull
	private String country;
	
	@NotEmpty
	@Size(min=4, max=150)
	@NotNull
	private String password;
	
	@NotEmpty
	@Size(min=4, max=150)
	@NotNull
	private String confirmationPassword;
	
	public User()
	{
		
	}
	
	
	
	public User(String idUser, String firstName, String lastName, String email, String numTel, String numFax,
			String street, String city, String postalCode, String country, String password) {
		super();
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.numTel = numTel;
		this.numFax = numFax;
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
		this.password = password;
	}

	public User(String idUser, String password) {
		super();
		this.idUser = idUser;
		this.password = password;
	}

	//GETTERS ========================================================
	
	public User getUserConnection()
	{
		return new User(idUser,password);
	}
	public String getConfirmationPassword() 
	{
		return confirmationPassword;
	}

	public User getUser()
	{
		return new User(idUser,firstName,lastName,email,numTel,numFax,street,city,postalCode,country,password);
	}
	
	public String getIdUser()
	{
		return idUser;
	}
	
	public String getNumTel() 
	{
		return numTel;
	}

	
	public String getNumFax() 
	{
		return numFax;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getStreet()
	{
		return street;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getPostalCode()
	{
		return postalCode;
	}
	
	public String getCountry()
	{
		return country;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	//SETTERS ========================================================
	
	public void setConfirmationPassword(String confirmationPassword) 
	{
		this.confirmationPassword = confirmationPassword;
	}
	
	public void setIdUser(String idUser) 
	{
		this.idUser = idUser;
	}
	
	public void setFirstName(String f)
	{
		firstName = f;
	}
	
	public void setNumFax(String numFax) 
	{
		this.numFax = numFax;
	}
	
	public void setNumTel(String numTel) 
	{
		this.numTel = numTel;
	}

	
	public void setLastName(String l)
	{
		lastName = l;
	}
	
	public void setEmail(String e)
	{
		email = e;
	}
	
	public void setStreet(String s)
	{
		street = s;
	}
	
	public void setCity(String c)
	{
		city = c;
	}
	
	public void setPostalCode(String p)
	{
		postalCode = p;
	}
	
	public void setCountry(String co)
	{
		country = co;
	}
	
	public void setPassword(String pass)
	{
		password = pass;
	}
	
}
