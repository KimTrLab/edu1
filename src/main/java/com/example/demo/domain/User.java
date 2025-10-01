package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {
  
    @Id   // 엔티티(Entity)에서 기본 키(Primary Key) 역할을 하는 필드임을 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 있으면 DB에서 자동으로 생성하는 룰에 따른다. 
    @Column(name = "id")   // DB 컬럼명이 iid
    private Long id;

    @Column(nullable=false, unique=true, length = 10)   // DB 컬럼명이 iid
    private String name;
    
    @Column
    private String password;
    
    @Column(name = "email")   // DB 컬럼명이 iid
    private String email;

    // User객체는  여러 Porder를 가짐 (1:N)
    //주인이 user(외래키가 있는 쪽)  Porder 클래스의 user 필드명 
    //FetchType.LAZY 지연로딩전략 기본설정, 실제사용시 로딩해 와라
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)  
    private List<Porder> orders = new ArrayList<>();
    
}