package com.spring.henallux.dataAccess.dao;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.henallux.dataAccess.entity.*;
import com.spring.henallux.dataAccess.repository.*;

import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.*;

@Service
@Transactional
public class CommandLineDAO 
{
	@Autowired
	private CommandLineRepository commandLineRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	//@Autowired
	private SessionFactory sessionFactory;
	
	//***************************COMMENTAIRE************************************
	//Permet de sauvergarder les données dans la BD
	//**************************************************************************
	public CommandLine save(CommandLine commandLine)
	{
		CommandLineEntity commandLineEntity = providerConverter.commandLineModeltoCommandLineEntity(commandLine);
		commandLineEntity = commandLineRepository.save(commandLineEntity);
		return providerConverter.commandLineEntitytoCommandLineModel(commandLineEntity);
	}
	
	public void delete(CommandLine commandLine)
	{
		CommandLineEntity commandLineEntity = providerConverter.commandLineModeltoCommandLineEntity(commandLine);
		commandLineRepository.delete(commandLineEntity);
	}
	
	
	//***************************COMMENTAIRE************************************
	//Permet de récupérer les données dans la BD
	//**************************************************************************
	public ArrayList<CommandLine> getAllCommandLines()
	{
		List <CommandLineEntity> commandLineEntities = commandLineRepository.findAll();
		ArrayList <CommandLine> commandLines = new ArrayList<>();
		for (CommandLineEntity entity : commandLineEntities)
		{
			CommandLine commandLine = providerConverter.commandLineEntitytoCommandLineModel(entity);
			commandLines.add(commandLine);
		}
		return commandLines;
	}
	
	
	public ArrayList<CommandLine> getAllCommandLinesForCurrentUser(Integer idCommand)
	{
		List <CommandLineEntity> commandLineEntities = commandLineRepository.findAll();
		ArrayList <CommandLine> commandLines = new ArrayList<>();
		for (CommandLineEntity entity : commandLineEntities)
		{
			if(entity.getCommand() == idCommand)
			{
				CommandLine commandLine = providerConverter.commandLineEntitytoCommandLineModel(entity);
				commandLines.add(commandLine);
			}			
		}
		return commandLines;
	}
	
	
	
	
	public ArrayList<CommandLine> findCommandForCommandLine()
	{	
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();	
		Query query = session.getNamedQuery("findCommandLineByCommandId").setInteger("valueIdCommand",1);//A modifier		
		List<CommandLineEntity> commandLineEntities = query.list();
		ArrayList<CommandLine> commandLines = new ArrayList<CommandLine>();		
		for(CommandLineEntity entity : commandLineEntities)
		{
			CommandLine commandLine = providerConverter.commandLineEntitytoCommandLineModel(entity);
			commandLines.add(commandLine);
			System.out.println(commandLine.getFigurine());
		}
		session.getTransaction().commit();
		return commandLines;
	}
}
























