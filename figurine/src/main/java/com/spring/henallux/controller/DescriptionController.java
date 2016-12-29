package com.spring.henallux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.henallux.model.Figurine;
import com.spring.henallux.model.User;
import com.spring.henallux.service.FigurinesService;


@Controller
@RequestMapping(value="/description")
public class DescriptionController 
{	
	@Autowired
	private FigurinesService figurinesService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model)
	{
		
		return "integrated:description";
	}
	
	@RequestMapping(value="/figurine",
					params={"idFigurine"},
					method=RequestMethod.GET)
	public String getFigurineDescription(@RequestParam(required=false, defaultValue="0")final int idFigurine, final Model model)
	{
		model.addAttribute("figurineDescription", figurinesService.getFigurineById(idFigurine));
		return "integrated:description";
	}
	
	//Bouton pour la COMMANDE===============================================
	@RequestMapping(value="/command", method=RequestMethod.POST)
	public String getCommand(Model model, @ModelAttribute(value="command") User userCommand)
	{
		
		return "integrated:userCommand";
	}
}
