package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.henallux.dataAccess.dao.LanguageDAO;
import com.spring.henallux.dataAccess.dao.TranslationCategoryDAO;
import com.spring.henallux.dataAccess.dao.TranslationFigurineDAO;
import com.spring.henallux.model.Figurine;
import com.spring.henallux.model.Language;
import com.spring.henallux.model.User;
import com.spring.henallux.model.TranslationFigurine;
import com.spring.henallux.service.FigurinesService;


@Controller
@RequestMapping(value="/description")
public class DescriptionController 
{	
	@Autowired
	private FigurinesService figurinesService;
	
	@Autowired
	private LanguageDAO languagesDAO;
	
	@Autowired
	private TranslationFigurineDAO translationFigurineDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, Locale locale)
	{
		//Language language = languagesDAO.getLanguageByName(locale.toString());
		//model.addAttribute("figurineTranslations", translationFigurineDAO.getTransalationFigurineById(language.getIdLanguage()));
		return "integrated:description";
	}
	
	@RequestMapping(value="/figurine",
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
	}
	
	
	
	@RequestMapping("/figurine/{figurineId}")
	public String byCategory(Model model, @PathVariable("figurineId") Integer figurineId, Locale locale)
	{
		model.addAttribute("figurine", figurinesService.getFigurineById(figurineId));	
		Language language = languagesDAO.getLanguageByName(locale.toString());	
		model.addAttribute("figurineTranslations", translationFigurineDAO.getTransalationFigurineById(figurineId,language.getIdLanguage()));
		return "integrated:description";
	}
	
	//Bouton pour la COMMANDE===============================================
	@RequestMapping(value="/command", method=RequestMethod.POST)
	public String getCommand(Model model, @ModelAttribute(value="command") User userCommand)
	{
		
		return "integrated:userCommand";
	}
}
