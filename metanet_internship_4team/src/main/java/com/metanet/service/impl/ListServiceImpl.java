package com.metanet.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.metanet.domain.Video;
import com.metanet.service.ListService;

public abstract class ListServiceImpl implements ListService 
{
	/*
	@Autowired
	ListService service;
	
	@Override
	public List<Video> Search(String search, int page) {
		List<Video> keywordList = (ArrayList<Video>)service.findByvideoTitleContains(search);
		List<Video> retList = new ArrayList<>(keywordList.subList(page, page+4));		
		return retList;
	}
	*/
}
