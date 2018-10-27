package com.example.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CalculatorControllerSimple {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/calculator-simple-service/add/num1/{n1}/num2/{n2}")
	public int add(@PathVariable int n1, @PathVariable int n2) {
		String serviceUrl = "http://localhost:8762";
		System.out.println("num1 = " + n1 + " num2 = " + n2);
	    Integer i =  restTemplate.getForObject(serviceUrl+"/add/num1/"+n1+"/num2/"+n2, Integer.class);
	    return i;
	}

	@GetMapping("/calculator-simple-service/minus/num1/{n1}/num2/{n2}")
	public int minus(@PathVariable int n1, @PathVariable int n2) {
		String serviceUrl = "http://localhost:8764";
		System.out.println("num1 = " + n1 + " num2 = " + n2);
		Integer i =  restTemplate.getForObject(serviceUrl+"/minus/num1/"+n1+"/num2/"+n2, Integer.class);
	    return i;
	}
	
	@GetMapping("/calculator-simple-service/mul/num1/{n1}/num2/{n2}")
	public int mul(@PathVariable int n1, @PathVariable int n2) {
		String serviceUrl = "http://localhost:8763";
		System.out.println("num1 = " + n1 + " num2 = " + n2);
		Integer i =  restTemplate.getForObject(serviceUrl+"/mul/num1/"+n1+"/num2/"+n2, Integer.class);
	    return i;
	}
	
	@GetMapping("/calculator-simple-service/div/num1/{n1}/num2/{n2}")
	public int div(@PathVariable int n1, @PathVariable int n2) {
		String serviceUrl = "http://localhost:8765";
		System.out.println("num1 = " + n1 + " num2 = " + n2);
		Integer i =  restTemplate.getForObject(serviceUrl+"/div/num1/"+n1+"/num2/"+n2, Integer.class);
	    return i;
	}
}
