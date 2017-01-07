package com.spring.henallux.model;

import java.util.Date;
import javax.validation.constraints.*;

public class Category 
{
	@NotNull
	private int idCategory;
	
	@NotNull
	@Size(min=5, max=30)
	private String name;
	
	@NotNull
	@Past
	private Date dateOut;
	
	@NotNull
	@Size(min=5, max=30)
	private String producer;
	
	public int getIdCategory() 
	{
		return idCategory;
	}
	
	public void setIdCategory(int idCategory) 
	{
		this.idCategory = idCategory;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public Date getDateOut() 
	{
		return dateOut;
	}
	
	public void setDateOut(Date dateOut) 
	{
		this.dateOut = dateOut;
	}
	
	public String getProducer() 
	{
		return producer;
	}
	
	public void setProducer(String producer) 
	{
		this.producer = producer;
	}
	
}
