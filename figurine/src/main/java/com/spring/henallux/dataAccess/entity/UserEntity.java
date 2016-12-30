package com.spring.henallux.dataAccess.entity;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.spring.henallux.model.Command;

@Entity
@Table(name="user")
public class UserEntity 
{
	@Id
	@Column(name="iduser")
	@Size(min=5, max=30)
	@NotNull( message = "Veuillez saisir un nom d'utilisateur" )
	private String idUser;
	
	@Column(name="firstname")
	@Size(min=5, max=30)
	@NotNull( message = "Veuillez saisir votre prénom" )
	private String firstName;
	
	@Column(name="lastname")
	@Size(min=5, max=50)
	@NotNull( message = "Veuillez saisir votre nom" )
	private String lastName;
	
	@Column(name="email")
	@NotNull( message = "Veuillez saisir une adresse email" )
	@Pattern( regexp = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)", message = "Merci de saisir une adresse mail valide" )
	private String email;
	
	//String ou int pour les numéros?
	@Column(name="numtel")
	@Size(min=5, max=30)
	private String numTel;
	
	//String ou int pour les numéros?
	@Size(min=5, max=30)
	@Column(name="numfax")
	private String numFax;
	
	@Column(name="street")
	@Size(min=5, max=30)
	@NotNull( message = "Veuillez saisir votre rue" )
	private String street;
	
	@Column(name="city")
	@Size(min=5, max=30)
	@NotNull( message = "Veuillez saisir la ville où vous habitez" )
	private String city;
	
	@Column(name="postalcode")
	@Size(min=3, max=10)
	@NotNull( message = "Veuillez saisir votre code postal" )
	private String postalCode;
	
	@Column(name="country")
	@Size(min=5, max=30)
	@NotNull( message = "Veuillez saisir votre pays" )
	private String country;
	
	@Column(name="password")
	@Size(min=5, max=30)
	@NotNull( message = "Veuillez saisir votre mot de passe" )
	private String password;
	
	/*@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private Collection<CommandEntity> commands;*/
	

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

