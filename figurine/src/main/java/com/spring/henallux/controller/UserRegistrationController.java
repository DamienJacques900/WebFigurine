package com.spring.henallux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.henallux.dataAccess.dao.FigurineDAO;
import com.spring.henallux.model.Figurine;

@Controller
@RequestMapping(value="/userRegistration")
public class UserRegistrationController 
{
	@Autowired
	private FigurineDAO figurinesDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model)
	{
		//***************************COMMENTAIRE************************************
		//Permet de récupérer toutes les figurines de la BD
		//**************************************************************************
		model.addAttribute("figurineAll", figurinesDAO.getAllFigurines());			
		model.addAttribute("description", new Figurine());
		return "integrated:userRegistration";
	}
}
