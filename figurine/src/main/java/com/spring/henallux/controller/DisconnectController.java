package com.spring.henallux.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.model.CommandLineWithFigurine;
import com.spring.henallux.model.User;
import com.spring.henallux.model.UserConnection;

@Controller
@RequestMapping(value="/disconnect")
@SessionAttributes({"currentUserConnection","currentUser","commandLinesWithItems"})
public class DisconnectController 
{
	 @RequestMapping(method=RequestMethod.GET)
	 public String home(Model model)
	 {
		  if(model.containsAttribute("currentUserConnection"))
		  {
			  model.addAttribute("currentUserConnection", new UserConnection());
			  model.addAttribute("currentUser", new User());
			  model.addAttribute("commandLinesWithItems", new ArrayList<CommandLineWithFigurine>());
		  }
			  
		  return "redirect:/welcome";  
	 }
}
