package com.example.demo.Controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/aa")
	public HashMap<String,String> aaa () {
		HashMap<String,String> h = new HashMap<>();
		h.put("java", "Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.put("Oracle", "Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.put("Web", "Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.put("java1", "Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.put("Oracle1", "Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.put("Web1", "Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		return h;
	}

}
