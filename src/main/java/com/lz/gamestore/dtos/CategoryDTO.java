package com.lz.gamestore.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.lz.gamestore.domains.Category;

import jakarta.validation.constraints.NotEmpty;

public class CategoryDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotEmpty
	@Length(min=3,max=10)
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
