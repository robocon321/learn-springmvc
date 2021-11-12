package com.robocon321.converter;

import org.springframework.stereotype.Component;

import com.robocon321.dto.NewDTO;
import com.robocon321.entity.NewEntity;

@Component
public class NewConverter {
	public NewDTO toDTO(NewEntity entity) {
		NewDTO dto = new NewDTO();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setShortDescription(entity.getShortDescription());
		dto.setContent(entity.getContent());
		dto.setThumbnail(entity.getThumbnail());
		dto.setCategoryCode(entity.getCategory().getCode());
		return dto;
	}
	
	public NewEntity toEntity(NewDTO dto) {
		NewEntity entity = new NewEntity();
		entity.setTitle(dto.getTitle());
		entity.setShortDescription(dto.getShortDescription());
		entity.setContent(dto.getContent());
		entity.setThumbnail(dto.getThumbnail());
		return entity;
	}
}
