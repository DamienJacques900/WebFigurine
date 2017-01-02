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
import com.spring.henallux.service.CryptPassword;

@Controller
@RequestMapping(value="/registration")
//***************************COMMENTAIRE************************************
//Permet d'avoir un attribut session et donc de conserver les valeur que l'on mettre à l'intérieur
//**************************************************************************
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
		CryptPassword crypt = new CryptPassword();
		
		if(!errors.hasErrors())
		{
			Boolean existing = false;
			ArrayList<User> users = userDAO.getUsers();
			for(int i = 0; i < users.size();i++)
			{
				if(users.get(i).getIdUser().equals(userRegistration.getIdUser()))
				{
					existing = true;
					break;
				}					
			}
			if(!existing)
			{
				userRegistration.setPassword(crypt.cryptInMD5(userRegistration.getPassword()));
				userRegistration.setConfirmationPassword(crypt.cryptInMD5(userRegistration.getPassword()));
				userDAO.save(userRegistration);
				return "redirect:/userRegistration";	
			}	
						
			return "integrated:registration";
		}	
		
		return "integrated:registration";
	}
}
