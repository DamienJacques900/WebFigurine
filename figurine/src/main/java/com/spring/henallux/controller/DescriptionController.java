package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.Date;
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

import com.spring.henallux.dataAccess.dao.CommandDAO;
import com.spring.henallux.dataAccess.dao.CommandLineDAO;
import com.spring.henallux.dataAccess.dao.LanguageDAO;
import com.spring.henallux.dataAccess.dao.PromotionDAO;
import com.spring.henallux.dataAccess.dao.TranslationCategoryDAO;
import com.spring.henallux.dataAccess.dao.TranslationFigurineDAO;
import com.spring.henallux.model.Command;
import com.spring.henallux.model.CommandLine;
import com.spring.henallux.model.CommandLineWithFigurine;
import com.spring.henallux.model.Figurine;
import com.spring.henallux.model.Language;
import com.spring.henallux.model.Promotion;
import com.spring.henallux.model.User;
import com.spring.henallux.model.TranslationFigurine;
import com.spring.henallux.service.FigurinesService;
import com.spring.henallux.service.PromotionService;


@Controller
@RequestMapping(value="/description")
@SessionAttributes({DescriptionController.COMMANDLINES,"currentUser"})
public class DescriptionController 
{	
	@Autowired
	private FigurinesService figurinesService;
	
	@Autowired
	private LanguageDAO languagesDAO;
	
	@Autowired
	private PromotionDAO promotionDAO;
	
	@Autowired
	private PromotionService promotionService;
	
	@Autowired
	private TranslationFigurineDAO translationFigurineDAO;
	
	@Autowired
	private CommandLineDAO commandLineDAO;
	
	@Autowired
	private CommandDAO commandDAO;
	
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
		ArrayList<Promotion> currentPromotion = new ArrayList<Promotion>();
		currentPromotion = promotionService.getPromotionValid();
		
		Figurine figurineDescription = figurinesService.getFigurineById(figurineId);
		double prizeWithoutPromotion = figurineDescription.getCost();
		
		for(int i = 0; i < currentPromotion.size(); i++)
		{
			if(currentPromotion.get(i).getIdPromotion() == figurineDescription.getPromotion())
			{		
				figurineDescription.setCost(figurineDescription.getCost()*(1-currentPromotion.get(i).getAmountPourc()));
			}
		}
		
		model.addAttribute("prizeWithoutPromotion",prizeWithoutPromotion);		
		
		model.addAttribute("figurine", figurineDescription);	
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
		ArrayList<Promotion> currentPromotion = new ArrayList<Promotion>();
		currentPromotion = promotionService.getPromotionValid();
		
		Figurine figurine = figurineService.getFigurineById(commandLine.getFigurine());
		
		for(int i = 0; i < currentPromotion.size(); i++)
		{
			if(currentPromotion.get(i).getIdPromotion() == figurine.getPromotion())
			{				
				figurine.setCost(figurine.getCost()*(1-currentPromotion.get(i).getAmountPourc()));
			}
		}
		
		
		
		if(currentUser.getIdUser() == null)
		{
			commandLinesWithFigurine.add(new CommandLineWithFigurine(commandLine, figurine));
		}
		else
		{			
			commandLinesWithFigurine.add(new CommandLineWithFigurine(commandLine, figurine));	
			Command command = commandDAO.getCommandById(currentUser.getIdUser());
			commandLine.setCommand(command.getIdCommand());
			commandLineDAO.save(commandLine);			
		}
		

		return "redirect:/basket";
	}
}
