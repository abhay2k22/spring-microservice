package com.example.add.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {
	
	
	@GetMapping("/add/num1/{n1}/num2/{n2}")
	public int add(@PathVariable int n1, @PathVariable int n2) {
		System.out.println("calling add service num1 = " + n1 + " num2 = " + n2);
		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return n1+n2;
	}
}
