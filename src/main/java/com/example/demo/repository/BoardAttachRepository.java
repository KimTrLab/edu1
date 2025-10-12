package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BoardAttach;

public interface BoardAttachRepository extends JpaRepository<BoardAttach, Integer> {
	
}

