package com.msn.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mshafina
 *
 */
@RestController
public class HomeController {

	@GetMapping("/hello")
	public String helloWorld() {
		return "Swagger Hello World";
	}

	@GetMapping("/val/{id}")
	public String getById(@PathVariable Integer id) {
		Map<Integer, String> map = new HashMap<>();
		map.put(id, "This is your value");
		return map.get(id);
	}
}
