package com.spring.henallux.dataAccess.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.henallux.dataAccess.entity.*;
import com.spring.henallux.dataAccess.repository.*;

import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.*;

@Service
@Transactional
public class CommandDAO 
{
	@Autowired
	private CommandRepository commandRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	//***************************COMMENTAIRE************************************
	//Permet de sauvergarder les données dans la BD
	//**************************************************************************
	public Command save(Command command)
	{
		CommandEntity commandEntity = providerConverter.commandModeltoCommandEntity(command);
		commandEntity = commandRepository.save(commandEntity);
		return providerConverter.commandEntitytoCommandModel(commandEntity);
	}
	
	
	public void delete(Command command)
	{
		CommandEntity commandEntity = providerConverter.commandModeltoCommandEntity(command);
		commandRepository.delete(commandEntity);
	}
	
	
	//***************************COMMENTAIRE************************************
	//Permet de récupérer les données dans la BD
	//**************************************************************************
	public ArrayList<Command> getAllCommands()
	{
		List <CommandEntity> commandeEntities = commandRepository.findAll();
		ArrayList <Command> commands = new ArrayList<>();
		for (CommandEntity entity : commandeEntities)
		{
			Command command = providerConverter.commandEntitytoCommandModel(entity);
			commands.add(command);
		}
		return commands;
	}
	
	public Command getCommandById(String idUser)
	{
		List <CommandEntity> commandeEntities = commandRepository.findAll();
		Command command = new Command();
		for (CommandEntity entity : commandeEntities)
		{
			if(entity.getUserEnt().equals(idUser) && entity.getIsPayed() == false)
			{
				command = providerConverter.commandEntitytoCommandModel(entity);				
			}
		}
		return command;
	}	
	
	public Command getCommandByIdAndIsPayed(String idUser)
	{
		List <CommandEntity> commandeEntities = commandRepository.findAll();
		Command command = new Command();
		for (CommandEntity entity : commandeEntities)
		{
			if(entity.getUserEnt().equals(idUser) && entity.getIsPayed() == true)
			{
				command = providerConverter.commandEntitytoCommandModel(entity);				
			}
		}
		return command;
	}
}
