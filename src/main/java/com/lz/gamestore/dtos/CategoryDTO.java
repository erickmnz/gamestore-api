package com.lz.gamestore.dtos;

import java.io.Serializable;

import com.lz.gamestore.domains.Category;

public class CategoryDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	
	public CategoryDTO() {
		
	}

	public CategoryDTO(Category category) {
		super();
		this.id = category.getId();
		this.name = category.getName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	



}
