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
public class FigurineDAO 
{
	@Autowired
	private FigurineRepository figurineRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	public Figurine save(Figurine figurine)
	{
		FigurineEntity figurineEntity = providerConverter.figurineModeltoFigurineEntity(figurine);
		figurineEntity = figurineRepository.save(figurineEntity);
		return providerConverter.figurineEntitytoFigurineModel(figurineEntity);
	}
	
	public ArrayList<Figurine> getAllFigurines()
	{
		List <FigurineEntity> figurineEntities = figurineRepository.findAll();
		ArrayList <Figurine> figurines = new ArrayList<>();
		for (FigurineEntity entity : figurineEntities)
		{
			Figurine figurine = providerConverter.figurineEntitytoFigurineModel(entity);
			figurines.add(figurine);
		}
		return figurines;
	}
}
