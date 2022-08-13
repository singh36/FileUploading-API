package com.practice.FileUploading.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileServiceImpl implements FileService	{

	@Override
	public String uploadFile(String path, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		String name=file.getOriginalFilename();//file name
		String filePath=path + File.separator + name;    //full path
		  
		//create file if not created
		File f=new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		
		//copy file
		
		Files.copy(file.getInputStream(), Paths.get(filePath));
		return name;
	}

}
