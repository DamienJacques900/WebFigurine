package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.CommandLineDAO;
import com.spring.henallux.dataAccess.dao.FigurineDAO;
import com.spring.henallux.dataAccess.dao.LanguageDAO;
import com.spring.henallux.dataAccess.dao.TranslationFigurineDAO;
import com.spring.henallux.model.CommandLine;
import com.spring.henallux.model.CommandLineWithFigurine;
import com.spring.henallux.model.Language;
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
	private CommandLineDAO commandLineDAO;
	
	@Autowired
	private FigurineDAO figurineDAO;
	
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
		model.addAttribute("figurineTranslations", translationFigurineDAO.getAllTranslationFigurinesByLanguage(language.getIdLanguage()));
		model.addAttribute("totalValue",commandLinesService.getTotalValueCommandLine());
		model.addAttribute("figurineBasket", new CommandLine());
		model.addAttribute("deleteBasket", new CommandLine());
		return "integrated:basket";
	}
	
	//Bouton pour COMMANDER si connecté===============================================
	@RequestMapping(value="/command", method=RequestMethod.POST)
	public String getCommand(Model model, @ModelAttribute(value="command") User userCommand)
	{
		return "integrated:userCommand";
	}
	
	//Bouton pour COMMANDER si pas connecté===============================================
	@RequestMapping(value="/commandNotPossible", method=RequestMethod.POST)
	public String getCommandUserRequired(Model model, @ModelAttribute(value="command") User userCommand)
	{
		return "integrated:userCommandRequired";
	}
	
	//Bouton pour MODIFIER===============================================
	@RequestMapping(value="/nbFigurineBasket", method = RequestMethod.POST)
	public String modifiyCommandLine(Model model, @ModelAttribute(value="figurineBasket") CommandLine commandLine)
	{			
		commandLine.setNbFigurine(commandLine.getNbFigurine());		
		commandLineDAO.save(commandLine);
		return "redirect:/basket";
	}
	
	//Bouton pour SUPPRIMER===============================================
	@RequestMapping(value="/deleteFigurineBasket", method = RequestMethod.POST)
	public String deleteCommandLine(Model model, @ModelAttribute(value="deleteBasket") CommandLine commandLine)
	{				
		commandLineDAO.delete(commandLine);
		return "redirect:/basket";
	}
	
}
