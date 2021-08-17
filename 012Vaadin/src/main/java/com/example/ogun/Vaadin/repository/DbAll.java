package com.example.ogun.Vaadin.repository;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DB_ALL")
public class DbAll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "FK_DB_ALL_USER", value = ConstraintMode.CONSTRAINT))
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ProgramingLangue_ID", foreignKey = @ForeignKey(name = "FK_DB_ALL_ProgramingLangues", value = ConstraintMode.CONSTRAINT))
	private ProgramingLangue programingLangue;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PL_CATEGORY_ID", foreignKey = @ForeignKey(name = "FK_DB_ALL_PrograminLangueCategory", value = ConstraintMode.CONSTRAINT))
	private PrograminLangueCategory programinLangueCategory;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Problem_ID", foreignKey = @ForeignKey(name = "FK_DB_ALL_Problem", value = ConstraintMode.CONSTRAINT))
	private Problem problem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ProgramingLangue getProgramingLangue() {
		return programingLangue;
	}

	public void setProgramingLangue(ProgramingLangue programingLangue) {
		this.programingLangue = programingLangue;
	}

	public PrograminLangueCategory getPrograminLangueCategory() {
		return programinLangueCategory;
	}

	public void setPrograminLangueCategory(PrograminLangueCategory programinLangueCategory) {
		this.programinLangueCategory = programinLangueCategory;
	}

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	public DbAll() {
		// TODO Auto-generated constructor stub
	}
	public DbAll(Long id) {
		super();
		this.id = id;
	}
	public DbAll(Long id, User user, ProgramingLangue programingLangue, PrograminLangueCategory programinLangueCategory,
			Problem problem) {
		super();
		this.id = id;
		this.user = user;
		this.programingLangue = programingLangue;
		this.programinLangueCategory = programinLangueCategory;
		this.problem = problem;
	}

	@Override
	public String toString() {
		return "DbAll [id=" + id + ", user=" + user + ", programingLangue=" + programingLangue
				+ ", programinLangueCategory=" + programinLangueCategory + ", problem=" + problem + "]";
	}

}
