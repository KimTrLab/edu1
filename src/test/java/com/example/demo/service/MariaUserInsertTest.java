package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Edu1Application;
import com.example.demo.Service.UserService;
import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.repository.UserRepository;

//@Transactional   테스트할 때 이게 있으면 테스트 성공후 자동으로 롤백
@SpringBootTest(classes = Edu1Application.class)
public class MariaUserInsertTest {
	
	//@Autowired
	private final UserService userService;

	@Autowired
    public MariaUserInsertTest(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void testCreateUser() {
    	UserDTO u = new UserDTO();
    	u.setName("aaee");
    	u.setEmail("aaa@aa.com");
    	u.setPassword("1111");
    	userService.registerUser(u);
        
    }

}