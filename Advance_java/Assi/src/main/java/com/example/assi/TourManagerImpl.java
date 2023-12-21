package com.example.assi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourManagerImpl implements TourManager{

	@Autowired
	TourRepository repository;
	@Override
	public void addTour(Tour t) {
		// TODO Auto-generated method stub
		repository.save(t);
		
	}

	@Override
	public List<Tour> getTour() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void update(Tour Tour, int id) {
		// TODO Auto-generated method stub
		repository.update(Tour.getType(), Tour.getLocation(), Tour.getCost(), Tour.getNo_of_days(), id);
	}

	@Override
	public Optional<Tour> getTour(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
		}

	@Override
	public List<Tour> getSelected(String type) {
		// TODO Auto-generated method stub
		return repository.listtype(type);
	}

}
