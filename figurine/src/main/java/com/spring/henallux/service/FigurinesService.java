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
	
	@Autowired
	private FigurineDAO figurineDAO;
	
	public FigurinesService()
	{
		//ArrayList <Figurine> figurines = figurineDAO.getAllFigurines();
	}

	public ArrayList<Figurine> getFigurinesByMoney(double moneyMin, double moneyMax)
	{
		figurinesSearch = new ArrayList<Figurine>();
		ArrayList <Figurine> figurines = figurineDAO.getAllFigurines();
		
		for(int i=0;i<figurines.size();i++)
		{		
			if(figurines.get(i).getCost() >= moneyMin && figurines.get(i).getCost() <= moneyMax)
			{
				figurinesSearch.add(figurines.get(i));
			}	
		}

		return figurinesSearch;
	}
	
	public ArrayList<Figurine> getFigurinesByHeight(double heightMin, double heightMax)
	{
		figurinesSearch = new ArrayList<Figurine>();
		ArrayList <Figurine> figurines = figurineDAO.getAllFigurines();
		
		for(int i=0;i<figurines.size();i++)
		{		
			if(figurines.get(i).getSize() >= heightMin && figurines.get(i).getSize() <= heightMax)
			{
				figurinesSearch.add(figurines.get(i));
			}	
		}

		return figurinesSearch;
	}
	
	public ArrayList<Figurine> getFigurinesByWeight(double weightMin, double weightMax)
	{
		figurinesSearch = new ArrayList<Figurine>();
		ArrayList <Figurine> figurines = figurineDAO.getAllFigurines();
		
		for(int i=0;i<figurines.size();i++)
		{		
			if(figurines.get(i).getWeight() >= weightMin && figurines.get(i).getWeight() <= weightMax)
			{
				figurinesSearch.add(figurines.get(i));
			}	
		}

		return figurinesSearch;
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
