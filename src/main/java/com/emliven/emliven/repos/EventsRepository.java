package com.emliven.emliven.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emliven.emliven.entities.Events;

public interface EventsRepository extends JpaRepository<Events, Long> {
	
	List<Events> findByUserId(Long userId);

}
