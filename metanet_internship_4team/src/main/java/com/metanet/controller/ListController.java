package com.metanet.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.metanet.domain.Video;
import com.metanet.service.ListService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/List")
public class ListController //게시글 리스트를 출력하기위한 Controller 
{
	@Autowired
	private ListService service;
	
	@GetMapping("/Search")
	@ApiResponses({
        @ApiResponse(code = 200, message = "OK !!"),
        @ApiResponse(code = 404, message = "404 에러 발생, Not Found !"),
        @ApiResponse(code = 500, message = "500 에러 발생, Internal Server Error !")
	})
	@CrossOrigin
	@ApiOperation(value="레시피 검색과 해당 특정 키워드가 있을 경우", notes="검색어를 통한 레시피조회")
	public List<Video> Search(
			@ApiParam(value="검색어",required=false, example="계란찜")
			@RequestParam(required = false) String videoTitle,
			@ApiParam(value="분야",required=false, example="한식,중식,양식,일식,초급,중급,상급") 
			@RequestParam(required = false) String Color,
			@ApiParam(value="리스트",required=false, example="현재 리스트에서 Color기준으로 Select column요청") 
			@RequestParam(required = false) List<Video> arr
			)
	{
		if (arr == null) // Param : videoTitle , Color
		{
			if (videoTitle != null && Color == null) // 검색의 경우.
			{
				try 
				{
					List<Video> v = service.Search(videoTitle);
					return v;
				}
				catch(NullPointerException e)
				{
					System.out.println("List Service Search Function videoTitle Not null Color null region Error");
					return new ArrayList<>();
				}
			}
			else if(videoTitle == null && Color != null) //단일 Color 선택의 경우.
			{
				try 
				{
					switch(Color)
					{
						case "한식": return service.SearchKind(Color); 
						case "일식": return service.SearchKind(Color);
						case "중식": return service.SearchKind(Color);
						case "양식": return service.SearchKind(Color);
						case "초급": return service.SearchLevel(Color);
						case "중급": return service.SearchLevel(Color);
						case "상급": return service.SearchLevel(Color);
					}
				}
				catch(NullPointerException e)
				{
					System.out.println("List Service Search Function videoTitle null Color Not null region Error");
					return new ArrayList<>();
				}
			}
			else
			{
				List<Video> retlist = new ArrayList<>();
				try 
				{
					List<Video> ar = service.Search(videoTitle);
					
					if (ar.isEmpty()) return retlist;
					if (Color.equals("한식") || Color.equals("중식") || Color.equals("일식") || Color.equals("양식"))
					{
						for(Video v : ar)
						{
							if(v.getRecipeKind().equals(Color))
								retlist.add(v);
						}
					}
					else
					{
						for(Video v : ar)
						{
							if(v.getRecipeLevel().equals(Color))
								retlist.add(v);
						}
					}
					return retlist;
				}
				catch(NullPointerException e)
				{
					System.out.println("List Service Search Function videoTitle Not null Color Not null region Error");
					return retlist;
				}
			}
		}
		else // param : Array , Color
		{
			try 
			{
				List<Video> retlist = new ArrayList<>();
				List<Video> ar = arr;
				if (ar.isEmpty()) return retlist;
				if (Color.equals("한식") || Color.equals("중식") || Color.equals("일식") || Color.equals("양식"))
				{
					for(Video v : ar)
					{
						if(v.getRecipeKind().equals(Color))
							retlist.add(v);
					}
				}
				else
				{
					for(Video v : ar)
					{
						if(v.getRecipeLevel().equals(Color))
							retlist.add(v);
					}
				}
				return retlist;
			}
			catch(NullPointerException e)
			{
				System.out.println("List Service Search Function videoTitle null Color Not null region Error");
				return new ArrayList<>();
			}
		}
		System.out.println("List Service Search Function Outer region Error!");
		return new ArrayList<>();
	}
	
	
	@GetMapping("/Sort")
	@CrossOrigin
	@ApiResponses({
        @ApiResponse(code = 200, message = "OK !!"),
        @ApiResponse(code = 404, message = "404 에러 발생, Not Found !"),
        @ApiResponse(code = 500, message = "500 에러 발생, Internal Server Error !")
	})
	@ApiOperation(value="정렬", notes="파라메터로 입력된 어레이를 정렬형태에 맞춰 정렬시켜 반환한다.")
	public List<Video> ListSort(
			@ApiParam(value="리스트",required=true, example="List<Video> 형태의 Array List") 
			@RequestParam(value="list") String list,
			@ApiParam(value="정렬 형태",required=true, example="정렬 형태 :  \"Time\",\"View\",\"Like\" 입력을 받는다.") 
			@RequestParam String Color
>>>>>>> master
			)
	{
		//List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		SqlDateTypeAdapter sqlAdapter = new SqlDateTypeAdapter();
		Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Video[] li = g.fromJson(list, Video[].class);
		ArrayList<Video> v = new ArrayList<Video>(Arrays.asList(li));
				
		switch(Color)
		{
			case "Time":return service.SearchCreateTitle(v);
			case "Like":return service.SearchtoLikes(v);
			case "View":return service.SearchViewTitle(v);
		}
		return new ArrayList<>();
	}
	
	@GetMapping("/Length")
	@CrossOrigin
	@ApiResponses({
        @ApiResponse(code = 200, message = "OK !!"),
        @ApiResponse(code = 404, message = "404 에러 발생, Not Found !"),
        @ApiResponse(code = 500, message = "500 에러 발생, Internal Server Error !")
	})
	@ApiOperation(value="리스트 길이반환", notes="페이징 구현을 위해 파라메터로들어온 리스트의 길이를 반환")
	public int ListLength(
			@ApiParam(value="리스트",required=true, example="List<Video> array형태의 파라메터")
			@RequestParam(value="list") String list
			)
	{
		SqlDateTypeAdapter sqlAdapter = new SqlDateTypeAdapter();
		Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Video[] li = g.fromJson(list, Video[].class);
		ArrayList<Video> v = new ArrayList<Video>(Arrays.asList(li));
		return(v.size());
	}
}
