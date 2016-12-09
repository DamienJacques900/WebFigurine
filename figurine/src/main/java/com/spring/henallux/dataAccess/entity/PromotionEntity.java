package com.spring.henallux.dataAccess.entity;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="promotion")
public class PromotionEntity 
{
	@Id
	@NotNull
	@Min(1)
	@Max(1000)
	@Column(name="idpromotion")
	private int idPromotion;
	
	@NotNull
	@DecimalMin("0.00")
	@DecimalMax("100.00")
	@Column(name="amountpourc")
	private double amountPourc;
	
	@NotNull
	@Past
	@Column(name="datebegin")
	private Date dateBegin;
	
	@NotNull
	@Future
	@Column(name="dateend")
	private Date dateEnd;

	public int getIdPromotion() 
	{
		return idPromotion;
	}

	public void setIdPromotion(int idPromotion) 
	{
		this.idPromotion = idPromotion;
	}

	public double getAmountPourc() 
	{
		return amountPourc;
	}

	public void setAmountPourc(double amountPourc) 
	{
		this.amountPourc = amountPourc;
	}

	public Date getDateBegin() 
	{
		return dateBegin;
	}

	public void setDateBegin(Date dateBegin) 
	{
		this.dateBegin = dateBegin;
	}

	public Date getDateEnd() 
	{
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) 
	{
		this.dateEnd = dateEnd;
	}	
}

