package com.spring.henallux.dataAccess.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring.henallux.dataAccess.entity.*;
import com.spring.henallux.dataAccess.repository.*;

import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.*;

@Service
@Transactional
public class PromotionDAO 
{
	@Autowired
	private PromotionRepository promotionRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	//***************************COMMENTAIRE************************************
	//Permet de sauvergarder les données dans la BD
	//**************************************************************************
	public Promotion save(Promotion promotion)
	{
		PromotionEntity promotionEntity = providerConverter.promotionModeltoPromotionEntity(promotion);
		promotionEntity = promotionRepository.save(promotionEntity);
		return providerConverter.promotionEntitytoPromotionModel(promotionEntity);
	}
	
	//***************************COMMENTAIRE************************************
	//Permet de récupérer les données dans la BD
	//**************************************************************************
	public ArrayList<Promotion> getAllPromotions()
	{
		List <PromotionEntity> promotionEntities = promotionRepository.findAll();
		ArrayList <Promotion> promotions = new ArrayList<>();
		for (PromotionEntity entity : promotionEntities)
		{
			Promotion promotion = providerConverter.promotionEntitytoPromotionModel(entity);
			promotions.add(promotion);
		}
		return promotions;
	}
}
