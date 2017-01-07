package com.spring.henallux.dataAccess.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="figurine")
public class FigurineEntity 
{
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idfigurine")
	private int idFigurine;
	
	@NotNull
	@Size(min=5, max=30)
	@Column(name="name")
	private String name;
	
	@NotNull
	@Size(min=10, max=300)
	@Column(name="description")
	private String description;
	
	@NotNull
	@DecimalMin("1.00")
	@Column(name="size")
	private double size;
	
	@NotNull
	@DecimalMin("1.00")
	@Column(name="weight")
	private double weight;
	
	@NotNull
	@Size(min=5, max=30)
	@Column(name="brand")
	private String brand;
	
	@NotNull
	@Column(name="painting")
	private boolean painting;
	
	@NotNull
	@DecimalMin("1.00")
	@Column(name="cost")
	private double cost;
	
	@NotNull
	@Column(name="image")
	private String image;
	
	@Column(name="category")
	@NotNull
	private int category;
	
	@Column(name="promotion")
	private int promotion;

	public int getPromotion() 
	{
		return promotion;
	}

	public void setPromotion(int promotion) 
	{
		this.promotion = promotion;
	}

	public int getIdFigurine() 
	{
		return idFigurine;
	}

	public void setIdFigurine(int idFigurine) 
	{
		this.idFigurine = idFigurine;
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

	public double getSize() 
	{
		return size;
	}

	public void setSize(double size) 
	{
		this.size = size;
	}

	public double getWeight() 
	{
		return weight;
	}

	public void setWeight(double weight) 
	{
		this.weight = weight;
	}

	public String getBrand() 
	{
		return brand;
	}

	public void setBrand(String brand) 
	{
		this.brand = brand;
	}

	public boolean isPainting() 
	{
		return painting;
	}

	public void setPainting(boolean painting) 
	{
		this.painting = painting;
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

	public double getCost() 
	{
		return cost;
	}

	public void setCost(double cost) 
	{
		this.cost = cost;
	}
}

