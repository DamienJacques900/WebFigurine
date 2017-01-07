package com.spring.henallux.model;

public class CommandLineWithFigurine 
{
	private CommandLine commandLine;
	
	private Figurine figurine;

	public CommandLineWithFigurine() 
	{
		
	}
	
	public CommandLineWithFigurine(CommandLine commandLine, Figurine figurine) 
	{
		this.commandLine = commandLine;
		this.figurine = figurine;
	}

	public CommandLine getCommandLine() 
	{
		return commandLine;
	}

	public void setCommandLine(CommandLine commandLine) 
	{
		this.commandLine = commandLine;
	}

	public Figurine getFigurine() 
	{
		return figurine;
	}

	public void setFigurine(Figurine figurine) 
	{
		this.figurine = figurine;
	}
	
	
	
}
