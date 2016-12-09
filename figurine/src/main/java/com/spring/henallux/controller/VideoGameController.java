package com.spring.henallux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.henallux.model.Figurine;
import com.spring.henallux.service.FigurinesService;

@Controller
@RequestMapping(value="/videoGame")
public class VideoGameController 
{
	@Autowired
	private FigurinesService figurinesService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model)
	{
		//***************************COMMENTAIRE************************************
		//Récupération des valeurs des figurines pour la BD, ici on récupère juste les 
		//valeurs pour les figurines des jeux vidéo
		//**************************************************************************
		model.addAttribute("figurineVideoGame", figurinesService.getFigurinesVideoGame());
		model.addAttribute("addBasket", new Figurine());
		model.addAttribute("searchName", new Figurine());
		model.addAttribute("searchPrize", new Figurine());
		model.addAttribute("searchHeight", new Figurine());
		model.addAttribute("searchWeight", new Figurine());
		model.addAttribute("searchBrand", new Figurine());
		return "integrated:videoGame";
	}
	
	//Bouton pour la AJOUTER PANIER===============================================
	@RequestMapping(value="/addBasket", method=RequestMethod.POST)
	public String getFormCommandData(Model model, @ModelAttribute(value="addBasket") Figurine figurineBasket)
	{
		return "redirect:/userCommand";
	}
	
	//Bouton pour CHERCHER NOM===============================================
	@RequestMapping(value="/searchName", method=RequestMethod.POST)
	public String getFormSearcName(Model model, @ModelAttribute(value="searchName") Figurine figurineBasket)
	{
		return "redirect:/userCommand";
	}
	//Bouton pour CHERCHER PRIX===============================================
	@RequestMapping(value="/searchPrize", method=RequestMethod.POST)
	public String getFormSearchPrize(Model model, @ModelAttribute(value="searchPrize") Figurine figurineBasket)
	{
		return "redirect:/userCommand";
	}
	//Bouton pour CHERCHER TAILLE===============================================
	@RequestMapping(value="/searchHeight", method=RequestMethod.POST)
	public String getFormSearchHeight(Model model, @ModelAttribute(value="searchHeight") Figurine figurineBasket)
	{
		return "redirect:/userCommand";
	}
	//Bouton pour CHERCHER POIDS===============================================
	@RequestMapping(value="/searchWeight", method=RequestMethod.POST)
	public String getFormSearchWeight(Model model, @ModelAttribute(value="searchWeight") Figurine figurineBasket)
	{
		return "redirect:/:userCommand";
	}
	//Bouton pour CHERCHER MARQUE===============================================
	@RequestMapping(value="/searchBrand", method=RequestMethod.POST)
	public String getFormSearchBRand(Model model, @ModelAttribute(value="searchBrand") Figurine figurineBasket)
	{
		return "redirect:/userCommand";
	}
}
