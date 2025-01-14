package com.example.demo.animalsAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.animalsAPI.data.AnimalData;
import com.example.demo.animalsAPI.repository.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository animalRepository;

	public List<AnimalData> getAllAnimals() {
		return animalRepository.findAll();
	}

	public AnimalData getAnimalById(int id) {
		return animalRepository.findById(id);
	}
}
