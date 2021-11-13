package com.robocon321.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.robocon321.dto.NewDTO;
import com.robocon321.service.INewService;
import com.robocon321.service.impl.NewService;

@RestController(value = "adminApi")
public class NewAPI {

	@Autowired
	private INewService newService;
	
	@PostMapping("/api/new")
	public NewDTO insert(@RequestBody NewDTO newDTO) {
		return newService.save(newDTO);
	}
	
	@PutMapping("/api/new")
	public NewDTO update(@RequestBody NewDTO newDTO) {
		return newService.save(newDTO);			
	}
	
	@DeleteMapping("api/new")
	public void delete(@RequestBody long[] ids) {
		newService.delete(ids);
	}
}
