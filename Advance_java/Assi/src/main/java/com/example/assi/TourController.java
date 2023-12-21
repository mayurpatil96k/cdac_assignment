package com.example.assi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class TourController {

	@Autowired
	TourManager manager;
	@GetMapping(value = "api/tours")
	public List<Tour> getMethodName() {
		return manager.getTour();
	}
	
	@GetMapping(value = "api/tourbyid/{id}")
	public Optional<Tour> gettourbyid(@PathVariable int id){
		return manager.getTour(id);	
	}
	
	@GetMapping(value = "api/tourbytype/{type}")
	public List<Tour> gettourbytype(@PathVariable String type){
		return manager.getSelected(type);
	}
	
	@DeleteMapping(value = "api/delete/{id}")
	public void removepro(@PathVariable int id) {
		manager.delete(id);
	}
	
	@PutMapping(value = "api/add/{id}")
	public void putMethodName(@PathVariable int id, @RequestBody Tour entity) {
		//TODO: process PUT request
		manager.update(entity, id);
	}
	
	@PostMapping(value = "api/tours")
	public void postMethodName(@RequestBody Tour entity) {
		//TODO: process POST request
		manager.addTour(entity);
	}
	
}
