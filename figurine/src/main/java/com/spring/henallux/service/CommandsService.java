package com.spring.henallux.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.dao.*;
import com.spring.henallux.dataAccess.entity.CommandEntity;
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
	
	public Command getCommandById(String idUser)
	{
		ArrayList <Command> commands = commandDAO.getAllCommands();
		Command command = new Command();
		for(int i=0;i<commands.size();i++)
		{
			if(commands.get(i).getUser().equals(idUser) && commands.get(i).isPayed() == false)
			{
				command = commands.get(i);				
			}
		}
		return command;
	}	
	
	public Command getCommandByIdAndIsPayed(String idUser)
	{
		ArrayList <Command> commands = commandDAO.getAllCommands();
		Command command = new Command();
		for(int i=0;i<commands.size();i++)
		{
			if(commands.get(i).getUser().equals(idUser) && commands.get(i).isPayed() == true)
			{
				command = commands.get(i);				
			}
		}
		return command;
	}
}
