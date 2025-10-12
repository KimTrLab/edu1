package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BoardAttach;

public interface BoardAttachRepository extends JpaRepository<BoardAttach, Integer> {
	// Integer가 의미하는 것은 엔티티(User)의 기본키(ID)의 타입
	
}

