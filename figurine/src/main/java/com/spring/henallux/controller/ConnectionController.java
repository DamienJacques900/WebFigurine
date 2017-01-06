package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.CommandDAO;
import com.spring.henallux.dataAccess.dao.CommandLineDAO;
import com.spring.henallux.dataAccess.dao.UserDAO;
import com.spring.henallux.model.Command;
import com.spring.henallux.model.CommandLine;
import com.spring.henallux.model.CommandLineWithFigurine;
import com.spring.henallux.model.Figurine;
import com.spring.henallux.model.User;
import com.spring.henallux.model.UserConnection;
import com.spring.henallux.service.CryptPassword;
import com.spring.henallux.service.FigurinesService;

@Controller
@RequestMapping(value="/connection")
//***************************COMMENTAIRE************************************
//Permet d'avoir un attribut session et donc de conserver les valeur que l'on mettre à l'intérieur
//**************************************************************************
@SessionAttributes({ConnectionController.CURRENTUSERCONNECTION, ConnectionController.CURRENTUSER, DescriptionController.COMMANDLINES})
public class ConnectionController 
{
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CommandDAO commandDAO;
	
	@Autowired
	private CommandLineDAO commandLineDAO;
	
	@Autowired
	private FigurinesService figurineService;
	
	protected static final String CURRENTUSERCONNECTION = "currentUserConnection";
	
	//***************************COMMENTAIRE************************************
	//Permet de dire que CURRENTUSERCONNECTION sera un objet de la classe User
	//**************************************************************************
	@ModelAttribute(CURRENTUSERCONNECTION)
	public UserConnection userConnection()
	{
		return new UserConnection();
	}
	
	
	
	protected static final String CURRENTUSER = "currentUser";
	
	
	@ModelAttribute(value=CURRENTUSER)
	public User currentUser()
	{
		return new User();
	}
	
	
	@ModelAttribute(value=DescriptionController.COMMANDLINES)
	public List<CommandLineWithFigurine> commandLinesWithItems()
	{
		return new ArrayList<CommandLineWithFigurine>();
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
	public String getFormConnectionData(Model model, @ModelAttribute(value=CURRENTUSER) User currentUser ,@Valid @ModelAttribute(value=CURRENTUSERCONNECTION) UserConnection userConnection, Errors errors
			, @ModelAttribute(value=DescriptionController.COMMANDLINES) List<CommandLineWithFigurine> commandLinesWithFigurines)
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
			
		currentUser = user;
		
		Command userCurrentCommand = commandDAO.getCommandById(currentUser.getIdUser());
		
		ArrayList<CommandLine> userCurrentCommandLines = commandLineDAO.getAllCommandLinesForCurrentUser(userCurrentCommand.getIdCommand());

		//ICI il faut prendre les figurines déjà entré dans le panier et les rajouter à celles déjà existantes
		
		//ArrayList<Figurine> userCurrentFigurine = figurineService.getFigurineByCommandLine(userCurrentCommandLines);
		
		ArrayList<Integer> figurineFks = new ArrayList<Integer>();		
		
		for(CommandLineWithFigurine commandLineWithFigurine : commandLinesWithFigurines)
		{
			figurineFks.add(commandLineWithFigurine.getFigurine().getIdFigurine());
		}
		
		for(int i = 0; i < commandLinesWithFigurines.size(); i++)
		{
			CommandLine newCommandLine = new CommandLine();
			newCommandLine = commandLinesWithFigurines.get(i).getCommandLine();
			newCommandLine.setCommand(userCurrentCommand.getIdCommand());
			commandLineDAO.save(commandLinesWithFigurines.get(i).getCommandLine());
		}
		
		for(CommandLine commandLineFigurine : userCurrentCommandLines)
		{
			Figurine figurineCommand = figurineService.getFigurineById(commandLineFigurine.getFigurine());
					
			if(!figurineFks.contains(commandLineFigurine.getFigurine()))
			{
				commandLinesWithFigurines.add(new CommandLineWithFigurine(commandLineFigurine, figurineCommand));
				commandLineDAO.save(commandLineFigurine);
			}
			else
			{
				//Rajout du nombre en plus si existe déjà
				CommandLine rightCommandLine;
				int size = commandLinesWithFigurines.size();
				int i = 0;
				while(i < size && commandLinesWithFigurines.get(i).getFigurine().getIdFigurine() != figurineCommand.getIdFigurine())
				{
					i++;
				}
				
				rightCommandLine = commandLinesWithFigurines.get(i).getCommandLine();
				rightCommandLine.setNbFigurine(rightCommandLine.getNbFigurine() + commandLineFigurine.getNbFigurine());
			}
			
		}	
		
		
		model.addAttribute("CURRENTUSER",currentUser);
		
		userConnection.setConnected("ok");
		return "redirect:/welcome";
	}
}
