package com.metanet.controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController 
{

	@GetMapping("/")
	public String maincontroller(Model model)
	{
		
		return "index";
	}

}
