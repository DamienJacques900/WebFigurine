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
public class TranslationFigurineDAO 
{
	@Autowired
	private TranslationFigurineRepository translationFigurineRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	@Autowired
	private TranslationFigurineDAO translationFigurineDAO;
	
	//***************************COMMENTAIRE************************************
	//Permet de sauvergarder les données dans la BD
	//**************************************************************************
	public TranslationFigurine save(TranslationFigurine translationFigurine)
	{
		TranslationFigurineEntity translationFigurineEntity = providerConverter.translationFigurineModeltoTranslationFigurineEntity(translationFigurine);
		translationFigurineEntity = translationFigurineRepository.save(translationFigurineEntity);
		return providerConverter.translationFigurineEntitytoTranslationFigurineModel(translationFigurineEntity);
	}
	
	//***************************COMMENTAIRE************************************
	//Permet de récupérer les données dans la BD
	//**************************************************************************
	public ArrayList<TranslationFigurine> getAllTranslationFigurines()
	{
		List <TranslationFigurineEntity> translationFigurineEntities = translationFigurineRepository.findAll();
		ArrayList <TranslationFigurine> translationFigurines = new ArrayList<>();
		for (TranslationFigurineEntity entity : translationFigurineEntities)
		{
			TranslationFigurine translationFigurine = providerConverter.translationFigurineEntitytoTranslationFigurineModel(entity);
			translationFigurines.add(translationFigurine);
		}
		return translationFigurines;
	}
	
	
	public TranslationFigurine getTransalationFigurineById(Integer figurineId, Integer languageId)
	{
		TranslationFigurine figurineWanted = new TranslationFigurine();
		List<TranslationFigurineEntity> translationFigurineEntities = translationFigurineRepository.findAll();
		
		for(TranslationFigurineEntity entity : translationFigurineEntities)
		{	
			if(entity.getLanguage() == languageId && entity.getFigurine() == figurineId)
			{
				figurineWanted = providerConverter.translationFigurineEntitytoTranslationFigurineModel(entity);
			}			
		}
		
		return figurineWanted;
	}
	
	
	public TranslationFigurine getTransalationFigurineByCategory(Integer categoryId)
	{
		TranslationFigurine figurineWanted = new TranslationFigurine();
		List<TranslationFigurineEntity> translationFigurineEntities = translationFigurineRepository.findAll();
		
		for(TranslationFigurineEntity entity : translationFigurineEntities)
		{	
			if(entity.getFigurine() == categoryId)
			{
				figurineWanted = providerConverter.translationFigurineEntitytoTranslationFigurineModel(entity);
			}			
		}
		
		return figurineWanted;
	}
	
	public ArrayList<TranslationFigurine> getAllTranslationFigurinesByLanguage(Integer language)
	{
		List <TranslationFigurineEntity> translationFigurineEntities = translationFigurineRepository.findAll();
		ArrayList <TranslationFigurine> translationFigurines = new ArrayList<>();
		for (TranslationFigurineEntity entity : translationFigurineEntities)
		{
			if(entity.getLanguage() == language)
			{
				TranslationFigurine translationFigurine = providerConverter.translationFigurineEntitytoTranslationFigurineModel(entity);
				translationFigurines.add(translationFigurine);
			}
		}
		return translationFigurines;
	}
	
	public ArrayList<TranslationFigurine> getTransalationFigurineByIdCatAndLanguage(Integer categoryId, Integer language)
	{
		List <TranslationFigurineEntity> translationFigurineEntities = translationFigurineRepository.findAll();
		ArrayList <TranslationFigurine> translationFigurines = new ArrayList<>();
		for (TranslationFigurineEntity entity : translationFigurineEntities)
		{
			if(entity.getLanguage() == language && entity.getCategory() == categoryId)
			{
				TranslationFigurine translationFigurine = providerConverter.translationFigurineEntitytoTranslationFigurineModel(entity);
				translationFigurines.add(translationFigurine);
			}
		}
		return translationFigurines;
	}
	
	public ArrayList<TranslationFigurine> getFigurinesByName(String nameFigurine)
	{
		ArrayList<TranslationFigurine>figurinesSearch = new ArrayList<TranslationFigurine>();
		ArrayList <TranslationFigurine> figurines = translationFigurineDAO.getAllTranslationFigurines();
		
		for(int i=0;i<figurines.size();i++)
		{		
			if(figurines.get(i).getName().contains(nameFigurine))
			{
				figurinesSearch.add(figurines.get(i));
			}	
		}

		return figurinesSearch;
	}
	
}
