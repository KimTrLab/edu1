package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetMovie {


    @GetMapping("/getMovie")
	public List<Map<String, Object>> getMovies() {
		List<Map<String, Object>> movies = new ArrayList<>();
		System.out.println("aaa");

		movies.add(createMovie("인셉션", "크리스토퍼 놀란",
				"꿈 속의 세계를 탐험하는 이야기"));

		movies.add(createMovie("인터스텔라", "크리스토퍼 놀란",
				"시간과 차원을 넘나드는 우주 탐험"));

		movies.add(createMovie("어벤져스: 엔드게임", "안소니 루소, 조 루소",
				"어벤져스의 최종 전투"));

		movies.add(createMovie("라이언 일병 구하기", "스티븐 스필버그",
				"2차 세계대전 중 한 병사를 구하는 이야기"));

		movies.add(createMovie("포레스트 검프", "로버트 저메키스",
				"한 남자의 인생 여정을 그린 이야기"));

		movies.add(createMovie("조커", "토드 필립스",
				"고담시의 범죄와 혼란 속 한 남자의 이야기"));

		movies.add(createMovie("기생충", "봉준호",
				"계층간 갈등을 그린 사회 풍자 영화"));

		movies.add(createMovie("올드보이", "박찬욱",
				"15년 감금 후 복수극을 그린 이야기"));

		movies.add(createMovie("괴물", "봉준호",
				"한강에 나타난 괴물과 가족의 사투"));

		movies.add(createMovie("라라랜드", "다미엔 차젤레",
				"사랑과 꿈을 그린 뮤지컬 영화"));

		movies.add(createMovie("해리포터와 마법사의 돌", "크리스 콜럼버스",
				"마법 세계로의 입문 이야기"));

		movies.add(createMovie("해리포터와 아즈카반의 죄수", "알폰소 쿠아론",
				"호그와트의 새로운 모험"));

		movies.add(createMovie("어벤져스: 인피니티 워", "안소니 루소, 조 루소",
				"타노스와 어벤져스의 대결"));

		movies.add(createMovie("스파이더맨: 노 웨이 홈", "존 왓츠",
				"멀티버스를 넘나드는 스파이더맨 이야기"));

		movies.add(createMovie("기묘한 이야기: 더 무비", "더스틴 스톤버그",
				"호킨스의 미스터리 사건 해결"));

		movies.add(createMovie("트와일라잇", "캐서린 하드윅",
				"뱀파이어와 인간 소녀의 사랑 이야기"));

		movies.add(createMovie("반지의 제왕: 반지 원정대", "피터 잭슨",
				"중간계를 지키기 위한 모험"));

		movies.add(createMovie("스타워즈: 새로운 희망", "조지 루카스",
				"제국과 반란군의 싸움"));

		movies.add(createMovie("스타워즈: 제국의 역습", "어빙 커쉬너",
				"반란군의 역습과 다스베이더의 등장"));

		movies.add(createMovie("스타워즈: 제다이의 귀환", "리처드 마퀀드",
				"제국과 최종 결전"));

		return movies;
	}

	// 영화 데이터 생성용 헬퍼
	private Map<String, Object> createMovie(String title, String director,  String description) {
		Map<String, Object> movie = new HashMap<>();
		movie.put("title", title);
		movie.put("director", director);
		movie.put("description", description);
		return movie;
	}


}
