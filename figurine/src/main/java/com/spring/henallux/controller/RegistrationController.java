package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class RegistrationController 
{
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model)
	{
		model.addAttribute("userRegistration", new User());
		return "integrated:registration";
	}

	//Bouton pour l'INSCRIPTION====================================
	@RequestMapping(value="/registrationSend", method=RequestMethod.POST)
	public String getFormRegistrationData(Model model,@Valid @ModelAttribute(value="userRegistration") User userRegistration,Errors errors)
	{
		CryptPassword crypt = new CryptPassword();
			
		if(!userRegistration.getPassword().equals(userRegistration.getConfirmationPassword()))
		{
			errors.rejectValue("confirmationPassword", "errorNotSamePassword");
		}
		
		String regex = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)";
		 
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(userRegistration.getEmail());
		
		if(!matcher.matches())
		{
			errors.rejectValue("email", "errorMail");
		}								
			
		if(!errors.hasErrors())
		{
			User user = userDAO.getUsersById(userRegistration.getIdUser());
			if(user != null && user.getIdUser().equals(userRegistration.getIdUser()))
			{
				errors.rejectValue("idUser", "errorUserIdAlreadyExist");
			}	
			else
			{
				userRegistration.setPassword(crypt.cryptInMD5(userRegistration.getPassword()));
				userDAO.save(userRegistration);	
				return "redirect:/userRegistration";
			}
		}		
		
		return "integrated:registration";	
	}
}
