package com.spring.henallux.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TranslationFigurine 
{
	@NotNull
	private int idTranslationFigurine;
	
	@NotNull
	@Size(min=5, max=30)
	private String name;
	
	@NotNull
	@Size(min=10, max=300)
	private String description;
	
	@NotNull
	private int figurine;
	
	@NotNull
	private int language;
	
	@NotNull
	private int category;
	
	public int getCategory() 
	{
		return category;
	}
	public void setCategory(int category) 
	{
		this.category = category;
	}
	public int getIdTranslationFigurine() 
	{
		return idTranslationFigurine;
	}
	public void setIdTranslationFigurine(int idTranslationFigurine) 
	{
		this.idTranslationFigurine = idTranslationFigurine;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	public int getFigurine() 
	{
		return figurine;
	}
	public void setFigurine(int figurine) 
	{
		this.figurine = figurine;
	}
	public int getLanguage() 
	{
		return language;
	}
	public void setLanguage(int language) 
	{
		this.language = language;
	}
}
