package com.spring.henallux.model;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class Promotion 
{
	@NotNull
	private int idPromotion;
	
	@NotNull
	@DecimalMin("0.00")
	private double amountPourc;
	
	@NotNull
	private Date dateBegin;
	
	@NotNull
	private Date dateEnd;
	
	public Promotion()
	{
		
	}
	
	//GETTERS =====================================================
	public int getIdPromotion()
	{
		return idPromotion;
	}
	
	public double getAmountPourc()
	{
		return amountPourc;
	}
	
	public Date getDateBegin()
	{
		return dateBegin;
	}
	
	public Date getDateEnd()
	{
		return dateEnd;
	}
	
	//SETTERS =====================================================
	public void setIdPromotion(int id)
	{
		idPromotion = id;
	}
	
	public void setAmountPourc(double a)
	{
		amountPourc = a;
	}
	
	public void setDateBegin(Date db)
	{
		dateBegin = db;
	}
	
	public void setDateEnd(Date de)
	{
		dateEnd = de;
	}
}
