package com.spring.henallux.model;

import java.util.ArrayList;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Figurine 
{
	@NotNull
	private int idFigurine;
	
	@NotNull
	@Size(min=5, max=30)
	private String name;
	
	@NotNull
	@Size(min=10, max=300)
	private String description;
	
	@NotNull
	@DecimalMin("1.00")
	private double weight;
	
	@NotNull
	@DecimalMin("1.00")
	private double size;
	
	@NotNull
	@Size(min=5, max=30)
	private String brand;
	
	@NotNull
	private boolean painting;
	
	@NotNull
	@DecimalMin("1.00")
	private double cost;
	
	@NotNull
	private String image;
	
	@NotNull
	private int category;
	
	private int promotion;

	public int getPromotion() 
	{
		return promotion;
	}

	public void setPromotion(int promotion) 
	{
		this.promotion = promotion;
	}

	public String getImage() 
	{
		return image;
	}

	public void setImage(String image) 
	{
		this.image = image;
	}
	
	public int getCategory() 
	{
		return category;
	}

	public void setCategory(int category) 
	{
		this.category = category;
	}

	public Figurine()
	{
		
	}
	
	//GETTERS ================================================================
	public int getIdFigurine()
	{
		return idFigurine;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String getBrand()
	{
		return brand;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public double getSize()
	{
		return size;
	}
	
	public boolean getPainting()
	{
		return painting;
	}
	
	public double getCost()
	{
		return cost;
	}
	
	
	//SETTER ==================================================================
	
	public void setIdFigurine(int id)
	{
		idFigurine = id;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setDescription(String d)
	{
		description = d;
	}
	
	public void setBrand(String b)
	{
		brand = b;
	}
	
	public void setWeight(double w)
	{
		weight = w;
	}
	
	public void setSize(double s)
	{
		size = s;
	}
	
	public void setPainting(boolean p)
	{
		painting = p;
	}
	
	public void setCost(double c)
	{
		cost = c;
	}
}
