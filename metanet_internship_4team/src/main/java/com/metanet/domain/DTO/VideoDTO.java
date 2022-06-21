package com.metanet.domain.DTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.metanet.domain.Video;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
public class VideoDTO {

	@Value("${file.path}") 
	private String baseSavefilePath;
	
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class  addDetailRequest{
		
		private String videoTitle;
		private String videoContexts;
		private String videoName;
		private String recipeLevel;
		private String recipeKind;
		private int recipeTime;
		private int recipeSize;
		private String recipeIngredient;
		
				
		public Video transferTo( Video video ) {
			
			video.setVideoTitle(videoTitle);
			video.setVideoName(videoName);
			video.setVideoContexts(videoContexts);
			video.setRecipeLevel(recipeLevel);
			video.setRecipeKind(recipeKind);
			video.setRecipeTime(recipeTime);
			video.setRecipeSize(recipeSize);
			video.setRecipeIngredient(recipeIngredient);
			
			return video;			
			
		}
	
	}
		
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class  updateDetailRequest{
		
		private int videoNumber;
		private String videoTitle;
		private String videoName;
		private String videoContexts;
		private String recipeLevel;
		private String recipeKind;
		private int recipeTime;
		private int recipeSize;
		private String recipeIngredient;
		
				
		public Video transferTo( Video video ) {
			
			video.setVideoTitle(videoTitle);
			video.setVideoName(videoName);
			video.setVideoContexts(videoContexts);
			video.setRecipeLevel(recipeLevel);
			video.setRecipeKind(recipeKind);
			video.setRecipeTime(recipeTime);
			video.setRecipeSize(recipeSize);
			video.setRecipeIngredient(recipeIngredient);
			
			return video;			
			
		}
	
	}
	
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public class  detailResponse{
		
		private int videoNumber;
		private String videoTitle;
		private String videoName;
		private String videoContexts;
		private String recipeImg;		// 이미지 url 
		private String recipeLevel;
		private String recipeKind;
		private int recipeTime;
		private int recipeSize;
		private String recipeIngredient;
		
		public void transferFrom( Video video )throws IOException {
			
			
			videoNumber =  video.getVideoNumber();
			videoTitle = video.getVideoTitle();
			videoName = video.getVideoName();
			videoContexts = video.getVideoContexts();
			
			recipeLevel = video.getRecipeLevel();
			recipeKind = video.getRecipeKind();
			recipeTime = video.getRecipeTime();
			recipeSize = video.getRecipeSize();
			recipeIngredient = video.getRecipeIngredient();
			
		
			String fileFullPath = baseSavefilePath +  "\\" + video.getVideoName() +  "\\" + video.getVideoName()+".png";
			InputStream imageStream = new FileInputStream(fileFullPath);
			byte[] imageByteArray = IOUtils.toByteArray(imageStream);
			imageStream.close();
				
			recipeImg= Base64.encodeBase64String(imageByteArray);
			
			
		}
	
	}
	
	
	
	
	
	

	
	
	
}
