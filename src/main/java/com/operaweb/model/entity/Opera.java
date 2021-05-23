package com.operaweb.model.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Operas")
public class Opera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "operaid")
	private Integer operaId;
	@Column(name = "title")
	private String title;
	@Column(name = "year")
	private Integer year;
	@Column(name = "composer")
	private String composer;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "opera")
	private Set<Comment> comments;

	public Integer getOperaId() {
		return operaId;
	}

	public void setOperaId(Integer operaId) {
		this.operaId = operaId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}
