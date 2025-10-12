package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {	
	private int num;
	private String category;
	private String title;
	private String content;
	private String userName;
	private String pass;
	private int viewCnt;
	private int niceCnt;
	private String inDate;
	private List<String> savedFileNames;
	private List<String> originalFileNames;
	//private List<MultipartFile> files;
}
