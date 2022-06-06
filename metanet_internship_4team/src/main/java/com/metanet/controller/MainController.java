package com.metanet.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.domain.TestOra;
import com.metanet.repository.TestOraRepository;

@RestController
public class MainController 
{

	@Autowired
	TestOraRepository tor;
	
	@GetMapping("/")
	public String maincontroller(Model model)
	{
		System.out.println("\n1.findAll()...");
        for (TestOra te : tor.findAll()) 
        {
            System.out.println(te);
        }

        System.out.println("\n2.findByuserId(int userId)...");
        for (TestOra te : tor.findByuserId(3)) 
        {
            System.out.println(te);
            System.out.println(te.getUserId());
            System.out.println(te.getUserName());
        }
		return "index";
	}

}
