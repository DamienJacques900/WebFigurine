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
public class TranslationCategoryDAO 
{
	@Autowired
	private TranslationCategoryRepository translationCategoryRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	//***************************COMMENTAIRE************************************
	//Permet de sauvergarder les données dans la BD
	//**************************************************************************
	public TranslationCategory save(TranslationCategory translationCategory)
	{
		TranslationCategoryEntity translationCategoryEntity = providerConverter.translationCategoryModeltoTranslationCategoryEntity(translationCategory);
		translationCategoryEntity = translationCategoryRepository.save(translationCategoryEntity);
		return providerConverter.translationCategoryEntitytoTranslationCategoryModel(translationCategoryEntity);
	}
	
	//***************************COMMENTAIRE************************************
	//Permet de récupérer les données dans la BD
	//**************************************************************************
	public ArrayList<TranslationCategory> getAllTranslationCategories()
	{
		List <TranslationCategoryEntity> translationCategoryEntities = translationCategoryRepository.findAll();
		ArrayList <TranslationCategory> translationCategories = new ArrayList<>();
		for (TranslationCategoryEntity entity : translationCategoryEntities)
		{
			TranslationCategory translationCategory = providerConverter.translationCategoryEntitytoTranslationCategoryModel(entity);
			translationCategories.add(translationCategory);
		}
		return translationCategories;
	}
	
	
	
	public ArrayList<TranslationCategory> getTransalationCategoryById(Integer languageId)
	{
		List<TranslationCategoryEntity> translationCategoryEntities = translationCategoryRepository.findAll();
		
		ArrayList<TranslationCategory> translationCategory = new ArrayList<TranslationCategory>();
		
		for(TranslationCategoryEntity entity : translationCategoryEntities)
		{	
			if(entity.getLanguage() == languageId)
			{
				translationCategory.add(providerConverter.translationCategoryEntitytoTranslationCategoryModel(entity));
			}			
		}
		
		return translationCategory;
	}
}
