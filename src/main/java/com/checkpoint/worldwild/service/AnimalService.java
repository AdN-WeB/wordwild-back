package com.checkpoint.worldwild.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.checkpoint.worldwild.dto.AnimalDto;
import com.checkpoint.worldwild.entity.Animal;
import com.checkpoint.worldwild.repository.AnimalRepository;

@Service
public class AnimalService {
	
	@Autowired
	AnimalRepository animalRepository;
	
	@Autowired
	FileUploaderService fileUploaderService;
	
	public List<Animal> findAll(){
		return animalRepository.findAll();
	}
	
	public Animal getOne(Long id) {
		Optional<Animal> optAnimal = animalRepository.findById(id);
		if(optAnimal.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return optAnimal.get();
	}
	
	public Animal create(AnimalDto animalDto, MultipartFile file) throws IllegalStateException,IOException{
		String img = fileUploaderService.uploadFile(file);
		Animal animal = new Animal();
		animal.setImageUrl(img);
		animal.setName(animalDto.getName());
		animal.setRace(animalDto.getRace());
		animal.setSize(animalDto.getSize());
		animal.setWeight(animalDto.getWeight());
		animal.setLife(animalDto.getLife());
		animal.setFeed(animalDto.getFeed());
		animal.setWikiLink(animalDto.getWikiLink());
		return animalRepository.save(animal);
	}
	
	public Animal update(Long id, AnimalDto animalDto, MultipartFile file) throws IOException{
		Optional<Animal> optAnimal = animalRepository.findById(id);
		if(optAnimal.isPresent()) {
			if(file!=null) {
				Animal animal = optAnimal.get();
				fileUploaderService.deleteFile(animal.getImageUrl());
				String img = fileUploaderService.uploadFile(file);
				animal.setImageUrl(img);
				animal.setName(animalDto.getName());
				animal.setRace(animalDto.getRace());
				animal.setSize(animalDto.getSize());
				animal.setWeight(animalDto.getWeight());
				animal.setLife(animalDto.getLife());
				animal.setFeed(animalDto.getFeed());
				animal.setWikiLink(animalDto.getWikiLink());
				return animalRepository.save(animal);
			}else {
				Animal animal =optAnimal.get();
				animal.setName(animalDto.getName());
				animal.setRace(animalDto.getRace());
				animal.setSize(animalDto.getSize());
				animal.setWeight(animalDto.getWeight());
				animal.setLife(animalDto.getLife());
				animal.setFeed(animalDto.getFeed());
				animal.setWikiLink(animalDto.getWikiLink());
				return animalRepository.save(animal);
			}
		}else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	public void delete(Long id) throws IOException{
		Optional<Animal> optAnimal= animalRepository.findById(id);
		if(optAnimal.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		Animal animal = optAnimal.get();
		fileUploaderService.deleteFile(animal.getImageUrl());
		animalRepository.deleteById(id);
	}
	
	
	
	
	

}
