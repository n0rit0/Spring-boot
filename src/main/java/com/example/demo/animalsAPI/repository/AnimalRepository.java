package com.example.demo.animalsAPI.repository;
 
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.animalsAPI.data.AnimalData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
 
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
	    String response = restTemplate.getForObject(url, String.class); // JSON文字列で取得
 
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        List<AnimalData> animals = objectMapper.readValue(response, new TypeReference<List<AnimalData>>() {});
	        if (!animals.isEmpty()) {
	            return animals.get(0);
	        } else {
	            throw new RuntimeException("No data found for id: " + id);
	        }
	    } catch (Exception e) {
	        throw new RuntimeException("Error parsing response", e);
	    }
	}
 
}
 