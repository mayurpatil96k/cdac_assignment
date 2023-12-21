package com.example.assi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TourRepository extends JpaRepository<Tour,Integer>{

	@Modifying
	@Transactional
	@Query("Update Tour t set t.type= :type,t.location= :location,t.cost= :cost,t.no_of_days= :no_of_days where t.id= :id")
	void update(@Param("type") String type,@Param("location") String location,@Param("cost") Double cost,@Param("no_of_days") int no_of_days,@Param("id") int id);
	
	@Query("From Tour t where t.type= :type")
	List<Tour> listtype(@Param("type") String type);
}
