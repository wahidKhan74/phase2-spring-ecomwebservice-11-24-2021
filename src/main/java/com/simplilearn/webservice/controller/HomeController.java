package com.simplilearn.webservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.model.Product;

@RestController
public class HomeController {
	
//	@RequestMapping(value="/", method=RequestMethod.GET)
	@GetMapping("/")
	public String indexMapper() {
		return "Server is up and running !";
	}
	
	
//	@RequestMapping(value="/hello", method=RequestMethod.GET)
	@GetMapping("/hello")
	public String helloMapper(@RequestParam("name") String name) {
		return "Hello , '"+name+"' welcome to webservice development !";
	}
	

//	@RequestMapping(value="/greeting", method=RequestMethod.GET)
	@GetMapping("/greeting")
	public String greetingMapper() {
		return "Today is a wonderfull day !";
	}

//	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	@GetMapping("/users/{id}")
	public String userMapper(@PathVariable("id") int id) {
		return "Get user with user Id "+id;
	}
	
//	@RequestMapping(value="/product/create", method=RequestMethod.POST)
	@PostMapping("/product/create")
	public Product createMapper(@RequestBody Product product) {
		return product;
	}
}
