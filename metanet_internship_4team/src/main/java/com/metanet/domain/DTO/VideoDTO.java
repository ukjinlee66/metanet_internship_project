package com.metanet.domain.DTO;

import com.metanet.domain.Video;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class VideoDTO {

	
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
	
	
	
	
	
	
	
	

	
	
	
}
