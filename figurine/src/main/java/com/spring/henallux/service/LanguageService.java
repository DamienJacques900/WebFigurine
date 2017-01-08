package com.spring.henallux.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.dao.FigurineDAO;
import com.spring.henallux.dataAccess.dao.LanguageDAO;
import com.spring.henallux.dataAccess.entity.LanguageEntity;
import com.spring.henallux.model.Language;

@Service
public class LanguageService 
{
	@Autowired
	private LanguageDAO languageDAO;	
	
	public Language getLanguageByName(String name)
	{
		ArrayList<Language> languages = languageDAO.getAllLanguages();
				
		for(int i=0;i<languages.size();i++)
		{
			if(languages.get(i).getName().equals(name))
				return languages.get(i);
		}
		
		return new Language();
	}
}
