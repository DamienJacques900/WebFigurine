package com.spring.henallux.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Language 
{
	@NotNull
	private int idLanguage;
	
	@NotNull
	@Size(min=5, max=30)
	private String name;
	
	public int getIdLanguage() 
	{
		return idLanguage;
	}
	
	public void setIdLanguage(int idLanguage) 
	{
		this.idLanguage = idLanguage;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
}
