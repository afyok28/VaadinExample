package com.example.ogun.Vaadin.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private Long id;

	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "SURNAME", length = 50)
	private String surName;

	@Column(name = "NICK", length = 20,unique = true)
	private String nick;

	@Column(name = "PASSWORD", length = 32)
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(Long id, String name, String surName, String nick, String password) {
		super();
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.nick = nick;
		this.password = password;
	}

	public User(String name, String surName, String nick, String password) {
		super();
		this.name = name;
		this.surName = surName;
		this.nick = nick;
		this.password = password;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surName=" + surName + ", nick=" + nick + ", password="
				+ password + "]";
	}

}
