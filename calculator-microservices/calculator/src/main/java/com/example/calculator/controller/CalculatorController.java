package com.example.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@FeignClient("caluclator-minus-service")
interface MinusClient{
	@GetMapping("/minus/num1/{n1}/num2/{n2}")
	int getResult(@PathVariable(value = "n1") int n1, @PathVariable(value = "n2") int n2);	
}

@FeignClient("caluclator-div-service")
interface DivClient{
	@GetMapping("/div/num1/{n1}/num2/{n2}")
	int getResult(@PathVariable(value = "n1") int n1, @PathVariable(value = "n2") int n2);
}

@FeignClient("caluclator-add-service")
interface AddClient{
	@GetMapping("/add/num1/{n1}/num2/{n2}")
	int getResult(@PathVariable(value = "n1") int n1, @PathVariable(value = "n2") int n2);
}

@FeignClient("caluclator-mul-service")
interface MulClient{
	@GetMapping("/mul/num1/{n1}/num2/{n2}")
	int getResult(@PathVariable(value = "n1") int n1, @PathVariable(value = "n2") int n2);
}

@RestController
public class CalculatorController {	
	@Autowired
	RestTemplate restTemplate;	
	@Autowired
	private MinusClient mclient;	
	@Autowired
	private DivClient dClient;	
	@Autowired
	private MulClient mulClient;	
	@Autowired
	private AddClient aClient;
	
	@HystrixCommand(commandKey = "add-service-fallback", fallbackMethod = "getDefaultAddFallBack")
	//@HystrixCommand(fallbackMethod = "getDefaultAddFallBack")
	@GetMapping("/calculator-service/add/num1/{n1}/num2/{n2}")
	public int add(@PathVariable int n1, @PathVariable int n2) {
		System.out.println("num1 = " + n1 + " num2 = " + n2);
	    Integer i =  aClient.getResult(n1,n2);
	    return i;
	}

	@GetMapping("/calculator-service/minus/num1/{n1}/num2/{n2}")
	public int minus(@PathVariable int n1, @PathVariable int n2) {
		System.out.println("num1 = " + n1 + " num2 = " + n2);
		Integer i = mclient.getResult(n1,n2);
	    return i;
	}
	
	@GetMapping("/calculator-service/mul/num1/{n1}/num2/{n2}")
	public int mul(@PathVariable int n1, @PathVariable int n2) {
		System.out.println("num1 = " + n1 + " num2 = " + n2);
		Integer i =  mulClient.getResult(n1,n2);
	    return i;
	}
	
	@GetMapping("/calculator-service/div/num1/{n1}/num2/{n2}")
	public int div(@PathVariable int n1, @PathVariable int n2) {
		System.out.println("num1 = " + n1 + " num2 = " + n2);
		Integer i =  dClient.getResult(n1,n2);
	    return i;
	}
	
	
	public int getDefaultAddFallBack(int n1, int n2) {
		System.out.println("Add function failing => n1 = " + n1 + " n2 = " + n2);
		return 10000+n1+n2;
	}
}
