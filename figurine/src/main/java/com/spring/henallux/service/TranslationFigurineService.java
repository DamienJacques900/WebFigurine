package com.spring.henallux.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.dao.TranslationFigurineDAO;
import com.spring.henallux.dataAccess.entity.TranslationFigurineEntity;
import com.spring.henallux.model.TranslationFigurine;

@Service
public class TranslationFigurineService 
{
	@Autowired
	private TranslationFigurineDAO translationFigurineDAO;

	public TranslationFigurine getTransalationFigurineById(Integer figurineId, Integer languageId)
	{
		TranslationFigurine figurineWanted = new TranslationFigurine();
		ArrayList<TranslationFigurine> translationFigurines = translationFigurineDAO.getAllTranslationFigurines();
		
		for(int i=0;i<translationFigurines.size();i++)
		{	
			if(translationFigurines.get(i).getLanguage() == languageId && translationFigurines.get(i).getFigurine() == figurineId)
			{
				figurineWanted = translationFigurines.get(i);
			}			
		}
		
		return figurineWanted;
	}
	
	
	public TranslationFigurine getTransalationFigurineByCategory(Integer categoryId)
	{
		TranslationFigurine figurineWanted = new TranslationFigurine();
		ArrayList<TranslationFigurine> translationFigurines = translationFigurineDAO.getAllTranslationFigurines();
		
		for(int i=0;i<translationFigurines.size();i++)
		{	
			if(translationFigurines.get(i).getFigurine() == categoryId)
			{
				figurineWanted = translationFigurines.get(i);
			}			
		}
		
		return figurineWanted;
	}
	
	public ArrayList<TranslationFigurine> getAllTranslationFigurinesByLanguage(Integer language)
	{
		ArrayList<TranslationFigurine> translationFigurines = translationFigurineDAO.getAllTranslationFigurines();
		ArrayList<TranslationFigurine> translationFigurinSearch = new ArrayList<TranslationFigurine>();
		for(int i=0;i<translationFigurines.size();i++)
		{
			if(translationFigurines.get(i).getLanguage() == language)
			{
				translationFigurinSearch.add(translationFigurines.get(i));
			}
		}
		return translationFigurinSearch;
	}
	
	public ArrayList<TranslationFigurine> getTransalationFigurineByIdCatAndLanguage(Integer categoryId, Integer language)
	{
		ArrayList<TranslationFigurine> translationFigurines = translationFigurineDAO.getAllTranslationFigurines();
		ArrayList<TranslationFigurine> translationFigurinSearch = new ArrayList<TranslationFigurine>();
		for(int i=0;i<translationFigurines.size();i++)
		{
			if(translationFigurines.get(i).getLanguage() == language && translationFigurines.get(i).getCategory() == categoryId)
			{
				translationFigurinSearch.add(translationFigurines.get(i));
			}
		}
		return translationFigurinSearch;
	}
	
	public ArrayList<TranslationFigurine> getFigurinesByNameAndLanguage(String nameFigurine, Integer language)
	{
		ArrayList<TranslationFigurine> translationFigurines = translationFigurineDAO.getAllTranslationFigurines();
		ArrayList<TranslationFigurine> figurinesSearch = new ArrayList<TranslationFigurine>();
		
		for(int i=0;i<translationFigurines.size();i++)
		{
			if(translationFigurines.get(i).getLanguage() == language && translationFigurines.get(i).getName().toLowerCase().contains(nameFigurine))
			{				
				figurinesSearch.add(translationFigurines.get(i));
			}
		}

		return figurinesSearch;	
	}
}
