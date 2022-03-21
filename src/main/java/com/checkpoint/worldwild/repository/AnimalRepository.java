package com.checkpoint.worldwild.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.checkpoint.worldwild.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
