package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)  //jpa용 기본 생성자
@AllArgsConstructor   //Builder가 사용할 생성자
@Builder     // DTO - entity변환 유용
@Table(name = "board")
public class Board {
	
	@Id   // 엔티티(Entity)에서 기본 키(Primary Key) 역할을 하는 필드임을 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 있으면 DB에서 자동으로 생성하는 룰에 따른다. 
    @Column(name = "num")   // DB 컬럼명이 iid
	private Integer num;
	
	@Column  // DB 컬럼명이 iid
	private String category;
	
	@Column  // DB 컬럼명이 iid
	private String title;
	
	@Column  // DB 컬럼명이 iid
	private String content;
	
	@Column   // DB 컬럼명이 iid
	private String userName;
	
	@Column  // DB 컬럼명이 iid
	private String pass;
	
	@Column  // DB 컬럼명이 iid
	private int viewCnt;
	
	@Column // DB 컬럼명이 iid
	private int niceCnt;
	
	
	//columnDefinition 테이블 생성 시 DDL에 default 값을 포함 (CREATE TABLE 용도)
	// @PrePersist JPA insert 시 값을 엔티티에서 채움, DB default는 실제 사용 안 됨
	@Column(name = "in_date", columnDefinition = "timestamp default current_timestamp")
	private LocalDateTime inDate;
	/**
	 * DB의 default값을 따르고 싶다.
	 * @Column(name = "in_date", columnDefinition = "timestamp default current_timestamp", insertable = false, updatable = false)
		private LocalDateTime inDate;

	 * 
	 */
	@PrePersist
	public void prePersist() {
	    if (inDate == null) {
	        inDate = LocalDateTime.now();
	    }
	}
	
	/***
	 * Spring Boot + Hibernate를 쓰면 기본적으로 다음 전략이 적용됩니다:
		CamelCase → snake_case 변환
		inDate → in_date
		createdAt → created_at
	 */
	
	//첨부파일 작업
	@OneToMany(mappedBy = "bbs", cascade = CascadeType.ALL, orphanRemoval = true)
	@Builder.Default  // 이 어노테이션은 Lombok에게 "빌더를 통해 이 필드에 값이 명시적으로 설정되지 않은 경우, 여기에 지정된 **초기화 표현식(default value)**을 사용하라"고 지시합니다.
    private List<BoardAttach> attachments = new ArrayList<>();

    public void addAttachment(BoardAttach attach) {
    	System.out.println(attachments);
        attachments.add(attach);
        attach.setBbs(this);
    }

}
