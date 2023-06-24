package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Domain.Event;
import com.example.demo.Service.EventService;



@RestController
@RequestMapping("/event")
public class EventController 
{
	@Autowired
	EventService eventService;
	
	@PostMapping("/event")
	public Event createEvent(@RequestBody Event event) 
	{
		eventService.addEvent(event);
		return event;		
	}
	
	@GetMapping("/events") 
	public List<Event> getAllEvent() {
		
	List<Event> event= eventService.getAllEvent();
	return event;		
		
	}
	
	@GetMapping("/event/{id}") 
	public Event getCountry(@PathVariable String id) 
	{
		
		Event event=eventService.findById(id);	
		return event;
	}
	@DeleteMapping("/event/{id}")
	public ResponseEntity<Event> deleteEvent(@PathVariable String id) {
		eventService.deleteCountry(id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		}
	@PutMapping("/event/{id}") 
	public Event updateEvent(@PathVariable String id,@RequestBody Event event ) {
	
		eventService.updateEvent(id,event.getEventName()) ;
				
		return event;
		}
}
