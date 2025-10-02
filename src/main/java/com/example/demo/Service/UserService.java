package com.example.demo.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
//	@Autowired
    private final UserRepository userRepository;
	//@Autowired
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(UserDTO request) {
        // 1. 중복 체크
        if (userRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("이미 사용중인 이메일입니다.");
        }

        String encodedPassword=null;
        if(request.getPassword().length() >= 8) {
        	  // 2. 비밀번호 암호화
            encodedPassword = passwordEncoder.encode(request.getPassword());
        }else {
        	throw new IllegalArgumentException("비밀번호 8자리 이상입니다.");
        }
      

        // 3. 영속화 전 상태  user entity만든 상태 
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(encodedPassword);
        // 영속화 컨텍스트에 저장 
        userRepository.save(user);
        // 이제 데이터베이스는 영속화 컨텍스트에 의해 관리
    }
}
