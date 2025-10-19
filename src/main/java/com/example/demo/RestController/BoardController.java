package com.example.demo.RestController;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.BoardService;
import com.example.demo.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bbs/")
public class BoardController {
	
	private final BoardService bbsService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(
			//@ModelAttribute BBSDTO bbsDTO,
			@RequestPart("data") BoardDTO bbsDTO,  //클라이언트가 json, multipart/form-data 안에서 part 단위의 JSON을 기대
	        @RequestPart(value="files", required = false) List<MultipartFile> files) throws IOException {
		
		//System.out.println(bbsDTO.toString());
		//System.out.println(file.length);
		
        
        // 서비스 layers 해야 함.
		int msg = bbsService.saveBoard(bbsDTO, files);
		
		//
		if(msg == 1) {
			return ResponseEntity.internalServerError().body("파일 저장 중 오류 발생: ");
		}else {
			return ResponseEntity.ok("업로드 성공");
		}
		
	}

}
