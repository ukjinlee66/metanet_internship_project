package com.metanet.controller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.metanet.domain.Video;
import com.metanet.domain.DTO.VideoDTO;
import com.metanet.repository.VideoRepository;
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
	@Autowired
	private VideoRepository videoRepo;
	
	@Value("${file.path}")
	private String filepullpath;
	
	@Autowired
	VideoDTO videoDTO;
	
	
	
	@PostMapping("/Views")
	@CrossOrigin
	@ApiOperation(value="조회수 저장")
	public void VideoViews(@RequestParam int videoNumber){
		
		videoRepo.findByvideoNumber(videoNumber); 
		service.updateView(videoNumber);

	}
	
	@GetMapping("/Search")
	@ApiResponses({
        @ApiResponse(code = 200, message = "OK !!"),
        @ApiResponse(code = 404, message = "404 에러 발생, Not Found !"),
        @ApiResponse(code = 500, message = "500 에러 발생, Internal Server Error !")
	})
	@CrossOrigin
	@ApiOperation(value="레시피 검색과 해당 특정 키워드가 있을 경우", notes="검색어를 통한 레시피조회")
	public List<Video> Search (
			@ApiParam(value="검색어",required=false, example="계란찜")
			@RequestParam(required = false) String videoTitle,
			@ApiParam(value="분야",required=false, example="한식,중식,양식,일식,초급,중급,상급") 
			@RequestParam(required = false) String Color,
			@ApiParam(value="분야2",required=false, example="한식,중식,양식,일식,초급,중급,상급") 
			@RequestParam(required = false) String Color2
			) throws IOException
	{
		if (videoTitle != null && Color == null && Color2 == null) // 검색의 경우.
		{
			try 
			{
				return  service.Search(videoTitle);
				
			}
			catch(NullPointerException e)
			{
				System.out.println("List Service Search Function videoTitle Not null Color null region Error");
				return new ArrayList<>();
			}
		}
		else if(videoTitle == null && (Color != null || Color2 != null)) //단일 Color 선택의 경우.
		{
			if (Color == null && Color2 != null)
			{
				try 
				{
					System.out.println("Color null");
					switch(Color2)
					{
						case "한식": List<Video> v=  service.SearchKind(Color2); 
						
						case "일식": return  service.SearchKind(Color2);
						case "중식": return service.SearchKind(Color2);
						case "양식": return  service.SearchKind(Color2);
						case "초급": return  service.SearchLevel(Color2);
						case "중급": return  service.SearchLevel(Color2);
						case "상급": return  service.SearchLevel(Color2);
					}
				}
				catch(NullPointerException e)
				{
					System.out.println("List Service Search Function videoTitle null Color Not null Color null region Error");
					return new ArrayList<>();
				}
			}
			else if (Color2 == null && Color != null)
			{
				try 
				{
					System.out.println("Color2 null");
					switch(Color)
					{
						case "한식": return  service.SearchKind(Color); 
						case "일식": return  service.SearchKind(Color);
						case "중식": return  service.SearchKind(Color);
						case "양식": return  service.SearchKind(Color);
						case "초급": return  service.SearchLevel(Color);
						case "중급": return  service.SearchLevel(Color);
						case "상급": return  service.SearchLevel(Color);
					}
				}
				catch(NullPointerException e)
				{
					System.out.println("List Service Search Function videoTitle null Color Not null Color2 null region Error");
					return new ArrayList<>();
				}
			}
			else if (Color != null && Color2 != null)
			{
				try 
				{
					List<Video> first = new ArrayList<>();
					List<Video> ret_list = new ArrayList<>();
					switch(Color)
					{
						case "한식": first = service.SearchKind(Color); 
							break;
						case "일식": first = service.SearchKind(Color); 		
							break;		
						case "중식": first = service.SearchKind(Color); 
							break;
						case "양식": first = service.SearchKind(Color);
							break;
						case "초급": first = service.SearchLevel(Color);
							break;
						case "중급": first = service.SearchLevel(Color);
							break;
						case "상급": first = service.SearchLevel(Color);
							break;
					}
					for (Video v : first)
					{
						if(Color.equals("한식") || Color.equals("중식") || Color.equals("일식") || Color.equals("양식"))
						{
							if (v.getRecipeLevel().equals(Color2))
								ret_list.add(v);
						}
						else //한중양일이 아닐 경우 무조건 초중상 의 경우
						{
							if (v.getRecipeKind().equals(Color2))
								ret_list.add(v);
						}
					}
					return  ret_list;
				}
				catch(NullPointerException e)
				{
					System.out.println("123List Service Search Function videoTitle null Color Not null region Error");
					return new ArrayList<>();
				}
			}
		}
		else if(videoTitle != null && (Color != null || Color2 != null))
		{
			List<Video> retlist = new ArrayList<>();
			try 
			{
				
				if (Color == null && Color2 != null)
				{
					if(Color2.equals("한식") || Color2.equals("중식") || Color2.equals("일식") || Color2.equals("양식"))
						return  service.SearchKind(videoTitle, Color2) ;
					else
						return  service.SearchLevel(videoTitle, Color2) ;
				}
				else if (Color2 == null && Color != null)
				{
					if(Color.equals("한식") || Color.equals("중식") || Color.equals("일식") || Color.equals("양식"))
						return  service.SearchKind(videoTitle, Color)  ;
					else
						return  service.SearchLevel(videoTitle, Color) ;
				}
				else // Color, Color2 exist
				{
					List<Video> ar = new ArrayList<>();
					if(Color.equals("한식") || Color.equals("중식") || Color.equals("일식") || Color.equals("양식"))
					{	
						ar = service.SearchKind(videoTitle, Color);
						for(Video v : ar)
						{
							if (v.getRecipeLevel().equals(Color2))
								retlist.add(v);
						}
					}
					else
					{
						ar = service.SearchLevel(videoTitle, Color);
						for(Video v : ar)
						{
							if (v.getRecipeKind().equals(Color2))
								retlist.add(v);
						}
					}
					return  retlist;
				}
				
				
			}
			catch(NullPointerException e)
			{
				System.out.println("456List Service Search Function videoTitle Not null Color Not null region Error");
				return  retlist ;
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
			) throws IOException
	{
		//List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Video[] li = g.fromJson(list, Video[].class);
		ArrayList<Video> v = new ArrayList<Video>(Arrays.asList(li));
				
		switch(Color)
		{
			case "Time":return  service.SearchCreateTitle(v) ;
			case "Like":return  service.SearchtoLikes(v) ;
			case "View":return  service.SearchViewTitle(v) ;
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
		Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		Video[] li = g.fromJson(list, Video[].class);
		ArrayList<Video> v = new ArrayList<Video>(Arrays.asList(li));
		return(v.size());
	}
	
	
	@GetMapping("/getImg")
	@CrossOrigin
	@ApiResponses({
        @ApiResponse(code = 200, message = "OK !!"),
        @ApiResponse(code = 404, message = "404 에러 발생, Not Found !"),
        @ApiResponse(code = 500, message = "500 에러 발생, Internal Server Error !")
	})
	@ApiOperation(value="단일 이미지 반환", notes="리스트를 순회하며 렌더링시 해당메소드를 활용해 이미지를 얻어온다.")
	public java.lang.String getImg(
			@ApiParam(value="레시피 넘버",required=true, example="레시피넘버를 가지고 이미지를 반환")
			@RequestParam(value="videoNumber") int videoNumber) throws IOException
	{
		Video video = videoRepo.findByvideoNumber(videoNumber);
		String fileFullPath = filepullpath +  "/" + video.getVideoName() +  "/" + video.getVideoName()+".png";
	    InputStream imageStream = new FileInputStream(fileFullPath);
	    byte[] imageByteArray = IOUtils.toByteArray(imageStream);
	    imageStream.close();
	       
	    return (Base64.encodeBase64String(imageByteArray));
	}
	
	
}
