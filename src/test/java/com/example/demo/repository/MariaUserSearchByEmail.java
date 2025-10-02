package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Edu1Application;
import com.example.demo.entity.User;

//@Transactional   테스트할 때 이게 있으면 테스트 성공후 자동으로 롤백
@SpringBootTest(classes = Edu1Application.class)
public class MariaUserSearchByEmail {
	
	//@Autowired
	private final UserRepository userRepository;

	@Autowired
    public MariaUserSearchByEmail(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void testCreateUser() {
        // given
    	String email = "test@example.com";
        List<User> u = userRepository.searchByEmail(email);
        System.out.println(u.size());

    }
}