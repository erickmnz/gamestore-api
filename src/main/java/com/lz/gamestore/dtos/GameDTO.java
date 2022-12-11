package com.lz.gamestore.dtos;

import java.io.Serializable;

import com.lz.gamestore.domains.Category;
import com.lz.gamestore.domains.Game;

public class GameDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private String description;
	private String producer;
	
	private Category category;

	public GameDTO() {}

	public GameDTO(Game game) {
		super();
		this.id = game.getId();
		this.title = game.getTitle();
		this.description = game.getDescription();
		this.producer = game.getProducer();
		this.category = game.getCategory();
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


}
