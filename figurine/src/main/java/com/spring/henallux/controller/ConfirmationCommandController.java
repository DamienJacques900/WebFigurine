package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.model.CommandLineWithFigurine;
import com.spring.henallux.model.User;

@Controller
@RequestMapping(value="/confirmationCommand")
@SessionAttributes({ConnectionController.CURRENTUSERCONNECTION, ConnectionController.CURRENTUSER, DescriptionController.COMMANDLINES})
public class ConfirmationCommandController 
{
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, Locale locale, @ModelAttribute(value=ConnectionController.CURRENTUSER) User currentUser, @ModelAttribute(value=DescriptionController.COMMANDLINES) List<CommandLineWithFigurine> commandLinesWithFigurines)
	{
		return "integrated:confirmationCommand";
	}
}
