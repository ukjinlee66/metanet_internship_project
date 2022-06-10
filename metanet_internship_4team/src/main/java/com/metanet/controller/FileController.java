package com.metanet.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/file")
public class FileController {

	
	@PostMapping("/upload")
	@CrossOrigin
	@ApiOperation(value="아이디 중복 확인",notes="회원가입시 아이디 중복여부 확인 / 중복시 -1, 중복 아닐시 1 반환")
	public String upload(@RequestParam("file") MultipartFile multipartFile) {
		
		
		return "완료:";
		
	}
	
	
}
