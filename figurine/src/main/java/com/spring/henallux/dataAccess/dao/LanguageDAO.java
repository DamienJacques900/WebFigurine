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
public class LanguageDAO 
{
	@Autowired
	private LanguageRepository languageRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	public Language save(Language language)
	{
		LanguageEntity languageEntity = providerConverter.languageModeltoLanguageEntity(language);
		languageEntity = languageRepository.save(languageEntity);
		return providerConverter.languageEntitytoLanguageModel(languageEntity);
	}
	
	public ArrayList<Language> getAllLanguages()
	{
		List <LanguageEntity> languageEntities = languageRepository.findAll();
		ArrayList <Language> languages = new ArrayList<>();
		for (LanguageEntity entity : languageEntities)
		{
			Language language = providerConverter.languageEntitytoLanguageModel(entity);
			languages.add(language);
		}
		return languages;
	}
}
