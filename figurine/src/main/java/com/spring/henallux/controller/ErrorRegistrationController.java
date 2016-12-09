package com.spring.henallux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.henallux.model.User;

@Controller
@RequestMapping(value="/errorRegistration")
public class ErrorRegistrationController 
{
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model)
	{
		return "integrated:errorRegistration";
	}
}
