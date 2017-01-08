package com.spring.henallux.dataAccess.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="command")
public class CommandEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idcommand")
	private int idCommand;
	
	@NotNull
	@Column(name="datecommand")
	private Date dateCommand;
	
	@NotNull
	@Column(name="ispayed")
	private boolean isPayed;
	
	@Column(name="user")
	private String userEnt;

	

	public String getUserEnt() 
	{
		return userEnt;
	}

	public boolean getIsPayed() 
	{
		return isPayed;
	}

	public void setIsPayed(boolean isPayed) {
		this.isPayed = isPayed;
	}

	public void setUserEnt(String userEnt) {
		this.userEnt = userEnt;
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

