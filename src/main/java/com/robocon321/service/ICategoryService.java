package com.robocon321.service;

import java.util.List;

import com.robocon321.dto.CategoryDTO;
import com.robocon321.entity.CategoryEntity;

public interface ICategoryService {
	List<CategoryDTO> findAll();
	int getTotal();
	CategoryDTO getById(long id);
	CategoryEntity getCategoryByCode(String code);
}
