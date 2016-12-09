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
public class CategoryDAO 
{
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	public Category save(Category category)
	{
		CategoryEntity categoryEntity = providerConverter.categoryModeltoCategoryEntity(category);
		categoryEntity = categoryRepository.save(categoryEntity);
		return providerConverter.categoryEntitytoCategoryModel(categoryEntity);
	}
	
	public ArrayList<Category> getAllCategories()
	{
		List <CategoryEntity> categoryEntities = categoryRepository.findAll();
		ArrayList <Category> categories = new ArrayList<>();
		for (CategoryEntity entity : categoryEntities)
		{
			Category category = providerConverter.categoryEntitytoCategoryModel(entity);
			categories.add(category);
		}
		return categories;
	}
}

