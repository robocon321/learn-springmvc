package com.robocon321.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.robocon321.dto.CategoryDTO;
import com.robocon321.dto.NewDTO;
import com.robocon321.service.ICategoryService;
import com.robocon321.service.INewService;

@Controller(value = "newAdmin")
public class NewController {
  @Autowired
  private INewService newService;
  
  @Autowired
  private ICategoryService categoryService;
	
   @RequestMapping(value = "/admin/new/list", method = RequestMethod.GET)
   public ModelAndView show(@RequestParam("page") int page, @RequestParam("limit") int limit,  @RequestParam(value="error", required = false) String error) {
	  NewDTO dto = new NewDTO();
	  int totalItem = newService.getTotalItem();
      ModelAndView mav = new ModelAndView("admin/new/list");
      Pageable pageable = new PageRequest(page - 1, limit);
      dto.setListResult(newService.findAll(pageable));
      dto.setTotalItem(totalItem);
      dto.setTotalPage((int) Math.ceil(totalItem / limit));
      dto.setPage(page);
      dto.setLimit(limit);
      if(error != null) mav.addObject("error", error);
      mav.addObject("model", dto);
      return mav;
   }
   
   @RequestMapping(value = "/admin/new/edit" , method = RequestMethod.GET)
   public ModelAndView edit(@RequestParam(value = "id", required = false) Long id, @RequestParam(value="error", required = false) String error) {
      ModelAndView mav = new ModelAndView("admin/new/edit");
      NewDTO model = new NewDTO();
      if(id != null) {
    	  model = newService.findById(id);
      }
      
      List<CategoryDTO> categoryDTOs = categoryService.findAll();
      Map<String, String> categoryMaps = new HashMap<>();
      for(CategoryDTO categoryDTO: categoryDTOs) {
    	  categoryMaps.put(categoryDTO.getCode(), categoryDTO.getName());
      }
      mav.addObject("categories", categoryMaps);
      mav.addObject("model", model);
      if(error != null) mav.addObject("error", error);
      return mav;
   }

}