package com.spring.henallux.dataAccess.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="translationcategory")
public class TranslationCategoryEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idtranslationcateogry")
	private int idTranslationCategory;
	
	@NotNull
	@Size(min=5, max=30)
	@Column(name="name")
	private String name;
	
	@NotNull
	@Size(min=5, max=30)
	@Column(name="language")
	private int language;
	
	@NotNull
	@Size(min=5, max=30)
	@Column(name="category")
	private int category;

	public int getIdTranslationCategory() 
	{
		return idTranslationCategory;
	}

	public void setIdTranslationCategory(int idTranslationCategory) 
	{
		this.idTranslationCategory = idTranslationCategory;
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

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
}

