package com.spring.henallux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.henallux.dataAccess.dao.FigurineDAO;
import com.spring.henallux.model.Figurine;

@Controller
@RequestMapping(value="/userConnection")
public class UserConnectionController 
{
	@Autowired
	private FigurineDAO figurinesDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model)
	{
		model.addAttribute("figurineAll", figurinesDAO.getAllFigurines());
		model.addAttribute("description", new Figurine());
		return "integrated:userConnection";
	}
	
	//Bouton pour la AJOUTER PANIER===============================================
	@RequestMapping(value="/addBasket", method=RequestMethod.POST)
	public String getFormCommandData(Model model, @ModelAttribute(value="addBasket") Figurine figurineBasket)
	{
		return "redirect:/userCommand";
	}
	
	//Bouton pour la AJOUTER PANIER===============================================
	@RequestMapping(value="/description", method=RequestMethod.POST)
	public String getDescriptionData(Model model, @ModelAttribute(value="description") Figurine figurineDescription)
	{
		return "redirect:/description";
	}
		
}
