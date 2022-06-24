package com.metanet.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.metanet.domain.Video;
import com.metanet.domain.DTO.VideoDTO;
import com.metanet.repository.VideoRepository;
import com.metanet.service.InfoService;

import io.swagger.annotations.ApiOperation;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;

@RestController
@RequestMapping("/Streaming")
public class StreamingController {

	
	@Autowired
	InfoService infoService;
	
	@Autowired
	VideoRepository	videoRepository;

	
	@Value("${file.path}")
	private String baseSavefilePath;
	
	@Value("${ffmpg.path}")
	private String ffmpgRealPath;
	
	
	@PostMapping("/upload")
	@CrossOrigin
	@ApiOperation(value="아이디 중복 확인",notes="회원가입시 아이디 중복여부 확인 / 중복시 -1, 중복 아닐시 1 반환")
	public String upload(
			@RequestParam("file")  MultipartFile  uploadFile,
			VideoDTO.addDetailRequest newDetail) throws Exception {
				
		
		// 파일 업로드 진행 
		String originalFileName = uploadFile.getOriginalFilename();
		String onlyFileName = originalFileName.substring(0, originalFileName.lastIndexOf("."));
		
		String saveDirPath = baseSavefilePath+onlyFileName; //영상 저장 디렉토리 
		String savefilePath = saveDirPath +"\\" +originalFileName; // 영상 파일 
				
		File saveDir = new File(saveDirPath);		
		if(!saveDir.exists()) 
		{
			saveDir.mkdir();

			newDetail.setVideoName(saveDirPath);
			infoService.saveDetail(newDetail);
	        
			File dest = new File(savefilePath);
			uploadFile.transferTo(dest);
			
			// ts 파일 생성  
			FFmpeg ffmpeg = new FFmpeg(ffmpgRealPath + "ffmpeg" );
			FFprobe ffprobe = new FFprobe(ffmpgRealPath + "ffprobe" );
				
			FFmpegBuilder builder = new FFmpegBuilder()
					.setInput(savefilePath)
					.addOutput(saveDirPath+"\\" +onlyFileName+ ".m3u8") // 썸네일 경로 
					.addExtraArgs("-profile:v", "baseline") // 
	    			.addExtraArgs("-level", "3.0") //
	    			.addExtraArgs("-start_number", "0") //
	    			.addExtraArgs("-hls_time", "10") //
	    			.addExtraArgs("-hls_list_size", "0") //
	    			.addExtraArgs("-f", "hls") //
	    			.done();
			FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
		    executor.createJob(builder).run();
					
	        // 이미지 파일 생성
	        FFmpegBuilder builderThumbNail = new FFmpegBuilder()
	    			.overrideOutputFiles(true) // 오버라이드 여부
	    			.setInput(savefilePath) // 동영상파일
	    			.addExtraArgs("-ss", "00:00:03") // 썸네일 추출 싲가점
	    			.addOutput( saveDirPath +"\\" + onlyFileName + ".png") // 썸네일 경로
	    			.setFrames(1) // 프레임 수
	    			.done();
	        FFmpegExecutor executorThumbNail = new FFmpegExecutor(ffmpeg, ffprobe);
	        executorThumbNail.createJob(builderThumbNail).run();
		
	        
	        //이미지 찾고 바이트 어래이 연동 
	        
	        
	        String fileFullPath =  saveDirPath +"\\" + onlyFileName + ".png";
	        InputStream imageStream = new FileInputStream(fileFullPath);
			
			byte[] imageByteArray = IOUtils.toByteArray(imageStream);
			imageStream.close();
			
			
	        
			return "완료";
		}
		
		return "실패";
	}
	
		
		
