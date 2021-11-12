package com.robocon321.service;

import java.util.List;

import com.robocon321.dto.CategoryDTO;

public interface ICategoryService {
	List<CategoryDTO> findAll();
	int getTotal();
	CategoryDTO getById(long id);
}
