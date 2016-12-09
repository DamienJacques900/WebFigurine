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
}
