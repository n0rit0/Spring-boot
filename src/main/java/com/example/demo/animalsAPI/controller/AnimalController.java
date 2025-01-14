package com.example.demo.animalsAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.animalsAPI.data.AnimalData;
import com.example.demo.animalsAPI.service.AnimalService;

@Controller
public class AnimalController {
	

	@Autowired
	private AnimalService animalService;

	@GetMapping("/search")
	public String searchPage(Model model) {
		List<AnimalData> animals = animalService.getAllAnimals();
		model.addAttribute("animals", animals);
		return "animal-search";
	}

	@GetMapping("/detail")
	public String detailPage(@RequestParam("id") int id, Model model) {
		AnimalData animal = animalService.getAnimalById(id);
		model.addAttribute("animal", animal);
		return "animal-detail";
	}
}