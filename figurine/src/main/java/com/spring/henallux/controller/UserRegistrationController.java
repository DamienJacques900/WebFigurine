package com.spring.henallux.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/userRegistration")
public class UserRegistrationController 
{
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, Locale locale)
	{
		return "integrated:userRegistration";
	}
	
}
