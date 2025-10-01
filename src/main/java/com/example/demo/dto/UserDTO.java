package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	
	@NotBlank(message = "아이디는 필수입니다.")
    private String name;

    @NotBlank(message = "비밀번호는 필수입니다.")
    @Size(min = 8, max = 100)
    private String password;

    @Email
    private String email;

}

