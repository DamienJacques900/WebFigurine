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
public class UserDAO 
{
	@Autowired
	private ProviderConverter providerConverter;
	
	@Autowired
	private UserRepository userRepository;
	
	public ArrayList<User> getUsers()
	{
		List<UserEntity> userEntities = userRepository.findAll();
		ArrayList <User> users = new ArrayList<>();
		for (UserEntity entity : userEntities)
		{
			User user = providerConverter.userEntitytoUserModel(entity);
			users.add(user);
		}
		return users;
	}
	
	public User save(User user)
	{
		UserEntity userEntity = providerConverter.userModeltoUserEntity(user);
		userEntity = userRepository.save(userEntity);
		return providerConverter.userEntitytoUserModel(userEntity);
	}

}
