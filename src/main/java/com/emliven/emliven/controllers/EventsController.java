package com.emliven.emliven.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emliven.emliven.entities.Events;
import com.emliven.emliven.requests.EventsCreateRequest;
import com.emliven.emliven.requests.EventsUpdateRequest;
import com.emliven.emliven.services.EventsService;

@RestController
@RequestMapping("/events")
public class EventsController {
	
	private EventsService eventsService;

	public EventsController(EventsService eventsService) {
		this.eventsService = eventsService;
	}
	
	
	@GetMapping
	public List<Events> getAllEvents(@RequestParam Optional<Long> userId){
		return eventsService.getAllEvents(userId);
	}
	
	@PostMapping
	public Events createOneEvent(@RequestBody EventsCreateRequest newEventsRequest) {
		return eventsService.createOneEvent(newEventsRequest);
	}
	
	@GetMapping("/{eventsId}")
	public Events getOneEvent(@PathVariable long eventsId) {
		return eventsService.getOneEventById(eventsId);
	}
		
	@PutMapping("/{eventsId}")
	public Events updateOneEvent(@PathVariable long eventsId,@RequestBody EventsUpdateRequest updateEvents) {
		return eventsService.updateOneEventById(eventsId,updateEvents);
	}
	@DeleteMapping("/{eventsId}")
	public void deleteOneEvent(@PathVariable Long eventsId) {
		eventsService.deleteOneEventById(eventsId);
		
	}
	
	

}
