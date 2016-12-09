package com.spring.henallux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import com.spring.henallux.model.*;

@Controller
@RequestMapping(value="/userCommand")
public class UserCommandController 
{
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model)
	{
		return "integrated:userCommand";
	}
}
