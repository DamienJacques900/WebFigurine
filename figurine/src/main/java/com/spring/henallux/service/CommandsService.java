package com.spring.henallux.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.dao.*;
import com.spring.henallux.model.*;

@Service
public class CommandsService 
{
	private ArrayList<Command> commands;
	
	@Autowired
	private CommandDAO commandDAO;
	
	public CommandsService()
	{
		
	}
	
	public ArrayList<Command> getCommand()
	{
		//***************************COMMENTAIRE************************************
		//On fait deux arrayList pour récupérer les valeurs de la BD mais ici c'est
		//un peu inutile, on pourrait juste faire directement dans le controller
		//la requête avec le DAO
		//**************************************************************************
		commands = new ArrayList<Command>();
		ArrayList<Command> command = commandDAO.getAllCommands();
		
		for(int i=0;i<command.size();i++)
		{		
			commands.add(command.get(i));
		}

		return commands;
	}

	public ArrayList<Command> getCommands() 
	{
		return commands;
	}

	public void setCommands(ArrayList<Command> commands) 
	{
		this.commands = commands;
	}

	public CommandDAO getCommandDAO() 
	{
		return commandDAO;
	}

	public void setCommandDAO(CommandDAO commandDAO) 
	{
		this.commandDAO = commandDAO;
	}
	
	
}
