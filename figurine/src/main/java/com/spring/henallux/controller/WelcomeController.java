package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.spring.henallux.dataAccess.dao.PromotionDAO;
import com.spring.henallux.dataAccess.dao.TranslationCategoryDAO;
import com.spring.henallux.dataAccess.dao.TranslationFigurineDAO;
import com.spring.henallux.model.Figurine;
import com.spring.henallux.model.Language;
import com.spring.henallux.model.Promotion;
import com.spring.henallux.model.TranslationFigurine;
import com.spring.henallux.model.User;
import com.spring.henallux.service.FigurinesService;
import com.spring.henallux.service.PromotionService;

@Controller
@RequestMapping(value="/welcome")
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
	private PromotionDAO promotionDAO;
	
	@Autowired
	private PromotionService promotionService;
	
	@Autowired
	private TranslationCategoryDAO translationCategoriesDAO;
	
	@Autowired
	private FigurinesService figurinesService;
	
	@Autowired
	private TranslationFigurineDAO translationFigurineDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, Locale locale)
	{	
		ArrayList<Promotion> currentPromotion = new ArrayList<Promotion>();
		currentPromotion = promotionService.getPromotionValid();
		
		model.addAttribute("promotionAll", currentPromotion);		
		
		ArrayList<Figurine> figurineWithPromotion = figurinesDAO.getAllFigurines();
		for(int i = 0; i < figurineWithPromotion.size(); i++)
		{
			for(int j = 0; j < currentPromotion.size(); j++)
			{
				if(figurineWithPromotion.get(i).getPromotion() == currentPromotion.get(j).getIdPromotion())
				{
					figurineWithPromotion.get(i).setCost(figurineWithPromotion.get(i).getCost()*(1-currentPromotion.get(j).getAmountPourc()));
				}
			}
		}
		
		model.addAttribute("categoryAll", categoriesDAO.getAllCategories());
		model.addAttribute("figurineAll", figurineWithPromotion);
		Language language = languagesDAO.getLanguageByName(locale.toString());
		model.addAttribute("categoryTranslations", translationCategoriesDAO.getTransalationCategoryById(language.getIdLanguage()));
		model.addAttribute("figurineTranslations", translationFigurineDAO.getAllTranslationFigurinesByLanguage(language.getIdLanguage()));
		model.addAttribute("figurineName", new Figurine());
		
		return "integrated:welcome";
	}
	
	@RequestMapping("/byCategory/{categoryId}")
	public String byCategory(Model model, @PathVariable("categoryId") Integer categoryId, Locale locale)
	{
		ArrayList<Promotion> currentPromotion = new ArrayList<Promotion>();
		currentPromotion = promotionService.getPromotionValid();
		
		model.addAttribute("promotionAll", currentPromotion);		
		
		ArrayList<Figurine> figurineWithPromotion = figurinesService.getFigurineByCategory(categoryId);
		for(int i = 0; i < figurineWithPromotion.size(); i++)
		{
			for(int j = 0; j < currentPromotion.size(); j++)
			{
				if(figurineWithPromotion.get(i).getPromotion() == currentPromotion.get(j).getIdPromotion())
				{
					figurineWithPromotion.get(i).setCost(figurineWithPromotion.get(i).getCost()*(1-currentPromotion.get(j).getAmountPourc()));
				}
			}
		}
		
		
		model.addAttribute("figurineAll", figurineWithPromotion);	
		model.addAttribute("categoryAll", categoriesDAO.getAllCategories());
		Language language = languagesDAO.getLanguageByName(locale.toString());	
		model.addAttribute("categoryTranslations", translationCategoriesDAO.getTransalationCategoryById(language.getIdLanguage()));
		model.addAttribute("figurineTranslations", translationFigurineDAO.getTransalationFigurineByIdCatAndLanguage(categoryId,language.getIdLanguage()));
		model.addAttribute("figurineName", new Figurine());
		return "integrated:welcome";
	}
	//Bouton pour RECHERCHER par nom===============================================
	@RequestMapping(value="/searchName", method=RequestMethod.POST)
	public String getCommand(Model model, @ModelAttribute(value="figurineName") Figurine figurine, Locale locale)
	{
		ArrayList<Promotion> currentPromotion = new ArrayList<Promotion>();
		currentPromotion = promotionService.getPromotionValid();
		
		model.addAttribute("promotionAll", currentPromotion);
		
		model.addAttribute("categoryAll", categoriesDAO.getAllCategories());
		Language language = languagesDAO.getLanguageByName(locale.toString());
		ArrayList<TranslationFigurine> figurines = translationFigurineDAO.getFigurinesByNameAndLanguage(figurine.getName().toLowerCase(), language.getIdLanguage());
		ArrayList<Figurine> figurineAll = new ArrayList<Figurine>();
		
		Figurine figurineValue;
		for(int i = 0; i < figurines.size(); i++)
		{
			figurineValue = figurinesService.getFigurineById(figurines.get(i).getFigurine());
			for(int j = 0; j < currentPromotion.size(); j++)
			{
				if(figurineValue.getPromotion() == currentPromotion.get(j).getIdPromotion())
				{
					figurineValue.setCost(figurineValue.getCost()*(1-currentPromotion.get(j).getAmountPourc()));
				}
			}
			figurineAll.add(figurineValue);
		}
		model.addAttribute("figurineAll", figurineAll);		
		model.addAttribute("figurineTranslations", figurines);
		model.addAttribute("categoryTranslations", translationCategoriesDAO.getTransalationCategoryById(language.getIdLanguage()));
		model.addAttribute("figurineName", new Figurine());

		return "integrated:welcome";
	}
	
	
}
