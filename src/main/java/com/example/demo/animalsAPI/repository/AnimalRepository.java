package com.example.demo.animalsAPI.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.animalsAPI.data.AnimalData;

@Repository
public class AnimalRepository {

	private final String BASE_URL = "https://wsaz0e6z45.execute-api.ap-northeast-1.amazonaws.com/prod/animalsAPI";
	private final RestTemplate restTemplate = new RestTemplate();

	public List<AnimalData> findAll() {
		AnimalData[] animals = restTemplate.getForObject(BASE_URL, AnimalData[].class);
		return Arrays.asList(animals);
	}

	public AnimalData findById(int id) {
		String url = BASE_URL + "?id=" + id;
		return restTemplate.getForObject(url, AnimalData.class);
	}

}
