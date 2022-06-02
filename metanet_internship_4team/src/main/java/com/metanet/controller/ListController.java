package com.metanet.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.domain.Video;
import com.metanet.service.ListService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/List")
@NoArgsConstructor
public class ListController //게시글 리스트를 출력하기위한 Controller 
{
	/*
	@Autowired
	private ListService service;
	
	@GetMapping("/SearchPage")
	@ApiOperation(value="레시피 검색", notes="검색어를 통한 레시피조회 페이지수 포함")
	public List<Video> search(
			@ApiParam(value="검색어",required=true, example="불고기") String search,
			@ApiParam(value="페이지수", required=true, example="2") int page
			)
	{
		return(service.Search(search, page));
	}
	
	@GetMapping("/Search")
	@ApiOperation(value="레시피 검색", notes="검색어를 통한 레시피조회")
	public Optional<Video> search(
			@ApiParam(value="검색어",required=true, example="계란찜") String search
			)
	{
		return(service.findByvideoTitleContains(search));
	}
	*/
}
