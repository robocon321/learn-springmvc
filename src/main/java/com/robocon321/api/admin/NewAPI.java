package com.robocon321.api.admin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.robocon321.dto.NewDTO;

@RestController(value = "adminApi")
public class NewAPI {

	@PostMapping("/api/new")
	public NewDTO insert(@RequestBody NewDTO newDTO) {
		return newDTO;
	}
	
	@PutMapping("/api/new")
	public NewDTO update(@RequestBody NewDTO newDTO) {
		return newDTO;
	}
	
	@DeleteMapping("api/new")
	public void delete(@RequestBody long[] ids) {
		return ;
	}
}
