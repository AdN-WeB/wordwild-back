package com.checkpoint.worldwild.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploaderService {
//Dossier ou seront stocker les fichiers
	@Value("${worlwild.app.pictureLocation}")
	private String locationFile;
	
//Liste	des extensions autorisées pour les fichiers
	@Value("#{'${worlwild.app.allowedExtension}'.split(',')}")
	private List<String> allowedExtension;

//Fonction d'ajout de fichier
	public String uploadFile(MultipartFile file) throws IllegalStateException, IOException{
		Path root = Paths.get(locationFile);
		String extension = "";
		String fileName = file.getOriginalFilename();
		if(fileName != null) {
			int index = fileName.lastIndexOf('.');
			if(index > 0) {
				extension = fileName.substring(index + 1); 
			}
			if(!allowedExtension.contains(extension)) {
				throw new IOException("File format is not valid, please use JPEG, PNG, JPG or SVG format");
			}else {
				File fileToTransfert;
				do {
					fileName= UUID.randomUUID().toString().replace("-","") + "." + fileName.substring(index + 1);
					fileToTransfert = new File(locationFile + fileName);
				}
				while(fileToTransfert.exists());
				Files.copy(file.getInputStream(), root.resolve(fileName));
				return fileName;
			}
		}
		else throw new IOException("File not found");
	}
	
//Fonction de chargement d'un fichier pour le rendre visibe coté front
	public Resource loadFile(String fileName) throws IOException{
		Path root = Paths.get(locationFile);
		if(fileName != null) {
			Path file = root.resolve(fileName);
			Resource resource = new UrlResource(file.toUri());
			
			if(resource.exists()||resource.isReadable()) {
				return resource;
			}else {
				throw new IOException("File not here");
			}
		}else {
			throw new IOException("Give a name for the file you search");
		}
	}
	
//Fonction de suppression d'un fichier
	public void deleteFile(String fileName) throws IOException{
		String fileToDelete= locationFile + fileName;
		File existFile = new File(locationFile + fileName);
		Path path = FileSystems.getDefault().getPath(fileToDelete);
		if(existFile.exists()&&!existFile.isDirectory()) {
			Files.delete(path);
		}
	}
	
	
	

}
