package com.house.work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/admin")
@Controller
public class DashboardController {

	@RequestMapping(value="")
	public String dashboard() {
		return "admin/dashboard";
	}
	
}
