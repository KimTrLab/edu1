package com.example.demo.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.BBSDTO;

@RestController
@RequestMapping("/bbs/")
public class BBSController {
	
	private final String uploadDir = "C:/upload/files"; // 저장할 경로 (원하면 resources/static 등도 가능)
	
	@PostMapping("/save")
	public ResponseEntity<String> save(
			//@ModelAttribute BBSDTO bbsDTO,
			@RequestPart("data") BBSDTO bbsDTO,  //클라이언트가 json, multipart/form-data 안에서 part 단위의 JSON을 기대
	        @RequestPart(value="files", required = false) List<MultipartFile> files) {
		
		//System.out.println(bbsDTO.toString());
		//System.out.println(file.length);
		 // 결과 리스트
        List<String> savedFileNames = new ArrayList<>();
        List<String> originalFileNames = new ArrayList<>();
        

        try {
            if (files != null && !files.isEmpty()) {
                // 디렉토리가 존재하지 않으면 생성
                File directory = new File(uploadDir);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                for (MultipartFile file : files) {
                    if (!file.isEmpty()) {
                        // 원본 파일명
                        String originalName = file.getOriginalFilename();
                        originalFileNames.add(originalName);                        

                        // 파일명 중복 방지용 타임스탬프
                        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSSS"));

                        // 확장자 추출
                        String ext = "";
                        if (originalName != null && originalName.contains(".")) {
                            ext = originalName.substring(originalName.lastIndexOf("."));
                        }

                        // 저장 파일명
                        String savedName = timestamp + "_" + UUID.randomUUID() + ext;

                        // 저장 경로
                        Path path = Paths.get(uploadDir, savedName);

                        // 실제 저장
                        file.transferTo(path);

                        savedFileNames.add(savedName);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("파일 저장 중 오류 발생: " + e.getMessage());
        }
      //  System.out.println(originalFileNames);
      //  System.out.println(savedFileNames);
        bbsDTO.setOriginalFileNames(originalFileNames);
        bbsDTO.setSavedFileNames(savedFileNames);
        
        System.out.println(bbsDTO.toString());
        
        // 서비스 layers 해야 함.

		return ResponseEntity.ok("업로드 성공");
	}

}
