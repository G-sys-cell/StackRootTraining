package com.example.demo.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Domain.Event;
import com.example.demo.Repository.EventRepository;


@Service
public class EventService 
{
	@Autowired
    private EventRepository eventRepository;

	public  Event findById(String id)
	{
		Optional<Event> result = eventRepository.findById(id);
		Event event=result.get();
		return event;
	}

	public void addEvent(Event event) 
	{
		eventRepository.save(event);
		
	}

	public List<Event> getAllEvent() {
		return eventRepository.findAll();
	}

	public void deleteCountry(String id) {
		eventRepository.deleteById(id);
		
	}

	public void updateEvent(String id, String eventName) 
	{
		Event event = eventRepository.findById(id).orElse(null);
        if (event != null) 
        {
            event.setEventName(eventName);
            eventRepository.save(event);
		
	    }
	
	}
}
