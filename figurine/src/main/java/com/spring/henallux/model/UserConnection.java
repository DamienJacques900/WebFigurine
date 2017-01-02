package com.spring.henallux.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserConnection 
{
	@Size(min=5, max=30)
	@Column(name="iduser")
	private String idUser;
	
	@Size(min=4, max=150)
	private String password;
	
	private String connected;
	
	public String getConnected() {
		return connected;
	}

	public void setConnected(String connected) {
		this.connected = connected;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}
