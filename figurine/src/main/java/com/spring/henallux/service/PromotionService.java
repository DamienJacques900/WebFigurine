package com.spring.henallux.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.dao.PromotionDAO;
import com.spring.henallux.model.Promotion;

@Service
public class PromotionService 
{
	@Autowired
	private PromotionDAO promotionDAO;
	
	public ArrayList<Promotion> getPromotionValid()
	{
		Date todayDate = new Date();
		Date endDate = new Date();
		Date beginDate = new Date();
		ArrayList<Promotion> promotionAll = promotionDAO.getAllPromotions();
		ArrayList<Promotion> currentPromotion = new ArrayList<Promotion>();
		for(int i = 0; i < promotionAll.size(); i++)
		{
			endDate = promotionAll.get(i).getDateEnd();
			beginDate = promotionAll.get(i).getDateBegin();
			if(todayDate.before(endDate) && todayDate.after(beginDate))
			{ 
				currentPromotion.add(promotionAll.get(i));
			}
		}
		
		return currentPromotion;
	}

}
