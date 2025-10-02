package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Edu1Application;
import com.example.demo.entity.Porder;
import com.example.demo.entity.User;

//@Transactional   테스트할 때 이게 있으면 테스트 성공후 자동으로 롤백
@SpringBootTest(classes = Edu1Application.class)
public class MariaUser_Porder_join {
	
	//@Autowired
	private final UserRepository userRepository;

	@Autowired
    public MariaUser_Porder_join(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void testCreateUser() {
        // given
        //String name = "ba";
    	String name = "aaa";
        
    	User user = userRepository.findUserWithOrders(name);
    	System.out.println("User name: " + user.getName());
    	for (Porder order : user.getOrders()) {
    	    System.out.println("Order product: " + order.getProduct());
    	}
    }
}