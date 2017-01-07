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
import com.spring.henallux.dataAccess.dao.LanguageDAO;
import com.spring.henallux.dataAccess.dao.TranslationFigurineDAO;
import com.spring.henallux.model.Command;
import com.spring.henallux.model.CommandLine;
import com.spring.henallux.model.CommandLineWithFigurine;
import com.spring.henallux.model.Figurine;
import com.spring.henallux.model.Language;
import com.spring.henallux.model.Promotion;
import com.spring.henallux.model.TranslationFigurine;
import com.spring.henallux.model.User;
import com.spring.henallux.service.PromotionService;

@Controller
@RequestMapping(value="/confirmationCommand")
@SessionAttributes({ConnectionController.CURRENTUSERCONNECTION, ConnectionController.CURRENTUSER, DescriptionController.COMMANDLINES})
public class ConfirmationCommandController 
{
	@Autowired
	private CommandDAO commandDAO;
	
	@Autowired
	private CommandLineDAO commandLineDAO;
	
	@Autowired
	private PromotionService promotionService;
	
	@Autowired
	private TranslationFigurineDAO translationFigurineDAO;
	
	@Autowired
	private LanguageDAO languagesDAO;
	
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
			,@ModelAttribute(value="figurineBasket") CommandLine commandLine, @ModelAttribute(value="deleteBasket") CommandLine commandLineD, Locale locale)
	{
		Language language = languagesDAO.getLanguageByName(locale.toString());
		
		ArrayList<Promotion> currentPromotion = new ArrayList<Promotion>();
		currentPromotion = promotionService.getPromotionValid();
		
		model.addAttribute("promotionAll", currentPromotion);
		
		ArrayList<TranslationFigurine> translationFigurines = translationFigurineDAO.getAllTranslationFigurines();
		ArrayList<TranslationFigurine> translationBasket = new ArrayList<TranslationFigurine>();
		for(int i = 0; i < commandLinesWithFigurines.size(); i++)
		{
			for(int j = 0; j < translationFigurines.size();j++)
			{
				if(commandLinesWithFigurines.get(i).getFigurine().getIdFigurine() == translationFigurines.get(j).getFigurine() 
						&& language.getIdLanguage() == translationFigurines.get(j).getLanguage())
					translationBasket.add(translationFigurines.get(j));
			}
		}
		
		model.addAttribute("figurineTranslations", translationBasket);
		
		double TotalValue = 0;
		for(CommandLineWithFigurine entity : commandLinesWithFigurines)
		{
			TotalValue += entity.getFigurine().getCost()*entity.getCommandLine().getNbFigurine();
		}
		model.addAttribute("totalValue",TotalValue);
		
		return "integrated:basket";
	}
}
