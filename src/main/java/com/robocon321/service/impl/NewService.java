package com.robocon321.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.robocon321.converter.NewConverter;
import com.robocon321.dto.NewDTO;
import com.robocon321.entity.CategoryEntity;
import com.robocon321.entity.NewEntity;
import com.robocon321.repository.CategoryRepository;
import com.robocon321.repository.NewRepository;
import com.robocon321.service.INewService;

@Service
public class NewService implements INewService {
	
	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewConverter newConverter;

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> results = new ArrayList<NewDTO>();
		for(NewEntity entity : newRepository.findAll(pageable)) {
			NewDTO model = newConverter.toDTO(entity);
			results.add(model);
		}
		return results;
	}

	@Override
	public int getTotalItem() {
		return (int) newRepository.count();
	}

	@Override
	public NewDTO findById(long id) {
		return newConverter.toDTO(newRepository.findOne(id));
	}

	@Override
	@Transactional
	public NewDTO save(NewDTO dto) {
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(dto.getCategoryCode());
		NewEntity newEntity = new NewEntity();

		if(dto.getId() != null) {
			newEntity = newRepository.findOne(dto.getId());
		}
		
		newEntity.setCategory(categoryEntity);
		newEntity.setTitle(dto.getTitle());
		newEntity.setContent(dto.getContent());
		newEntity.setThumbnail(dto.getThumbnail());
		newEntity.setShortDescription(dto.getShortDescription());
		return newConverter.toDTO(newRepository.save(newEntity));		
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for(long id: ids) {
			newRepository.delete(id);
		}
	}
}
