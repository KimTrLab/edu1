package com.example.demo.RestController;

import java.util.Map;

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
import com.example.demo.helper.ValidationUtil;

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
    public ResponseEntity<?> register(@Valid @RequestBody UserDTO request, BindingResult bindingResult) {
		
		// 유효성 체크 process
		// Valid  > 서비스 Layer (이름과, 이메일 유니크 체크) > database 무결성
		// Valid는 Hepler 패키지에서 처리
		// 서비스 Layer와 database무결성은 error 패키지에서 처리
		// ---------------------------------------------------------------------------------
		
		
        // 유효성 검증 실패 처리
		// helper package 분리하여 코드 분리 하여 주석 처리
		/*  
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = bindingResult.getFieldErrors().stream()
                    .collect(Collectors.toMap(
                            e -> e.getField(),
                            e -> e.getDefaultMessage()
                    ));
            return ResponseEntity.badRequest().body(errors);
        }*/
		
		//helper package 분리하여 코드 변경 
		// 분리하면 규모와 재사용성을 고려했다는 의미가 있다.. 코드이 가독성만 따지면 컨트롤러에 두는게 나은 듯
		if (bindingResult.hasErrors()) {
		    return ResponseEntity.badRequest().body(ValidationUtil.extractErrors(bindingResult));
		}

        // 서비스 등록
        userService.registerUser(request);
        return ResponseEntity.ok(Map.of("message", "회원가입 성공"));
    }
}
