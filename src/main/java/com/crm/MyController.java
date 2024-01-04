package com.crm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MyController {
	
	@RequestMapping(path="/demo",method= RequestMethod.GET)
	public String welcome()
	
	{
		return "<h3>welcome to my project</h3>";
	}

}
