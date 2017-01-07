package com.spring.henallux.dataAccess.entity;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.NotEmpty;

import com.spring.henallux.model.Command;

@Entity
@Table(name="user")
public class UserEntity 
{
	@Id
	@Column(name="iduser")
	@Size(min=5, max=30)
	private String idUser;
	
	@Column(name="firstname")
	@NotEmpty
	@Size(min=5, max=30)
	@NotNull
	private String firstName;
	
	@Column(name="lastname")
	@NotEmpty
	@Size(min=5, max=50)
	@NotNull
	private String lastName;
	
	@Column(name="email")
	@NotEmpty
	@NotNull
	@Pattern( regexp = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)", message = "Merci de saisir une adresse mail valide" )
	private String email;
	
	@Column(name="numtel")
	private String numTel;

	@Column(name="numfax")
	private String numFax;
	
	@Column(name="street")
	@NotEmpty
	@Size(min=5, max=30)
	@NotNull
	private String street;
	
	@Column(name="city")
	@NotEmpty
	@Size(min=5, max=30)
	@NotNull
	private String city;
	
	@Column(name="postalcode")
	@NotEmpty
	@Size(min=3, max=10)
	@NotNull
	private String postalCode;
	
	@Column(name="country")
	@NotEmpty
	@Size(min=5, max=30)
	@NotNull
	private String country;
	
	@Column(name="password")
	@NotEmpty
	@Size(min=4, max=150)
	@NotNull
	private String password;
	

	public String getIdUser() 
	{
		return idUser;
	}

	public void setIdUser(String idUser) 
	{
		this.idUser = idUser;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getNumTel() 
	{
		return numTel;
	}

	public void setNumTel(String numTel) 
	{
		this.numTel = numTel;
	}

	public String getNumFax() 
	{
		return numFax;
	}

	public void setNumFax(String numFax) 
	{
		this.numFax = numFax;
	}

	public String getStreet() 
	{
		return street;
	}

	public void setStreet(String street) 
	{
		this.street = street;
	}

	public String getCity() 
	{
		return city;
	}

	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getPostalCode() 
	{
		return postalCode;
	}

	public void setPostalCode(String postalCode) 
	{
		this.postalCode = postalCode;
	}

	public String getCountry() 
	{
		return country;
	}

	public void setCountry(String country) 
	{
		this.country = country;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}
}

