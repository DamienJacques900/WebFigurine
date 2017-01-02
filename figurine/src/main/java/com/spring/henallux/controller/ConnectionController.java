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
import com.spring.henallux.model.UserConnection;
import com.spring.henallux.service.CryptPassword;

@Controller
@RequestMapping(value="/connection")
//***************************COMMENTAIRE************************************
//Permet d'avoir un attribut session et donc de conserver les valeur que l'on mettre à l'intérieur
//**************************************************************************
@SessionAttributes(ConnectionController.CURRENTUSERCONNECTION)
public class ConnectionController 
{
	@Autowired
	private UserDAO userDAO;
	
	protected static final String CURRENTUSERCONNECTION = "currentUserConnection";
	
	//***************************COMMENTAIRE************************************
	//Permet de dire que CURRENTUSERCONNECTION sera un objet de la classe User
	//**************************************************************************
	@ModelAttribute(CURRENTUSERCONNECTION)
	public UserConnection userConnection()
	{
		return new UserConnection();
	}

	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model)
	{
		model.addAttribute("connection", new UserConnection());
		return "integrated:connection";
	}
	//
	//Bouton pour la CONNEXION=====================================
	@RequestMapping(value="/connectionSend", method=RequestMethod.POST)
	public String getFormConnectionData(Model model,@Valid @ModelAttribute(value=CURRENTUSERCONNECTION) UserConnection userConnection, final BindingResult errors)
	{			
		CryptPassword crypt = new CryptPassword();
		
		
		String userName = userConnection.getIdUser();
		String userPassword = crypt.cryptInMD5(userConnection.getPassword());
		
		User user = userDAO.getUsersById(userName);

		if(user == null || !userPassword.equals(user.getPassword()))
		{
			errors.rejectValue("password", "errorConnection");
		}
		if(errors.hasErrors())
		{
			userConnection.setConnected(null);	
			return "integrated:connection";
		}	
			
		userConnection.setConnected("ok");
		return "redirect:/userConnection";
	}
}
