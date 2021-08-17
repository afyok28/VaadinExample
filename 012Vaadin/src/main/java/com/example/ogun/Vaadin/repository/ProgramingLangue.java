package com.example.ogun.Vaadin.repository;

import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "PROGRAMING_LANGUE")
public class ProgramingLangue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME", length = 35)
	private String name;

	@Lob
	@Column(name = "IMAGE")
	private byte[] image;
	
	
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public ProgramingLangue() {
	}
	public ProgramingLangue(Long id) {
		super();
		this.id = id;
	}
	public ProgramingLangue(String name, byte[] image) {
		super();
		this.name = name;
		this.image = image;
	}
	public ProgramingLangue(Long id, String name, byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
	}

	@Override
	public String toString() {
		return "ProgramingLangue [id=" + id + ", name=" + name + ", image=" + Arrays.toString(image) + "]";
	}

}
