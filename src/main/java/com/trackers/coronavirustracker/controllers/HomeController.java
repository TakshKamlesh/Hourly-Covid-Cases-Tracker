package com.trackers.coronavirustracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trackers.coronavirustracker.models.LocationStats;
import com.trackers.coronavirustracker.services.CovidDataService;

@Controller
public class HomeController {
	
	@Autowired
	CovidDataService covidDataService;
	@RequestMapping("/")
	public String home(Model model) {
		
		List<LocationStats> locationStats = covidDataService.getAllStats();
		int totalGlobalCases = locationStats.stream().mapToInt(stat->stat.getLatestTotalCases()).sum();
		model.addAttribute("locationStats", locationStats);
		model.addAttribute("totalReportedCases", totalGlobalCases);
		return "home";
		
	}

}
