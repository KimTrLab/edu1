package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetTopTen {

	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	@GetMapping("/getTopTenHashMap")
	public HashMap<String, String> aaa() {
		HashMap<String, String> h = new HashMap<>();
		h.put("java",
				"Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.put("Oracle",
				"Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.put("Web",
				"Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.put("java1",
				"Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.put("Oracle1",
				"Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.put("Web1",
				"Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		return h;
	}

	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	@GetMapping("/getTopTenList")
	public List<String> bbb() {
		List<String> h = new ArrayList<>();
		h.add("Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.add("Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.add("Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.add("Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.add("Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.add("Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		return h;
	}

	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	@GetMapping("/getTopTenString")
	public String ccc() {
		List<String> h = new ArrayList<>();
		h.add("Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.add("Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.add("Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.add("Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.add("Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.add("Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		// String result = String.join(",", h);

		String result = h.stream().map(s -> "\"" + s + "\"") // 각 요소에 쌍따옴표 추가
				.collect(Collectors.joining(",")); // 쉼표로 구분
		return result;
	}

	@CrossOrigin(origins = "http://127.0.0.1:5500/")
	@GetMapping("/getTopTenJson")
	public String json() {
		List<String> h = new ArrayList<>();
		h.add("Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.add("Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.add("Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.add("Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.add("Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		h.add("Java Is the Language of Possibilities Java is powering the innovation behind our digital world. Harness this potential with Java resources for student coders, hobbyists, developers, and IT leaders.");
		// String result = String.join(",", h);

		String result = h.stream().map(s -> "\"" + s + "\"") // 각 요소에 쌍따옴표 추가
				.collect(Collectors.joining(",")); // 쉼표로 구분
		result = "[" + result + "]";
		return result;
	}

	
}
