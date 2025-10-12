package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	// UserRepository는 JpaRepository<User, Long>를 상속하고 있기 때문에, 이미 기본적인 insert 기능은
	// 내장돼 있습니다.
	// 즉, userRepository.save(user)를 호출하면 JPA가 알아서 insert 또는 update를 수행합니다.

	// JpaRepository의 findById, findAll, findByXXX 등 기본 메서드를 사용할 때 주로 Entity로 반환됩니다.
	
	
	// JpaRepository는 메서드 이름을 보고 자동으로 쿼리를 만들어주는 기능이 있습니다. findById가 있는데 이거를 보고 자동으로
	// 쿼리를 만듬
	List<User> findByName(String name);

	// JpaRepository는 메서드 이름을 보고 자동으로 쿼리를 만들어주는 기능이 있습니다. like랑 비슷
	List<User> findByNameContaining(String keyword);

	// JpaRepository는 메서드 이름을 보고 자동으로 쿼리를 만들어주는 기능이 있습니다. name email 정확하게 일치
	List<User> findByNameAndEmail(String name, String email);

	// JpaRepository는 메서드 이름을 보고 자동으로 쿼리를 만들어주는 기능이 있습니다.
	List<User> findByNameLike(String pattern); // 예: "%kim%"

	@Query("SELECT u FROM User u WHERE u.email = :email")
	List<User> searchByEmail(@Param("email") String email);

	// 예를 들어 UserRepository에 다음 메서드 추가
	@Query("SELECT u FROM User u JOIN FETCH u.orders WHERE u.name = :userName")
	User findUserWithOrders(@Param("userName") String userName);

	boolean existsByName(String name);

	boolean existsByEmail(String email);

}
