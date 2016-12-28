package com.spring.henallux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.henallux.model.Figurine;
import com.spring.henallux.model.User;


@Controller
@RequestMapping(value="/description")
public class DescriptionController 
{	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model)
	{
		
		return "integrated:description";
	}
	
	@RequestMapping(value="/figurine",
					params={"descriptionFigurine"},
					method=RequestMethod.GET)
	public String getFigurineDescription(@RequestParam(required=false, defaultValue="Pas de description")final String descriptionFigurine, final Model model)
	{
		model.addAttribute("descriptionToDisplay", descriptionFigurine);
		return "integrated:description";
	}
	
	//Bouton pour la COMMANDE===============================================
	@RequestMapping(value="/command", method=RequestMethod.POST)
	public String getFormCommandData(Model model, @ModelAttribute(value="command") User userCommand)
	{
		return "integrated:userCommand";
	}
}
