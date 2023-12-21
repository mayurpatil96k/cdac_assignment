package com.example.assi;

import java.util.List;
import java.util.Optional;

public interface TourManager {
	void addTour(Tour t);
	List<Tour> getTour();
	void delete(int id);
	void update(Tour Tour,int id);
	Optional<Tour> getTour(int id);
	List<Tour> getSelected(String type);

}
