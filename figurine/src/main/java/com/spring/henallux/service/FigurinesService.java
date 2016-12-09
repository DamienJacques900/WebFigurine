package com.spring.henallux.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.dao.*;
import com.spring.henallux.model.*;

@Service
public class FigurinesService 
{
	private ArrayList<Figurine> figurinesMovie;
	private ArrayList<Figurine> figurinesJapaneseAnimation;
	private ArrayList<Figurine> figurinesVideoGame;
	
	@Autowired
	private FigurineDAO figurineDAO;
	
	public FigurinesService()
	{
		//ArrayList <Figurine> figurines = figurineDAO.getAllFigurines();
	}

	public ArrayList<Figurine> getFigurinesMovie() 
	{
		//***************************COMMENTAIRE************************************
		//On fait deux arrayList pour récupérer les valeurs de la BD et récuperer
		//uniquement les figurines de films
		//**************************************************************************
		figurinesMovie = new ArrayList<Figurine>();
		ArrayList <Figurine> figurines = figurineDAO.getAllFigurines();
		
		for(int i=0;i<figurines.size();i++)
		{		
			if(figurines.get(i).getCategory()==1)
			{
				figurinesMovie.add(figurines.get(i));
			}	
		}

		return figurinesMovie;
	}
	
	public ArrayList<Figurine> getFigurinesJapaneseAnimation() 
	{
		//***************************COMMENTAIRE************************************
		//On fait deux arrayList pour récupérer les valeurs de la BD et récuperer
		//uniquement les figurines d'animations japonaises
		//**************************************************************************
		figurinesJapaneseAnimation = new ArrayList<Figurine>();
		ArrayList <Figurine> figurines = figurineDAO.getAllFigurines();
		
		for(int i=0;i<figurines.size();i++)
		{					
			if(figurines.get(i).getCategory()==2)
			{
				figurinesJapaneseAnimation.add(figurines.get(i));
			}						
		}
		
		return figurinesJapaneseAnimation;
	}
	
	public ArrayList<Figurine> getFigurinesVideoGame() 
	{
		//***************************COMMENTAIRE************************************
		//On fait deux arrayList pour récupérer les valeurs de la BD et récuperer
		//uniquement les figurines de jeux vidéo
		//**************************************************************************
		figurinesVideoGame = new ArrayList<Figurine>();
		ArrayList <Figurine> figurines = figurineDAO.getAllFigurines();
		
		for(int i=0;i<figurines.size();i++)
		{		
			if(figurines.get(i).getCategory()==3)
			{
				figurinesVideoGame.add(figurines.get(i));
			}						
		}
		return figurinesVideoGame;
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
