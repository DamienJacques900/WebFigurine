package com.spring.henallux.dataAccess.entity;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="commandline")
@NamedQueries
({
	@NamedQuery
	(
			name = "findCommandLineByCommandId",
			query = "from CommandLineEntity b where b.command.idCommand = :valueIdCommand"
	)
})
public class CommandLineEntity 
{
	@Id
	@Min(1)
	@Max(1000)
	@Column(name="idcommandline")
	private int idCommandeLine;
	
	@NotNull
	@Min(0)
	@Max(1000)
	@Column(name="nbfigurine")
	private int nbFigurine;
	
	@NotNull
	@DecimalMin("1.00")
	@DecimalMax("10000.00")
	@Column(name="prizecommand")
	private double prizeCommand;
		
	@NotNull
	@Min(0)
	@Max(1000)
	@JoinColumn(name="command", referencedColumnName="idcommand")
	@ManyToOne
	private CommandEntity command;
	
	@NotNull
	@Min(0)
	@Max(1000)
	@Column(name="figurine")
	private int figurine;


	public int getIdCommandeLine() 
	{
		return idCommandeLine;
	}

	public void setIdCommandeLine(int idCommandeLine) 
	{
		this.idCommandeLine = idCommandeLine;
	}

	public int getFigurine() 
	{
		return figurine;
	}

	public void setFigurine(int figurine) 
	{
		this.figurine = figurine;
	}

	public CommandEntity getCommand() 
	{
		return command;
	}

	public void setCommand(CommandEntity command) 
	{
		this.command = command;
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

}

