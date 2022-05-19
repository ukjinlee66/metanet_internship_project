package com.metanet.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.metanet.domain.TestOra;
import com.metanet.repository.TestOraRepository;

@Controller
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
            System.out.println(te.getUser_id());
            System.out.println(te.getUser_name());
        }

//        System.out.println("\n2.findByEmail(String email)...");
//        for (TestOra te : tor.findByuser_id(3)) 
//        {
//            System.out.println(te);
//        }
		return "index";
	}

}
