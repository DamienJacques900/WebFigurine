package com.spring.henallux.controller;

import java.util.Locale;

//import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.CategoryDAO;
import com.spring.henallux.dataAccess.dao.FigurineDAO;
import com.spring.henallux.dataAccess.dao.LanguageDAO;
import com.spring.henallux.model.Figurine;
import com.spring.henallux.model.Language;
import com.spring.henallux.service.FigurinesService;

@Controller
@RequestMapping(value="/welcome")
@SessionAttributes({"currentUserConnection"})
public class WelcomeController 
{
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private FigurineDAO figurinesDAO;
	
	@Autowired
	private CategoryDAO categoriesDAO;
	
	@Autowired
	private LanguageDAO languagesDAO;
	
	@Autowired
	private FigurinesService figurinesService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model)
	{
		//***************************COMMENTAIRE************************************
		//Permet de récupérer toutes les figurines de la BD
		//**************************************************************************
		System.out.println("currentUserConnection");
		model.addAttribute("categoryAll", categoriesDAO.getAllCategories());
		model.addAttribute("figurineAll", figurinesDAO.getAllFigurines());
		model.addAttribute("Manga", figurinesService.getFigurinesJapaneseAnimation());
		model.addAttribute("Film", figurinesService.getFigurinesMovie());
		model.addAttribute("Jeux vidéo", figurinesService.getFigurinesVideoGame());
		return "integrated:welcome";
	}
	/*
	//Bouton pour choisir VIDEO GAMES===============================================
	@RequestMapping(value="/Jeux vidéo", method=RequestMethod.POST)
	public String getVideoGamesCategory(Model model, @ModelAttribute(value="Jeux vidéo") Figurine figurineAnimation)
	{
		return "redirect:/welcome";
	}
	
	//Bouton pour choisir ANIMATIONS===============================================
	@RequestMapping(value="/Manga", method=RequestMethod.POST)
	public String getAnimationCategory(Model model, @ModelAttribute(value="Manga") Figurine figurineAnimation)
	{
		return "redirect:/welcome";
	}
		
	//Bouton pour choisir MOVIES===============================================
	@RequestMapping(value="/Film", method=RequestMethod.POST)
	public String getMovieCategory(Model model, @ModelAttribute(value="Film") Figurine figurineAnimation)
	{
		return "redirect:/welcome";
	}
	*/
	
	@RequestMapping("/byCategory/{categoryId}")
	public String byCategory(Model model, @PathVariable("categoryId") Integer categoryId, Locale locale)
	{
		model.addAttribute("figurineAll", figurinesService.getFigurineByCategory(categoryId));
		model.addAttribute("categoryAll", categoriesDAO.getAllCategories());
		//Language currentLanguage = languagesDAO.getLanguageByLabel(locale.toString());
		//model.addAttribute("categoryTranslations", categoryTranslationDAO.getCategoryTranslationsByLanguage(currentLanguage.getIdLanguage()));
		return "integrated:welcome";
	}
	
	
	
	
}
