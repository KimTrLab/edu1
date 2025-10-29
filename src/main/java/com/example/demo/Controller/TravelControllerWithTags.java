package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class TravelControllerWithTags {

    @GetMapping("/getTravel2")
    public List<Map<String, Object>> getTravelWithTags() {
        List<Map<String, Object>> travels = new ArrayList<>();

        travels.add(createTravel("경복궁", "서울", "역사/문화",
                "조선 왕조의 대표 궁궐로 전통 건축과 궁궐 문화를 체험할 수 있습니다.",
                4.8,
                Arrays.asList("전통", "궁궐", "문화체험")));

        travels.add(createTravel("남이섬", "강원도", "자연",
                "아름다운 나무와 강변 풍경이 어우러진 관광지로 사계절 내내 인기입니다.",
                4.7,
                Arrays.asList("자연", "산책", "데이트")));

        travels.add(createTravel("제주 한라산", "제주도", "자연/등산",
                "한라산 국립공원은 등산과 트래킹을 즐길 수 있는 제주도의 상징입니다.",
                4.9,
                Arrays.asList("등산", "자연경관", "트래킹")));

        travels.add(createTravel("부산 해운대", "부산", "해변/레저",
                "부산을 대표하는 해변으로 여름철 바다와 해양 스포츠를 즐기기에 좋습니다.",
                4.6,
                Arrays.asList("해변", "바다", "레저")));

        travels.add(createTravel("경주 불국사", "경상북도", "역사/문화",
                "신라 시대의 대표 사찰로 역사와 전통 건축을 감상할 수 있습니다.",
                4.8,
                Arrays.asList("사찰", "역사", "문화")));

        travels.add(createTravel("전주 한옥마을", "전라북도", "문화체험",
                "전통 한옥과 다양한 전통 체험을 즐길 수 있는 전주의 대표 관광지입니다.",
                4.7,
                Arrays.asList("한옥", "전통문화", "체험")));

        travels.add(createTravel("설악산", "강원도", "자연/등산",
                "사계절 아름다운 산과 단풍 명소로 등산과 트래킹이 인기입니다.",
                4.9,
                Arrays.asList("등산", "자연경관", "트래킹")));

        travels.add(createTravel("속초 중앙시장", "강원도", "맛집/쇼핑",
                "속초 대표 재래시장으로 해산물과 다양한 먹거리를 즐길 수 있습니다.",
                4.5,
                Arrays.asList("맛집", "재래시장", "쇼핑")));

        travels.add(createTravel("광주 국립아시아문화전당", "광주", "문화/예술",
                "아시아 문화와 예술을 체험할 수 있는 복합 문화 공간입니다.",
                4.6,
                Arrays.asList("문화", "예술", "체험")));

        travels.add(createTravel("인천 송도 센트럴파크", "인천", "도심/레저",
                "도심 속 대규모 공원으로 산책과 다양한 레저 활동을 즐길 수 있습니다.",
                4.4,
                Arrays.asList("공원", "도심", "산책")));

        return travels;
    }

    // 여행 정보 생성용 헬퍼 (tags 포함)
    private Map<String, Object> createTravel(String name, String region, String category,
                                             String description, double rating, List<String> tags) {
        Map<String, Object> travel = new HashMap<>();
        travel.put("name", name);
        travel.put("region", region);
        travel.put("category", category);
        travel.put("description", description);
        travel.put("rating", rating);
        travel.put("tags", tags);
        return travel;
    }
}
