package com.spring.henallux.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.henallux.dataAccess.dao.CommandLineDAO;
import com.spring.henallux.dataAccess.dao.FigurineDAO;
import com.spring.henallux.dataAccess.dao.LanguageDAO;
import com.spring.henallux.dataAccess.dao.TranslationFigurineDAO;
import com.spring.henallux.model.CommandLine;
import com.spring.henallux.model.Language;
import com.spring.henallux.model.User;
import com.spring.henallux.service.*;


@Controller
@RequestMapping(value="/basket")
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
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, Locale locale)
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
	
	//Bouton pour la COMMANDE===============================================
	@RequestMapping(value="/command", method=RequestMethod.POST)
	public String getFormCommandData(Model model, @ModelAttribute(value="command") User userCommand)
	{
		return "integrated:userCommand";
	}
	
	@RequestMapping(value="/nbFigurineBasket", method = RequestMethod.POST)
	public String modifiyCommandLine(Model model, @ModelAttribute(value="figurineBasket") CommandLine commandLine)
	{			
		commandLine.setNbFigurine(commandLine.getNbFigurine());		
		commandLineDAO.save(commandLine);
		return "redirect:/basket";
	}
	
	@RequestMapping(value="/deleteFigurineBasket", method = RequestMethod.POST)
	public String deleteCommandLine(Model model, @ModelAttribute(value="deleteBasket") CommandLine commandLine)
	{				
		commandLineDAO.delete(commandLine);
		return "redirect:/basket";
	}
	
}
