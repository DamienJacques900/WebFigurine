package com.spring.henallux.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.spring.henallux.dataAccess.entity.CommandEntity;
import com.spring.henallux.dataAccess.entity.UserEntity;

public class CommandLine 
{
	@Min(1)
	@Max(1000)
	private int idCommandeLine;
	
	@NotNull
	@Min(1)
	@Max(1000)
	private int nbFigurine;
	
	@NotNull
	@DecimalMin("1.00")
	@DecimalMax("10000.00")
	private double prizeCommand;
	
	@NotNull
	@Min(0)
	@Max(1000)
	private int command;
	
	@NotNull
	@Min(0)
	@Max(1000)
	private int figurine;

	
	public CommandLine()
	{
		
	}

	public int getIdCommandeLine() 
	{
		return idCommandeLine;
	}

	public void setIdCommandeLine(int idCommandeLine) 
	{
		this.idCommandeLine = idCommandeLine;
	}

	public int getNbFigurine() 
	{
		return nbFigurine;
	}

	public void setNbFigurine(int nbFigurine) 
	{
		this.nbFigurine = nbFigurine;
	}

	public double getPrizeCommand() 
	{
		return prizeCommand;
	}

	public void setPrizeCommand(double prizeCommand) 
	{
		this.prizeCommand = prizeCommand;
	}

	public int getFigurine() 
	{
		return figurine;
	}

	public void setFigurine(int figurine) 
	{
		this.figurine = figurine;
	}

	public int getCommand() 
	{
		return command;
	}

	public void setCommand(int command) 
	{
		this.command = command;
	}
}
