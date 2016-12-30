package com.spring.henallux.dataAccess.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="command")
public class CommandEntity 
{
	@Id
	@Min(1)
	@Max(1000)
	@NotNull
	@Column(name="idcommand")
	private int idCommand;
	
	@NotNull
	@Past
	@Column(name="datecommand")
	private Date dateCommand;
	
	@JoinColumn(name="user", referencedColumnName="iduser")
	@ManyToOne
	private UserEntity userEnt;
	
	@OneToMany(mappedBy="command", fetch = FetchType.LAZY)
	private Collection<CommandLineEntity> commandLines;



	public UserEntity getUserEnt() {
		return userEnt;
	}

	public void setUserEnt(UserEntity userEnt) {
		this.userEnt = userEnt;
	}

	public int getIdCommand() 
	{
		return idCommand;
	}

	public void setIdCommand(int idCommand) 
	{
		this.idCommand = idCommand;
	}

	public Date getDateCommand() 
	{
		return dateCommand;
	}

	public void setDateCommand(Date dateCommand) 
	{
		this.dateCommand = dateCommand;
	}
	
	
}

