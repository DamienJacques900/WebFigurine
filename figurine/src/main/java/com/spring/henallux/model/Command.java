package com.spring.henallux.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;

import com.spring.henallux.dataAccess.entity.CommandEntity;


public class Command 
{
	@NotNull
	private int idCommand;
	
	@NotNull
	@Past
	private Date dateCommand;
	
	@NotNull
	private boolean isPayed;
	
	@NotNull
	private String user;
	
	

	public boolean isPayed() 
	{
		return isPayed;
	}

	public void setPayed(boolean isPayed) 
	{
		this.isPayed = isPayed;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getIdCommand() 
	{
		return idCommand;
	}
	
	public void setIdCommand(int idCommand) 
	{
		this.idCommand = idCommand;
	}
	
	public Date getDateCommand() 
	{
		return dateCommand;
	}
	
	public void setDateCommand(Date dateCommand) 
	{
		this.dateCommand = dateCommand;
	}
}
