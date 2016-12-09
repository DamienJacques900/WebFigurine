package com.spring.henallux.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.UserDAO;
import com.spring.henallux.model.User;

@Controller
@RequestMapping(value="/connection")
@SessionAttributes(ConnectionController.CURRENTUSERCONNECTION)
public class ConnectionController 
{
	@Autowired
	private UserDAO userDAO;
	
	protected static final String CURRENTUSERCONNECTION = "currentUserConnectoin";
	
	@ModelAttribute(CURRENTUSERCONNECTION)
	public User user()
	{
		return new User();
	}

	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model)
	{
		model.addAttribute("connection", new User());
		return "integrated:connection";
	}
	//
	//Bouton pour la CONNEXION=====================================
	@RequestMapping(value="/connectionSend", method=RequestMethod.POST)
	public String getFormConnectionData(Model model,@Valid @ModelAttribute(value=CURRENTUSERCONNECTION) User userConnection, final BindingResult errors)
	{
		if(!errors.hasErrors())
		{
			String userName = userConnection.getIdUser();
			String userPassword = userConnection.getPassword();
			
			ArrayList <User> users = userDAO.getUsers();
			int i = 0;
				
			while(i < users.size()-1 && users.get(i).getIdUser().equals(userName)==false)
			{
				i++;
			}	
				
			if(users.get(i).getIdUser().equals(userName) && users.get(i).getPassword().equals(userPassword))
				return "redirect:/userConnection";
		}
		
		return "integrated:connection";
	}
}
