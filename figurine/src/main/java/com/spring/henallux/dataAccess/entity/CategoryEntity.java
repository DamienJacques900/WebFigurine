package com.spring.henallux.dataAccess.entity;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="category")
public class CategoryEntity 
{
	@Id
	@Min(0)
	@Max(1000)
	@NotNull
	@Column(name="idcategory")
	private int idCategory;
	
	@Column(name="name")
	@NotNull
	@Size(min=5, max=30)
	private String name;	
	
	@Column(name="dateout")
	@NotNull
	@Past
	private Date dateOut;
	
	@Column(name="producer")
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

