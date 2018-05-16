package com.test.springmvc.controller;

import com.test.springmvc.bean.User;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class MvcController {
	@GetMapping(value="index")
	
	public ModelAndView index(ModelAndView mv){

		return mv;
	}
	@RequestMapping(value="index2",method = RequestMethod.POST)
	public  ModelAndView index(ModelAndView mv,User user){
		mv.addObject("user",user);
		mv.setViewName("test");
	    return mv ;

    }

}

