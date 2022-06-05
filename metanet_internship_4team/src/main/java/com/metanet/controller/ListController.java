package com.metanet.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.domain.Video;
import com.metanet.service.ListService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/List")
public class ListController //게시글 리스트를 출력하기위한 Controller 
{
	/*
	@Autowired
	private ListService service;
	
	@GetMapping("/Search")
	@ApiOperation(value="레시피 검색", notes="검색어를 통한 레시피조회")
	public List<Video> search(
			@ApiParam(value="검색어",required=true, example="계란찜") @RequestParam String videoTitle
			)
	{
		System.out.println("IN: "+videoTitle);
		List<Video> v = service.Search(videoTitle);
		return v;
	}
	
	@GetMapping("/SearchToTime")
	@ApiOperation(value="시간순 검색", notes="최신업로드된 레시피 기준 조회")
	public List<Video> searchToTime(
			@ApiParam(value="검색어",required=true, example="부대찌개") @RequestParam String videoTitle
			)
	{
		List<Video> v = service.SearchCreateTitle(videoTitle);
		return(v);
	}
	*/
}
