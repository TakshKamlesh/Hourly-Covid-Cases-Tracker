package com.trackers.coronavirustracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trackers.coronavirustracker.services.CovidDataService;

@Controller
public class HomeController {
	
	@Autowired
	CovidDataService covidDataService;
	@RequestMapping("/")
	public String home(Model model) {
		
		model.addAttribute("locationStats", covidDataService.getAllStats());
		return "home";
		
	}

}
