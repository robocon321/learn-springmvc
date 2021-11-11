package com.robocon321.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.robocon321.dto.NewDTO;
import com.robocon321.service.INewService;

@Controller(value = "newAdmin")
public class NewController {
  @Autowired
  private INewService newService;
	
   @RequestMapping(value = "/admin/new/list", method = RequestMethod.GET)
   public ModelAndView show(@RequestParam("page") int page, @RequestParam("limit") int limit) {
	  NewDTO dto = new NewDTO();
	  int totalItem = newService.getTotalItem();
      ModelAndView mav = new ModelAndView("admin/new/list");
      Pageable pageable = new PageRequest(page - 1, limit);
      dto.setListResult(newService.findAll(pageable));
      dto.setTotalItem(totalItem);
      dto.setTotalPage((int) Math.ceil(totalItem / limit));
      dto.setPage(page);
      dto.setLimit(limit);
      mav.addObject("model", dto);
      return mav;
   }
   
   @RequestMapping(value = "/admin/new/edit", method = RequestMethod.GET)
   public ModelAndView edit() {
      ModelAndView mav = new ModelAndView("admin/new/edit");
      return mav;
   }

}