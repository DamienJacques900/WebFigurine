package com.spring.henallux.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.dao.TranslationCategoryDAO;
import com.spring.henallux.dataAccess.entity.TranslationCategoryEntity;
import com.spring.henallux.model.TranslationCategory;

@Service
public class TranslationCategoryService 
{
	@Autowired
	private TranslationCategoryDAO translationCategoryDAO;
	
	public ArrayList<TranslationCategory> getTransalationCategoryById(Integer languageId)
	{
		ArrayList<TranslationCategory> translationCategories = translationCategoryDAO.getAllTranslationCategories();
		
		ArrayList<TranslationCategory> translationCategoriesSearch = new ArrayList<TranslationCategory>();
		
		for(int i=0;i<translationCategories.size();i++)
		{	
			if(translationCategories.get(i).getLanguage() == languageId)
			{
				translationCategoriesSearch.add(translationCategories.get(i));
			}			
		}
		
		return translationCategoriesSearch;
	}
}
