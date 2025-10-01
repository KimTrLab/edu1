package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	@Autowired
    private final UserRepository userRepository;
	//@Autowired
   // private final PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(UserDTO request) {
        // 1. 중복 체크
        if (userRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("이미 사용중인 이메일입니다.");
        }

        // 2. 비밀번호 암호화
     //   String encodedPassword = passwordEncoder.encode(request.getPassword());

        // 3. User 엔티티 생성 및 저장        
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userRepository.save(user);
    }
}
