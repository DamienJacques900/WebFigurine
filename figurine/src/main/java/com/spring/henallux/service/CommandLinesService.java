package com.spring.henallux.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.spring.henallux.dataAccess.dao.*;
import com.spring.henallux.dataAccess.entity.CommandLineEntity;
import com.spring.henallux.model.*;

@Service
public class CommandLinesService 
{
	private ArrayList<CommandLine> commandLine;
	
	@Autowired
	private CommandLineDAO commandLineDAO;
	
	public ArrayList<CommandLine> getCommandLines()
	{
		commandLine = new ArrayList<CommandLine>();
		ArrayList<CommandLine> commandLines = commandLineDAO.getAllCommandLines();
		
		for(int i=0;i<commandLines.size();i++)
		{		
			commandLine.add(commandLines.get(i));
		}

		return commandLine;
	}	
	
	public ArrayList<CommandLine> getAllCommandLinesForCurrentUser(Integer idCommand)
	{
		ArrayList <CommandLine> commandLine = commandLineDAO.getAllCommandLines();
		ArrayList <CommandLine> commandLines = new ArrayList<>();
		for(int i=0;i<commandLine.size();i++)
		{
			if(commandLine.get(i).getCommand() == idCommand)
			{
				commandLines.add(commandLine.get(i));
			}			
		}
		return commandLines;
	}
}
