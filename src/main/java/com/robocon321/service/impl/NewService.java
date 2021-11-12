package com.robocon321.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ResultCheckStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.robocon321.converter.NewConverter;
import com.robocon321.dao.INewDAO;
import com.robocon321.dto.NewDTO;
import com.robocon321.entity.NewEntity;
import com.robocon321.model.NewModel;
import com.robocon321.repository.NewRepository;
import com.robocon321.service.INewService;

@Service
public class NewService implements INewService {
	
	@Autowired
	private NewRepository newRepository;
	
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
}
