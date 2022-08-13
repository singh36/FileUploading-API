package com.practice.FileUploading.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service	
public interface FileService {
	
	public String uploadFile(String path,MultipartFile file) throws IOException;
	
}
