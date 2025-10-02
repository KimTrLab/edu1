package com.example.demo.dto;

import com.example.demo.validation.NameLength;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	//valid는 여기서 유효성을 실패해도 데이터베이스 제약조건에만 맞는 다면 값이 들어간다
	//그래서 데이터베이스 테이블 만들때 고려해야 함.
	
	@NotBlank(message = "아이디는 필수입니다.")
	@NameLength
	private String name;

	@NotBlank(message = "Notblank 비밀번호는 필수입니다.")
	@Size(min = 8, max = 10)
	private String password;

	@Email(message = "올바른 이메일 형식이어야 합니다.")
	private String email;

}
