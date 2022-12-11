package com.lz.gamestore.domains;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "tb_game")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message="Empty title field")
	@Length(min=3,max=50, message="Title must be between 3 and 50 characters")
	private String title;
	@NotEmpty(message="Empty description field")
	@Length(min=4,max=2000, message="Description must be between 10 and 2000 characters")
	private String description;
	@NotEmpty(message="Empty producer field")
	@Length(min=3,max=100, message="Producer name must be between 3 and 50 characters")
	private String producer;
	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnore
	private Category category;

	public Game() {
	}

	public Game(Integer id, String title, String description, String producer, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.producer = producer;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return id == other.id;
	}

}
