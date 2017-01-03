package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.CommandLineDAO;
import com.spring.henallux.dataAccess.dao.LanguageDAO;
import com.spring.henallux.dataAccess.dao.TranslationCategoryDAO;
import com.spring.henallux.dataAccess.dao.TranslationFigurineDAO;
import com.spring.henallux.model.CommandLine;
import com.spring.henallux.model.CommandLineWithFigurine;
import com.spring.henallux.model.Figurine;
import com.spring.henallux.model.Language;
import com.spring.henallux.model.User;
import com.spring.henallux.model.TranslationFigurine;
import com.spring.henallux.service.FigurinesService;


@Controller
@RequestMapping(value="/description")
@SessionAttributes(DescriptionController.COMMANDLINES)
public class DescriptionController 
{	
	@Autowired
	private FigurinesService figurinesService;
	
	@Autowired
	private LanguageDAO languagesDAO;
	
	@Autowired
	private TranslationFigurineDAO translationFigurineDAO;
	
	@Autowired
	private CommandLineDAO commandLineDAO;
	
	@Autowired
	private FigurinesService figurineService;
	
	
	@ModelAttribute(value=ConnectionController.CURRENTUSER)
	public User currentUser()
	{
		return new User();
	}
	
	protected static final String COMMANDLINES = "commandLinesWithItems";
	
	@ModelAttribute(value=COMMANDLINES)
	public List<CommandLineWithFigurine> commandLinesWithFigurine()
	{
		return new ArrayList<CommandLineWithFigurine>();
	}
	
		
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, Locale locale)
	{
		model.addAttribute("figurineCommand", new Figurine());
		//Language language = languagesDAO.getLanguageByName(locale.toString());
		//model.addAttribute("figurineTranslations", translationFigurineDAO.getTransalationFigurineById(language.getIdLanguage()));
		return "integrated:description";
	}
	
	/*@RequestMapping(value="/figurine",
					params={"idFigurine"},
					method=RequestMethod.GET)
	public String getFigurineDescription(@RequestParam(required=false, defaultValue="0")final int idFigurine, final Model model, Locale locale)
	{
		TranslationFigurine translationFigurine = new TranslationFigurine();
		model.addAttribute("figurine", figurinesService.getFigurineById(idFigurine));	
		Language language = languagesDAO.getLanguageByName(locale.toString());	
		translationFigurine = translationFigurineDAO.getTransalationFigurineById(idFigurine,language.getIdLanguage());
		model.addAttribute("figurineTranslations", translationFigurine );

		return "integrated:description";
	}*/
	
	
	
	@RequestMapping("/figurine/{figurineId}")
	public String byCategory(Model model, @PathVariable("figurineId") Integer figurineId, Locale locale, @ModelAttribute(value=COMMANDLINES) List<CommandLineWithFigurine> commandLinesWithFigurine)
	{
		model.addAttribute("figurine", figurinesService.getFigurineById(figurineId));	
		Language language = languagesDAO.getLanguageByName(locale.toString());	
		model.addAttribute("figurineTranslations", translationFigurineDAO.getTransalationFigurineById(figurineId,language.getIdLanguage()));
		model.addAttribute("figurineCommand", new CommandLine());
		model.addAttribute(COMMANDLINES, commandLinesWithFigurine);
		
		return "integrated:description";
	}
	
	//Bouton pour la COMMANDE===============================================
	@RequestMapping(value="/figurineBasket", method = RequestMethod.POST)
	public String getCommand(Model model, @ModelAttribute(value="figurineCommand") CommandLine commandLine, @ModelAttribute(value="currentUser") User currentUser
			, @ModelAttribute(value=COMMANDLINES) ArrayList<CommandLineWithFigurine> commandLinesWithFigurine)
	{		
		Figurine figurine = figurineService.getFigurineById(commandLine.getFigurine());
		
		if(currentUser.getIdUser() == null)
		{
			commandLinesWithFigurine.add(new CommandLineWithFigurine(commandLine, figurine));
		}
		commandLine.setCommand(1);
		
		commandLineDAO.save(commandLine);

		return "redirect:/basket";
	}
}
