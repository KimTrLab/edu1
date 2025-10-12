package com.example.demo.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.BoardAttach;
import com.example.demo.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final String uploadDir = "C:/upload/files"; // 저장할 경로 (원하면 resources/static 등도 가능)
	private final BoardRepository boardRepository;
	
	public int saveBoard(BoardDTO bbsDTO, List<MultipartFile> files) throws IOException {
		
		  //dto를 entity로 바꾸기        
        Board bbs = Board.builder()
        		.category(bbsDTO.getCategory())
        		.title(bbsDTO.getTitle())
        		.content(bbsDTO.getContent())
        		.userName(bbsDTO.getUserName())
        		.pass(bbsDTO.getPass())
        		.attachments(new ArrayList<>())  //BBS생성자로 하면 코딩된대로 되지만 builer로 만들때는 해 줘야 함
        		.build();
        
		 // 결과 리스트
		 // 결과 리스트
        List<String> savedFileNames = new ArrayList<>();
        List<String> originalFileNames = new ArrayList<>();        

        try {
            if (files != null) {
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
                        
                        // 파일명만 DB에 저장
                        BoardAttach attach = BoardAttach.builder()
                                .fileName(originalName)
                                .build();
                        System.out.println(attach);
                        bbs.addAttachment(attach);

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 1;
        }
      //  System.out.println(originalFileNames);
      //  System.out.println(savedFileNames);
        bbsDTO.setOriginalFileNames(originalFileNames);
        bbsDTO.setSavedFileNames(savedFileNames);
        System.out.println(bbsDTO.toString());
        
      
        		        
        
        boardRepository.save(bbs);
        
        // entity만들기
        // board랑 board_attach 엔티티 만들기
        // board 엔티티 객체 만들고 dto에 있는 내용 복사하기
        // 첨부파일을 로컬 디렉토리에 복사하고 그 파일명을 가각 위에서 만든 board엔티티에 저장하기
        // 마지막으로 board 엔티티 save하기
        
        return 2;		
	}
	
	public List<Board> getAllBoards() {
        return boardRepository.findAll(); // 👈 모든 튜플 조회
    }
	

}
