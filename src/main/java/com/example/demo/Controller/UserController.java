package com.example.demo.Controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.dto.UserDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private final UserService userService;

	// public ResponseEntity<String> register(@Valid @ModelAttribute UserDTO
	// request, BindingResult bindingResult) {

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/register")
	public ResponseEntity<String> register(@Valid @RequestBody UserDTO request, BindingResult bindingResult) { // json형태로
																												// 받겠다.
		// http://localhost:8080/api/users/register?name=aoq&password=123411111&email=a@a.com
		// System.out.println("aaa");

		userService.registerUser(request);
		if (bindingResult.hasErrors()) {
			String errorMsg = bindingResult.getFieldErrors().stream()
					.map(e -> e.getField() + ": " + e.getDefaultMessage()).collect(Collectors.joining(", "));
			return ResponseEntity.badRequest().body(errorMsg);
		}
		return ResponseEntity.ok("회원가입 성공");
	}
}
