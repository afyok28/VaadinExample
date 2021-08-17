package com.example.ogun.Vaadin.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PL_CATEGORY")
public class PrograminLangueCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME", length = 35)
	private String name;

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

	public PrograminLangueCategory() {
		// TODO Auto-generated constructor stub
	}

	public PrograminLangueCategory(String name, Long plId) {
		super();
		this.name = name;
	}

	public PrograminLangueCategory(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "PrograminLangueCategory [id=" + id + ", name=" + name + "]";
	}

}
