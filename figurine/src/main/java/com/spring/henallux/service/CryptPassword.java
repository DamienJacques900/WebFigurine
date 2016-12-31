package com.spring.henallux.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptPassword 
{
	public String cryptInMD5(String password)
	{
		String passwordHashed = null;
		try
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            passwordHashed = sb.toString();
		}
		catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
		return passwordHashed;
	}
}
