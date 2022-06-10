package com.metanet.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.repository.TestOraRepository;

@RestController
public class MainController 
{

	@Autowired
	TestOraRepository tor;
	
	@GetMapping("/")
	public String maincontroller(Model model)
	{
		
		return "index";
	}

}
