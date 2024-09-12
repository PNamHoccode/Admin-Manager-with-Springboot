package com.project.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.Resource;

public interface StorageService {
	 void init();

	    void store(MultipartFile file);

	  
}
