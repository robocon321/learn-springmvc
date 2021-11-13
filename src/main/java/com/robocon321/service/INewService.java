package com.robocon321.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.robocon321.dto.NewDTO;
import com.robocon321.model.NewModel;

public interface INewService {
	List<NewDTO> findAll(Pageable pageable);
	int getTotalItem();
	NewDTO findById(long id);
	NewDTO save(NewDTO dto);
	void delete(long []ids);
}
