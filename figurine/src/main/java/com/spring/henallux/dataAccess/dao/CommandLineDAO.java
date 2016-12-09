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
public class CommandLineDAO 
{
	@Autowired
	private CommandLineRepository commandLineRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	public CommandLine save(CommandLine commandLine)
	{
		CommandLineEntity commandLineEntity = providerConverter.commandLineModeltoCommandLineEntity(commandLine);
		commandLineEntity = commandLineRepository.save(commandLineEntity);
		return providerConverter.commandLineEntitytoCommandLineModel(commandLineEntity);
	}
	
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
}
