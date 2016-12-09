package com.spring.henallux.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TranslationCategory 
{
	private int idTranslationCategory;
	
	@NotNull
	@Size(min=5, max=30)
	private String name;
	
	@NotNull
	@Size(min=5, max=30)
	private int language;
	
	@NotNull
	@Size(min=5, max=30)
	private int category;
	
	public int getIdTranslationCategory() 
	{
		return idTranslationCategory;
	}
	public void setIdTranslationCategory(int idTranslationCategory) 
	{
		this.idTranslationCategory = idTranslationCategory;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getLanguage() 
	{
		return language;
	}
	public void setLanguage(int language) 
	{
		this.language = language;
	}
	public int getCategory() 
	{
		return category;
	}
	public void setCategory(int category) 
	{
		this.category = category;
	}
}
