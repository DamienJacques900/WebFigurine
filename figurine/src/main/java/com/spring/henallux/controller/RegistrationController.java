package com.spring.henallux.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.spring.henallux.dataAccess.dao.UserDAO;
import com.spring.henallux.dataAccess.entity.UserEntity;
import com.spring.henallux.model.*;

@Controller
@RequestMapping(value="/registration")
@SessionAttributes(RegistrationController.CURRENTUSERREGISTRATION)
public class RegistrationController 
{
	@Autowired
	private UserDAO userDAO;
	
	protected static final String CURRENTUSERREGISTRATION = "currentUserRegistration";
	
	@ModelAttribute(CURRENTUSERREGISTRATION)
	public User user()
	{
		return new User();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model)
	{
		model.addAttribute("registration", new User());
		return "integrated:registration";
	}

	
	//Bouton pour l'INSCRIPTION====================================
	@RequestMapping(value="/registrationSend", method=RequestMethod.POST)
	public String getFormRegistrationData(Model model,@Valid @ModelAttribute(value=CURRENTUSERREGISTRATION) User userRegistration,Errors errors)
	{
		if(!errors.hasErrors())
		{
			userDAO.save(userRegistration);
			return "redirect:/userRegistration";		
		}	
		
		return "integrated:registration";
	}
}
