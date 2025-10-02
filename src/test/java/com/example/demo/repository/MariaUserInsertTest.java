package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Edu1Application;
import com.example.demo.entity.User;

//@Transactional   테스트할 때 이게 있으면 테스트 성공후 자동으로 롤백
@SpringBootTest(classes = Edu1Application.class)
public class MariaUserInsertTest {
	
	//@Autowired
	private final UserRepository userRepository;

	@Autowired
    public MariaUserInsertTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void testCreateUser() {
        // given
        String name = "nya";
        String email = "user1@example.com";

        // when
        User savedUser = createUser(name, email);

        // then
        assertNotNull(savedUser.getId(), "Saved user ID should not be null");
        assertEquals(name, savedUser.getName());
        assertEquals(email, savedUser.getEmail());
    }

    private User createUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        
        
        return userRepository.save(user);   // Hibernate: insert into user (email,name) values (?,?)
    }
}