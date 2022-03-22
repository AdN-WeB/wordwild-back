package com.checkpoint.worldwild.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.checkpoint.worldwild.service.FileUploaderService;

@RestController
@CrossOrigin(origins="*", maxAge = 3600)
@RequestMapping("/worldwild/file")
public class FileController {

	@Autowired
	FileUploaderService fileUploaderService;
	
	@GetMapping("/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable(required=true)String filename)throws IOException{
		Resource file = fileUploaderService.loadFile(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + file.getFilename() + "\"").body(file);
	}
	
}
