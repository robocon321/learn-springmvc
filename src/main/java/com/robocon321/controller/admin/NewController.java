package com.robocon321.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.robocon321.model.NewModel;
import com.robocon321.service.INewService;

@Controller(value = "newAdmin")
public class NewController {
  @Autowired
  private INewService newService;
	
   @RequestMapping(value = "/admin/new/list", method = RequestMethod.GET)
   public ModelAndView show(@ModelAttribute("model") NewModel model) {
      ModelAndView mav = new ModelAndView("admin/new/list");
      model.setListResult(newService.findAll());
      mav.addObject("model", model);
      return mav;
   }
   
   @RequestMapping(value = "/admin/new/edit", method = RequestMethod.GET)
   public ModelAndView edit() {
      ModelAndView mav = new ModelAndView("admin/new/edit");
      return mav;
   }

}