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
import com.spring.henallux.dataAccess.dao.TranslationCategoryDAO;
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
	private TranslationCategoryDAO categoriesTranslationDAO;
	
	@Autowired
	private FigurinesService figurinesService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, Locale locale)
	{
		//***************************COMMENTAIRE************************************
		//Permet de récupérer toutes les figurines de la BD
		//**************************************************************************
		model.addAttribute("categoryAll", categoriesDAO.getAllCategories());
		model.addAttribute("figurineAll", figurinesDAO.getAllFigurines());
		Language language = languagesDAO.getLanguageByName(locale.toString());		
		model.addAttribute("categoryTranslations", categoriesTranslationDAO.getTransalationCategoryById(language.getIdLanguage()));
		return "integrated:welcome";
	}
	
	@RequestMapping("/byCategory/{categoryId}")
	public String byCategory(Model model, @PathVariable("categoryId") Integer categoryId, Locale locale)
	{
		if(categoryId>categoriesDAO.getAllCategories().size())
			model.addAttribute("figurineAll", figurinesService.getFigurineByCategory(categoryId-categoriesDAO.getAllCategories().size()));		
		else
			model.addAttribute("figurineAll", figurinesService.getFigurineByCategory(categoryId));	

		model.addAttribute("categoryAll", categoriesDAO.getAllCategories());
		Language language = languagesDAO.getLanguageByName(locale.toString());		
		model.addAttribute("categoryTranslations", categoriesTranslationDAO.getTransalationCategoryById(language.getIdLanguage()));
		return "integrated:welcome";
	}
	
	
	
	
}
