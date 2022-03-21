package com.checkpoint.worldwild.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.checkpoint.worldwild.dto.AnimalDto;
import com.checkpoint.worldwild.entity.Animal;
import com.checkpoint.worldwild.service.AnimalService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("/worldwild/animals")
public class AnimalController {

	@Autowired
	AnimalService animalService;
	
	@GetMapping
	public List<Animal> findAll(){
		return animalService.findAll();
	}
	
	@GetMapping("/{id}")
	public Animal getOne(@PathVariable(required=true) Long id) {
		return animalService.getOne(id);
	}
	
	@PostMapping(consumes= {"multipart/form-data"})
	public Animal create(@Valid @ModelAttribute AnimalDto animalDto, @RequestParam MultipartFile file)
	throws IllegalStateException,IOException{
		return animalService.create(animalDto, file);
	}
	
	@PutMapping(consumes= {"multipart/form-data"}, path= "/{id}")
	public Animal update(@Valid @ModelAttribute AnimalDto animalDto, @RequestParam(required=false) MultipartFile file, @PathVariable(required= true ) Long id) throws IOException{
		return animalService.update(id, animalDto, file);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) Long id) throws IOException{
		animalService.delete(id);
	}
}
