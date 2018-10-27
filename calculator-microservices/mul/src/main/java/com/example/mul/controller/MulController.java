package com.example.mul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MulController {
	
	@GetMapping("/mul/num1/{n1}/num2/{n2}")
	public int add(@PathVariable int n1, @PathVariable int n2) {
		System.out.println("num1 = " + n1 + " num2 = " + n2);
		return n1*n2;
	}
}
