package com.project.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileSystemStorageService implements StorageService {
	private final Path rootlocation ;
	public FileSystemStorageService() {
		this.rootlocation= Paths.get("src/main/resources/static/uploads");
	}
	

	@Override
	public void store(MultipartFile file) {
		try {
			
			Path destinationFile = this.rootlocation.resolve(
					Paths.get(file.getOriginalFilename()))
					.normalize().toAbsolutePath();
		
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, destinationFile,
					StandardCopyOption.REPLACE_EXISTING);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void init() {
		try {
			Files.createDirectories(rootlocation);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
