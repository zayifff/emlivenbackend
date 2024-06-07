package com.emliven.emliven.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.emliven.emliven.entities.Events;
import com.emliven.emliven.entities.User;
import com.emliven.emliven.repos.EventsRepository;
import com.emliven.emliven.requests.EventsCreateRequest;
import com.emliven.emliven.requests.EventsUpdateRequest;

@Service
public class EventsService {
	
	private EventsRepository eventsRepository;
	private UserService userService;
	public EventsService(EventsRepository eventsRepository,UserService userService) {
		this.eventsRepository = eventsRepository;
		this.userService = userService;
	}
	
	public List<Events> getAllEvents(Optional<Long> userId){
		if(userId.isPresent()) 
			return eventsRepository.findByUserId(userId.get());
		return eventsRepository.findAll();
	}

	public Events getOneEventById(Long eventsId) {
		return eventsRepository.findById(eventsId).orElse(null);
	}

	public Events createOneEvent(EventsCreateRequest newEventsRequest) {
		User user = userService.getOneUser(newEventsRequest.getUserId());
		if(user==null)
			return null;
		Events toSave = new Events();
		toSave.setId(newEventsRequest.getId());
		toSave.setText(newEventsRequest.getText());
		toSave.setTitle(newEventsRequest.getTitle());
		toSave.setType(newEventsRequest.getType());
		toSave.setPrice(newEventsRequest.getPrice());
		toSave.setUser(user);
		return eventsRepository.save(toSave);
	}

	public void deleteOneEventById(Long eventsId) {
		eventsRepository.deleteById(eventsId);
		
	}

	public Events updateOneEventById(long eventsId, EventsUpdateRequest updateEvents) {
	    Optional<Events> events = eventsRepository.findById(eventsId);
	    if(events.isPresent()) {
	        Events toUpdate = events.get();
	        toUpdate.setText(updateEvents.getText());
	        toUpdate.setTitle(updateEvents.getTitle());
	        toUpdate.setType(updateEvents.getType());
	        toUpdate.setPrice(updateEvents.getPrice());
	        eventsRepository.save(toUpdate);
	        return toUpdate;
	    }
	    return null;
	}


	
}
