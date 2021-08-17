package com.example.ogun.Vaadin.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROBLEM")
public class Problem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private Long id;

	@Column(name = "TITLE", length = 50, nullable = false)
	private String title;

	@Column(name = "EXPLANATION", length = 500, nullable = false)
	private String explanation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public Problem() {
	}

	public Problem(String title, String explanation) {
		super();
		this.title = title;
		this.explanation = explanation;
	}

	public Problem(Long id, String title, String explanation) {
		super();
		this.id = id;
		this.title = title;
		this.explanation = explanation;
	}

	@Override
	public String toString() {
		return "Problem [id=" + id + ", title=" + title + ", explanation=" + explanation + "]";
	}

}
