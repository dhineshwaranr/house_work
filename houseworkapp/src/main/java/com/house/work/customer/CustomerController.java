package com.house.work.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.house.work.entity.User;
import com.house.work.services.UserServices;

@Controller("customerController")
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	private UserServices userService;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public ModelAndView userhome(){
	
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		System.out.println("user"+auth.getAuthorities());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("customer/home");
		return modelAndView;
	}
	
}
