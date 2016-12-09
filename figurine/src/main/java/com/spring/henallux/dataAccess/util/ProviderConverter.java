package com.spring.henallux.dataAccess.util;

import org.springframework.stereotype.Component;
import com.spring.henallux.dataAccess.entity.*;
import com.spring.henallux.model.*;

@Component
public class ProviderConverter 
{
	//USER =====================================================
	//***************************COMMENTAIRE************************************
	//Permet de transformer un model en entity
	//**************************************************************************
	public UserEntity userModeltoUserEntity(User user)
	{
		UserEntity userEntity = new UserEntity();
		userEntity.setIdUser(user.getIdUser());
		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());
		userEntity.setEmail(user.getEmail());
		userEntity.setNumTel(user.getNumTel());
		userEntity.setNumFax(user.getNumFax());
		userEntity.setStreet(user.getStreet());
		userEntity.setCity(user.getCity());
		userEntity.setPostalCode(user.getPostalCode());
		userEntity.setCountry(user.getCountry());
		userEntity.setPassword(user.getPassword());
		
		return userEntity;
	}
	
	//***************************COMMENTAIRE************************************
	//Permet de transformer un entity en model
	//**************************************************************************
	public User userEntitytoUserModel(UserEntity userEntity)
	{
		User user = new User();
		user.setIdUser(userEntity.getIdUser());
		user.setFirstName(userEntity.getFirstName());
		user.setLastName(userEntity.getLastName());
		user.setEmail(userEntity.getEmail());
		user.setNumTel(userEntity.getNumTel());
		user.setNumFax(userEntity.getNumFax());
		user.setStreet(userEntity.getStreet());
		user.setCity(userEntity.getCity());
		user.setPostalCode(userEntity.getPostalCode());
		user.setCountry(userEntity.getCountry());
		user.setPassword(userEntity.getPassword());
		
		return user;
	}
	
	//TRANSLATIONFIGURINE =====================================================
	public TranslationFigurineEntity translationFigurineModeltoTranslationFigurineEntity(TranslationFigurine translationFigurine)
	{
		TranslationFigurineEntity translationFigurineEntity = new TranslationFigurineEntity();
		translationFigurineEntity.setIdTranslationFigurine(translationFigurine.getIdTranslationFigurine());
		translationFigurineEntity.setName(translationFigurine.getName());
		translationFigurineEntity.setDescription(translationFigurine.getDescription());
		translationFigurineEntity.setFigurine(translationFigurine.getFigurine());
		translationFigurineEntity.setLanguage(translationFigurine.getLanguage());
		
		return translationFigurineEntity;
	}
	
	public TranslationFigurine translationFigurineEntitytoTranslationFigurineModel(TranslationFigurineEntity translationFigurineEntity)
	{
		TranslationFigurine translationFigurine = new TranslationFigurine();
		translationFigurine.setIdTranslationFigurine(translationFigurineEntity.getIdTranslationFigurine());
		translationFigurine.setName(translationFigurineEntity.getName());
		translationFigurine.setDescription(translationFigurineEntity.getDescription());
		translationFigurine.setFigurine(translationFigurineEntity.getFigurine());
		translationFigurine.setLanguage(translationFigurineEntity.getLanguage());
		
		return translationFigurine;
	}
	
	//TRANSLATIONCATEGORY =====================================================
	public TranslationCategoryEntity translationCategoryModeltoTranslationCategoryEntity(TranslationCategory translationCategory)
	{
		TranslationCategoryEntity translationCategoryEntity = new TranslationCategoryEntity();
		translationCategoryEntity.setIdTranslationCategory(translationCategory.getIdTranslationCategory());
		translationCategoryEntity.setName(translationCategory.getName());
		translationCategoryEntity.setLanguage(translationCategory.getLanguage());
		translationCategoryEntity.setCategory(translationCategory.getCategory());
		
		return translationCategoryEntity;
	}
	
	public TranslationCategory translationCategoryEntitytoTranslationCategoryModel(TranslationCategoryEntity translationCategoryEntity)
	{
		TranslationCategory translationCategory = new TranslationCategory();
		translationCategory.setIdTranslationCategory(translationCategoryEntity.getIdTranslationCategory());
		translationCategory.setName(translationCategoryEntity.getName());
		translationCategory.setLanguage(translationCategoryEntity.getLanguage());
		translationCategory.setCategory(translationCategoryEntity.getCategory());
		
		return translationCategory;
	}
	
	//PROMOTION =================================================================
	public PromotionEntity promotionModeltoPromotionEntity(Promotion promotion)
	{
		PromotionEntity promotionEntity = new PromotionEntity();
		promotionEntity.setIdPromotion(promotion.getIdPromotion());
		promotionEntity.setAmountPourc(promotion.getAmountPourc());
		promotionEntity.setDateBegin(promotion.getDateBegin());
		promotionEntity.setDateEnd(promotion.getDateEnd());
		
		return promotionEntity;
	}
	
	public Promotion promotionEntitytoPromotionModel(PromotionEntity promotionEntity)
	{
		Promotion promotion = new Promotion();
		promotion.setIdPromotion(promotionEntity.getIdPromotion());
		promotion.setAmountPourc(promotionEntity.getAmountPourc());
		promotion.setDateBegin(promotionEntity.getDateBegin());
		promotion.setDateEnd(promotionEntity.getDateEnd());
		
		return promotion;
	}
	
	//LANGUAGE ========================================================================
	public LanguageEntity languageModeltoLanguageEntity(Language language)
	{
		LanguageEntity languageEntity = new LanguageEntity();
		languageEntity.setIdLanguage(language.getIdLanguage());
		languageEntity.setName(language.getName());
		
		return languageEntity;
	}
	
	public Language languageEntitytoLanguageModel(LanguageEntity languageEntity)
	{
		Language language = new Language();
		language.setIdLanguage(languageEntity.getIdLanguage());
		language.setName(languageEntity.getName());
		
		return language;
	}
	
	//FIGURINE ============================================================================
	public FigurineEntity figurineModeltoFigurineEntity(Figurine figurine)
	{
		FigurineEntity figurineEntity = new FigurineEntity();
		figurineEntity.setIdFigurine(figurine.getIdFigurine());
		figurineEntity.setName(figurine.getName());
		figurineEntity.setDescription(figurine.getDescription());
		figurineEntity.setWeight(figurine.getWeight());
		figurineEntity.setSize(figurine.getSize());
		figurineEntity.setBrand(figurine.getBrand());
		figurineEntity.setPainting(figurine.getPainting());
		figurineEntity.setCost(figurine.getCost());
		figurineEntity.setImage(figurine.getImage());
		figurineEntity.setCategory(figurine.getCategory());
		figurineEntity.setPromotion(figurine.getPromotion());
		
		return figurineEntity;
	}
	
	public Figurine figurineEntitytoFigurineModel(FigurineEntity figurineEntity)
	{
		Figurine figurine = new Figurine();
		figurine.setIdFigurine(figurineEntity.getIdFigurine());
		figurine.setName(figurineEntity.getName());
		figurine.setDescription(figurineEntity.getDescription());
		figurine.setWeight(figurineEntity.getWeight());
		figurine.setSize(figurineEntity.getSize());
		figurine.setBrand(figurineEntity.getBrand());
		figurine.setPainting(figurineEntity.isPainting());
		figurine.setCost(figurineEntity.getCost());
		figurine.setImage(figurineEntity.getImage());
		figurine.setCategory(figurineEntity.getCategory());
		figurine.setPromotion(figurineEntity.getPromotion());
		
		return figurine;
	}
	
	//COMMANDLINE =========================================================================
	public CommandLineEntity commandLineModeltoCommandLineEntity(CommandLine commandeLine)
	{
		CommandLineEntity commandLineEntity = new CommandLineEntity();
		commandLineEntity.setIdCommandeLine(commandeLine.getIdCommandeLine());
		commandLineEntity.setNbFigurine(commandeLine.getNbFigurine());
		commandLineEntity.setPrizeCommand(commandeLine.getPrizeCommand());
		commandLineEntity.setFigurine(commandeLine.getFigurine());
		commandLineEntity.setCommand(commandeLine.getCommand());
		
		return commandLineEntity;
	}
	
	public CommandLine commandLineEntitytoCommandLineModel(CommandLineEntity commandLineEntity)
	{
		CommandLine commandeLine = new CommandLine();
		commandeLine.setIdCommandeLine(commandLineEntity.getIdCommandeLine());
		commandeLine.setNbFigurine(commandLineEntity.getNbFigurine());
		commandeLine.setPrizeCommand(commandLineEntity.getPrizeCommand());
		commandeLine.setFigurine(commandLineEntity.getFigurine());
		commandeLine.setCommand(commandLineEntity.getCommand());
		
		return commandeLine;
	}
	
	//COMMAND ==============================================================================
	public CommandEntity commandModeltoCommandEntity(Command command)
	{
		CommandEntity commandEntity = new CommandEntity();
		commandEntity.setIdCommand(command.getIdCommand());
		commandEntity.setDateCommand(command.getDateCommand());
		//commandEntity.setUserEnt(command.getUser());
		
		return commandEntity;
	}
	
	public Command commandEntitytoCommandModel(CommandEntity commandEntity)
	{
		Command command = new Command();
		command.setIdCommand(commandEntity.getIdCommand());
		command.setDateCommand(commandEntity.getDateCommand());
		//IL faut changer pour le setter
		
		return command;
	}
	
	//CATEGORY
	public CategoryEntity categoryModeltoCategoryEntity(Category category)
	{
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setIdCategory(category.getIdCategory());
		categoryEntity.setName(category.getName());
		categoryEntity.setDateOut(category.getDateOut());
		categoryEntity.setProducer(category.getProducer());
		
		return categoryEntity;
	}
	
	public Category categoryEntitytoCategoryModel(CategoryEntity categoryEntity)
	{
		Category category = new Category();
		category.setIdCategory(categoryEntity.getIdCategory());
		category.setName(categoryEntity.getName());
		category.setDateOut(categoryEntity.getDateOut());
		category.setProducer(categoryEntity.getProducer());
		
		return category;
	}
	
}
