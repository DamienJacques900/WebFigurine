package com.spring.henallux.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.henallux.dataAccess.dao.CategoryDAO;
import com.spring.henallux.dataAccess.dao.FigurineDAO;
import com.spring.henallux.model.Category;
import com.spring.henallux.model.Figurine;

public class CategoryService 
{

	private ArrayList<Category> category;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	public CategoryService()
	{
		
	}
	
}
