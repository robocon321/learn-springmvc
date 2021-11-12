package com.robocon321.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robocon321.converter.CategoryConverter;
import com.robocon321.dto.CategoryDTO;
import com.robocon321.entity.CategoryEntity;
import com.robocon321.repository.CategoryRepository;
import com.robocon321.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> results = new ArrayList<CategoryDTO>();
		for(CategoryEntity entity: categoryRepository.findAll()) {
			results.add(categoryConverter.toDTO(entity));
		}
		return results;
	}

	@Override
	public int getTotal() {
		return (int) categoryRepository.count();
	}

	@Override
	public CategoryDTO getById(long id) {
		return categoryConverter.toDTO(categoryRepository.findOne(id));
	}

}
