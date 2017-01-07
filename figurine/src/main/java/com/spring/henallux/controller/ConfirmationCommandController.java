package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.CommandDAO;
import com.spring.henallux.dataAccess.dao.CommandLineDAO;
import com.spring.henallux.model.Command;
import com.spring.henallux.model.CommandLine;
import com.spring.henallux.model.CommandLineWithFigurine;
import com.spring.henallux.model.Figurine;
import com.spring.henallux.model.User;

@Controller
@RequestMapping(value="/confirmationCommand")
@SessionAttributes({ConnectionController.CURRENTUSERCONNECTION, ConnectionController.CURRENTUSER, DescriptionController.COMMANDLINES})
public class ConfirmationCommandController 
{
	@Autowired
	private CommandDAO commandDAO;
	
	@Autowired
	private CommandLineDAO commandLineDAO;
	
	@ModelAttribute(value=ConnectionController.CURRENTUSER)
	public User currentUser()
	{
		return new User();
	}
	
	@ModelAttribute(value=DescriptionController.COMMANDLINES)
	public List<CommandLineWithFigurine> commandLinesWithItems()
	{
		return new ArrayList<CommandLineWithFigurine>();
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, Locale locale, @ModelAttribute(value=ConnectionController.CURRENTUSER) User currentUser, @ModelAttribute(value=DescriptionController.COMMANDLINES) List<CommandLineWithFigurine> commandLinesWithFigurines)
	{
		model.addAttribute("command", new Command());
		
		return "integrated:confirmationCommand";
	}

	@RequestMapping(value="/commandValidate", method=RequestMethod.POST)
	public String getCommand(Model model, @ModelAttribute(value="command") Command command, @ModelAttribute(value=ConnectionController.CURRENTUSER) User currentUser,@ModelAttribute(value=DescriptionController.COMMANDLINES) List<CommandLineWithFigurine> commandLinesWithFigurines)
	{	
		Command currentCommand = commandDAO.getCommandById(currentUser.getIdUser());
		for(CommandLineWithFigurine entity : commandLinesWithFigurines)
		{
			entity.getCommandLine().setCommand(currentCommand.getIdCommand());
		}

		Date dateNow = new Date();
		currentCommand.setDateCommand(dateNow);
		currentCommand.setPayed(true);
		commandDAO.save(currentCommand);
			
		command.setUser(currentUser.getIdUser());
		command.setPayed(false);
		dateNow = new Date();
		command.setDateCommand(dateNow);
		commandDAO.save(command);
			
			
					
		model.addAttribute("commandLinesWithItems", new ArrayList<CommandLineWithFigurine>());
		
		return "integrated:userCommand";
	}
	

	@RequestMapping(value="/commandNotValidate", method=RequestMethod.POST)
	public String getCommandUserRequired(Model model, @ModelAttribute(value="command") Command command,@ModelAttribute(value=ConnectionController.CURRENTUSER) User currentUser,@ModelAttribute(value=DescriptionController.COMMANDLINES) List<CommandLineWithFigurine> commandLinesWithFigurines
			,@ModelAttribute(value="figurineBasket") CommandLine commandLine, @ModelAttribute(value="deleteBasket") CommandLine commandLineD)
	{
		
		double TotalValue = 0;
		for(CommandLineWithFigurine entity : commandLinesWithFigurines)
		{
			TotalValue += entity.getFigurine().getCost()*entity.getCommandLine().getNbFigurine();
		}
		model.addAttribute("totalValue",TotalValue);
		
		return "integrated:basket";
	}
}