	@GetMapping(		
			value ="/getImageByte",
			produces = MediaType.IMAGE_JPEG_VALUE
			)
	@CrossOrigin
	@ApiOperation(value="이미지 받기",notes="비디오 넘버로 이미지 받기")
	public @ResponseBody byte[] getImage( @RequestParam("videoNumber")  int videoNumber )
			 throws IOException{
	
		// videoNumber를 통해  videoname을 찾는다.
	
		Video video = videoRepository.findByvideoNumber(videoNumber);
				
		String onlyFileName = video.getVideoName();
		
		int lastIdx = onlyFileName .lastIndexOf("\\");
		
		onlyFileName = onlyFileName.substring(lastIdx+1)+".png";
						
		String fileFullPath = video.getVideoName() +  "\\" + onlyFileName;
		
		InputStream imageStream = new FileInputStream(fileFullPath);
		
		byte[] imageByteArray = IOUtils.toByteArray(imageStream);
		imageStream.close();
		
		return imageByteArray;
	
		
	}
	

	
	
	@GetMapping("/getFileName")
	@CrossOrigin
	@ApiOperation(value="아이디 중복 확인",notes="회원가입시 아이디 중복여부 확인 / 중복시 -1, 중복 아닐시 1 반환")
	public String getFileName( @RequestParam("videoNumber")  int videoNumber)
	{
	
		Video video = videoRepository.findByvideoNumber(videoNumber);
		String onlyFileName = video.getVideoName();
		int lastIdx = onlyFileName .lastIndexOf("\\");
		onlyFileName = onlyFileName.substring(lastIdx+1);
		
		return onlyFileName ;
	}
	
	
	@GetMapping("/hls/{fileName}/{fileName}.m3u8")
	@CrossOrigin
	public ResponseEntity<Resource> videoHlsM3U8(@PathVariable String fileName)
	{
		
		String fileFullPath = baseSavefilePath + fileName + "\\" + fileName+ ".m3u8";
		Resource resource = new FileSystemResource(fileFullPath); 
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName + ".m3u8");
		headers.setContentType(MediaType.parseMediaType("application/vnd.apple.mpegurl"));
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);	
	}
	
	
	
	@GetMapping("/hls/{fileName}/{tsName}.ts")
	@CrossOrigin
	public ResponseEntity<Resource> videoHlsTs(@PathVariable String fileName, @PathVariable String tsName) 
	{
		String fileFullPath = baseSavefilePath + fileName + "/" + tsName + ".ts";
		Resource resource = new FileSystemResource(fileFullPath); 
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + tsName + ".ts");
		headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_OCTET_STREAM_VALUE));
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);

	}
	
	
	
	
	
	
	/*
	
	@GetMapping("/getM3U8")
	@CrossOrigin
	@ApiOperation(value="아이디 중복 확인",notes="회원가입시 아이디 중복여부 확인 / 중복시 -1, 중복 아닐시 1 반환")
	public ResponseEntity<Resource> getM3U8( @RequestParam("videoNumber")  int videoNumber)
	{
	
		Video video = videoRepository.findByvideoNumber(videoNumber);
		String onlyFileName = video.getVideoName();
		int lastIdx = onlyFileName .lastIndexOf("\\");
		onlyFileName = onlyFileName.substring(lastIdx+1)+".m3u8";
	
		String fileFullPath = video.getVideoName() +  "\\" + onlyFileName;
		Resource resource = new FileSystemResource(fileFullPath ); 
		
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + onlyFileName + ".m3u8");
		headers.setContentType(MediaType.parseMediaType("application/vnd.apple.mpegurl"));
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getTs")
	@CrossOrigin
	@ApiOperation(value="아이디 중복 확인",notes="회원가입시 아이디 중복여부 확인 / 중복시 -1, 중복 아닐시 1 반환")
	public ResponseEntity<Resource> getTs( 
			@RequestParam("videoNumber")  int videoNumber,
			@RequestParam("tsfileName")  String tsfileName
			)
	{
	
		Video video = videoRepository.findByvideoNumber(videoNumber);
	
		String fileFullPath = video.getVideoName() +  "\\" + tsfileName;
		Resource resource = new FileSystemResource(fileFullPath); 
		
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + tsfileName);
		headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_OCTET_STREAM_VALUE));
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);

	}
	
	
	
	
	*/
	
	
	
	
	
	
	
	
	
	
}
