package com.spring.henallux.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.dao.*;
import com.spring.henallux.model.*;

@Service
public class FigurinesService 
{
	private ArrayList<Figurine> figurinesSearch;
	private ArrayList<Figurine> figurinesMovie;
	private ArrayList<Figurine> figurinesJapaneseAnimation;
	private ArrayList<Figurine> figurinesVideoGame;
	private ArrayList<Figurine> figurinesCategory;
	
	@Autowired
	private FigurineDAO figurineDAO;
	
	public FigurinesService()
	{
		//ArrayList <Figurine> figurines = figurineDAO.getAllFigurines();
	}

	
	public ArrayList<Figurine> getFigurinesByName(String nameFigurine)
	{
		figurinesSearch = new ArrayList<Figurine>();
		ArrayList <Figurine> figurines = figurineDAO.getAllFigurines();
		
		for(int i=0;i<figurines.size();i++)
		{		
			if(figurines.get(i).getName().contains(nameFigurine))
			{
				figurinesSearch.add(figurines.get(i));
			}	
		}

		return figurinesSearch;
	}
	
	
	
	public Figurine getFigurineById(int idFigurine)
	{
		Figurine figurineDescription = new Figurine();
		ArrayList <Figurine> figurines = figurineDAO.getAllFigurines();
		
		for(int i=0;i<figurines.size();i++)
		{				
			if(figurines.get(i).getIdFigurine()==idFigurine)
			{
				figurineDescription = figurines.get(i);
			}	
		}
		return figurineDescription;
	}
	
	
	public ArrayList<Figurine> getFigurineByCategory(int idCategory)
	{
		figurinesCategory = new ArrayList<Figurine>();
		ArrayList <Figurine> figurines = figurineDAO.getAllFigurines();
		
		for(int i=0;i<figurines.size();i++)
		{		
			if(figurines.get(i).getCategory()==idCategory)
			{
				figurinesCategory.add(figurines.get(i));
			}						
		}
		return figurinesCategory;
	}
	
	public ArrayList<Figurine> getFigurineByCommand(int idFigurine)
	{
		figurinesCategory = new ArrayList<Figurine>();
		ArrayList <Figurine> figurines = figurineDAO.getAllFigurines();
		
		for(int i=0;i<figurines.size();i++)
		{		
			if(figurines.get(i).getIdFigurine() ==idFigurine)
			{
				figurinesCategory.add(figurines.get(i));
			}						
		}
		return figurinesCategory;
	}
	
	public ArrayList<Figurine> getFigurineByCommandLine(ArrayList<CommandLine> commandLine)
	{
		figurinesCategory = new ArrayList<Figurine>();
		ArrayList <Figurine> figurines = figurineDAO.getAllFigurines();
		
		for(int i=0;i<figurines.size();i++)
		{		
			for(int j = 0; j<commandLine.size(); i++)
			{
				if(figurines.get(i).getIdFigurine() == commandLine.get(j).getFigurine())
				{
					figurinesCategory.add(figurines.get(i));
				}
			}							
		}
		return figurinesCategory;
	}
	
	
	

	public void setFigurinesMovie(ArrayList<Figurine> figurines) 
	{
		this.figurinesMovie = figurines;
	}
	
	public void setFigurinesJapaneseAnimation(ArrayList<Figurine> figurines) 
	{
		this.figurinesJapaneseAnimation = figurines;
	}
	
	public void setFigurinesVideoGame(ArrayList<Figurine> figurines) 
	{
		this.figurinesVideoGame = figurines;
	}
	
	
}
