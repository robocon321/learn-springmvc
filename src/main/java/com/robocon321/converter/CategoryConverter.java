package com.robocon321.converter;

import org.springframework.stereotype.Component;

import com.robocon321.dto.CategoryDTO;
import com.robocon321.entity.CategoryEntity;

@Component
public class CategoryConverter {
	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO dto = new CategoryDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCode(entity.getCode());
		return dto;
	}
	
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		entity.setName(dto.getName());
		entity.setCode(dto.getCode());
		return entity;
	}
 }
