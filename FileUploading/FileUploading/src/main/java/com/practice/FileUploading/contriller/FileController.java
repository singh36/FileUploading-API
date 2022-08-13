package com.practice.FileUploading.contriller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.practice.FileUploading.payload.FileResponse;

import com.practice.FileUploading.service.FileService;

@RestController
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	FileService service;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/upload")
	public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image){
		
		String fileName;
		try {
			fileName = this.service.uploadFile(path, image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity(new FileResponse(null,"Not uploaded"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity(new FileResponse(fileName,"Successfully uploaded"),HttpStatus.OK);
	}
	
}
