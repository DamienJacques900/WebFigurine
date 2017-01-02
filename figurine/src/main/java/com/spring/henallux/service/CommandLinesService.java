package com.spring.henallux.service;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.spring.henallux.dataAccess.dao.*;
import com.spring.henallux.model.*;

@Service
public class CommandLinesService 
{
	private ArrayList<CommandLine> commandLine;
	
	@Autowired
	private CommandLineDAO commandLineDAO;
	
	public CommandLinesService()
	{
		
	}
	
	public ArrayList<CommandLine> getCommandLines()
	{
		//***************************COMMENTAIRE************************************
		//On fait deux arrayList pour récupérer les valeurs de la BD mais ici c'est
		//un peu inutile, on pourrait juste faire directement dans le controller
		//la requête avec le DAO
		//**************************************************************************
		commandLine = new ArrayList<CommandLine>();
		ArrayList<CommandLine> commandLines = commandLineDAO.getAllCommandLines();
		
		for(int i=0;i<commandLines.size();i++)
		{		
			commandLine.add(commandLines.get(i));
		}

		return commandLine;
	}
	
	public String getTotalValueCommandLine()
	{
		double totalValue = 0;
		commandLine = new ArrayList<CommandLine>();
		ArrayList<CommandLine> commandLines = commandLineDAO.getAllCommandLines();
		
		for(int i=0;i<commandLines.size();i++)
		{		
			totalValue += commandLines.get(i).getNbFigurine()*commandLines.get(i).getPrizeCommand();
		}
		
		return String.format("%.2f",totalValue);
	}

	public ArrayList<CommandLine> getCommandLine() 
	{
		return commandLine;
	}

	public void setCommandLine(ArrayList<CommandLine> commandLine) 
	{
		this.commandLine = commandLine;
	}

	public CommandLineDAO getCommandLineDAO() 
	{
		return commandLineDAO;
	}

	public void setCommandLineDAO(CommandLineDAO commandLineDAO) 
	{
		this.commandLineDAO = commandLineDAO;
	}
	
	
}
