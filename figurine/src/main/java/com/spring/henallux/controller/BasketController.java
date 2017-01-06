package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.CommandDAO;
import com.spring.henallux.dataAccess.dao.CommandLineDAO;
import com.spring.henallux.dataAccess.dao.FigurineDAO;
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
import com.spring.henallux.service.*;


@Controller
@RequestMapping(value="/basket")
@SessionAttributes({ConnectionController.CURRENTUSERCONNECTION, ConnectionController.CURRENTUSER, DescriptionController.COMMANDLINES})
public class BasketController 
{
	@Autowired
	private CommandLinesService commandLinesService;
	
	@Autowired
	private CommandsService commandsService;
	
	@Autowired
	private CommandDAO commandDAO;
	
	@Autowired
	private CommandLineDAO commandLineDAO;
	
	@Autowired
	private FigurineDAO figurineDAO;
	
	@Autowired
	private FigurinesService figurineService;
	
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
		//***************************COMMENTAIRE************************************
		//Récupération des valeurs de la BD pour les command et commandLine
		//**************************************************************************
		model.addAttribute("command",commandsService.getCommand());
		model.addAttribute("commandLines",commandLinesService.getCommandLines());
		model.addAttribute("figurineAllCommand",figurineDAO.getAllFigurines());
		Language language = languagesDAO.getLanguageByName(locale.toString());
		
		ArrayList<Promotion> currentPromotion = new ArrayList<Promotion>();
		currentPromotion = promotionService.getPromotionValid();
		
		model.addAttribute("promotionAll", currentPromotion);
		
		ArrayList<TranslationFigurine> translationFigurines = translationFigurineDAO.getAllTranslationFigurines();
		ArrayList<TranslationFigurine> translationBasket = new ArrayList<TranslationFigurine>();
		for(int i = 0; i < commandLinesWithFigurines.size(); i++)
		{
			//=========================================
			Figurine figurine = figurineService.getFigurineById(commandLinesWithFigurines.get(i).getFigurine().getIdFigurine());
			
			for(int k = 0; k < currentPromotion.size(); k++)
			{
				if(currentPromotion.get(k).getIdPromotion() == figurine.getPromotion())
				{				
					figurine.setCost(figurine.getCost()*(1-currentPromotion.get(k).getAmountPourc()));
				}
			}
			
			commandLinesWithFigurines.get(i).getFigurine().setCost(figurine.getCost());

			//=================================================
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
		model.addAttribute("figurineBasket", new CommandLine());
		model.addAttribute("deleteBasket", new CommandLine());
		return "integrated:basket";
	}
	
	//Bouton pour COMMANDER si connecté===============================================
	@RequestMapping(value="/command", method=RequestMethod.POST)
	public String getCommand(Model model, @ModelAttribute(value="command") Command command, @ModelAttribute(value=ConnectionController.CURRENTUSER) User currentUser,@ModelAttribute(value=DescriptionController.COMMANDLINES) List<CommandLineWithFigurine> commandLinesWithFigurines)
	{	
		Command currentCommand = commandDAO.getCommandById(currentUser.getIdUser());
		for(CommandLineWithFigurine entity : commandLinesWithFigurines)
		{
			entity.getCommandLine().setCommand(currentCommand.getIdCommand());
			CommandLine newCommandLine = entity.getCommandLine();
			newCommandLine.setCommand(currentCommand.getIdCommand());
			commandLineDAO.save(newCommandLine);
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
	
	//Bouton pour COMMANDER si pas connecté===============================================
	@RequestMapping(value="/commandNotPossible", method=RequestMethod.POST)
	public String getCommandUserRequired(Model model, @ModelAttribute(value="command") Command command)
	{
		return "integrated:userCommandRequired";
	}
	
	//Bouton pour MODIFIER===============================================
	@RequestMapping(value="/nbFigurineBasket", method = RequestMethod.POST)
	public String modifiyCommandLine(Model model, @ModelAttribute(value="figurineBasket") CommandLine commandLine, @ModelAttribute(value=DescriptionController.COMMANDLINES) List<CommandLineWithFigurine> commandLinesWithFigurine
			, @ModelAttribute(value=ConnectionController.CURRENTUSER) User currentUser)
	{	
		ArrayList<Promotion> currentPromotion = new ArrayList<Promotion>();
		currentPromotion = promotionService.getPromotionValid();
		
		for(CommandLineWithFigurine entity : commandLinesWithFigurine)
		{
			if(commandLine.getIdCommandeLine() == entity.getCommandLine().getIdCommandeLine())
			{
				//=================================================
				Figurine figurine = figurineService.getFigurineById(entity.getFigurine().getIdFigurine());
				
				for(int k = 0; k < currentPromotion.size(); k++)
				{
					if(currentPromotion.get(k).getIdPromotion() == figurine.getPromotion())
					{				
						figurine.setCost(figurine.getCost()*(1-currentPromotion.get(k).getAmountPourc()));
					}
				}
				
				entity.getFigurine().setCost(figurine.getCost());
				//=================================================
				
				entity.getCommandLine().setNbFigurine(commandLine.getNbFigurine());
			}
		}
		
		if(currentUser.getIdUser() != null)
		{
			commandLine.setNbFigurine(commandLine.getNbFigurine());		
			commandLineDAO.save(commandLine);
		}
		
		return "redirect:/basket";
	}
	
	//Bouton pour SUPPRIMER===============================================
	@RequestMapping(value="/deleteFigurineBasket", method = RequestMethod.POST)
	public String deleteCommandLine(Model model, @ModelAttribute(value="deleteBasket") CommandLine commandLine,@ModelAttribute(value=DescriptionController.COMMANDLINES) List<CommandLineWithFigurine> commandLinesWithFigurine
			, @ModelAttribute(value=ConnectionController.CURRENTUSER) User currentUser)
	{		
		
		for(CommandLineWithFigurine entity : commandLinesWithFigurine)
		{
			if(commandLine.getIdCommandeLine() == entity.getCommandLine().getIdCommandeLine())
			{
				commandLinesWithFigurine.remove(entity);
				break;
			}
		}
		if(currentUser.getIdUser() != null)
		{
			commandLineDAO.delete(commandLine);
		}
		
		return "redirect:/basket";
	}
	
}
