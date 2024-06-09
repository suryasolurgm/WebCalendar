package webCalendarSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webCalendarSpring.dto.EventRequest;
import webCalendarSpring.models.Event;
import webCalendarSpring.repository.EventRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {

    private EventRepository eventRepository;
    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event saveEvent(EventRequest eventRequest) {
        Event event = new Event();
        event.setEvent(eventRequest.getEvent());
        event.setDate(eventRequest.getDate());
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> getTodayEvents() {
        return eventRepository.findByDate(LocalDate.now());
    }
    public Event getEventById(int id) {
        return eventRepository.findById(id);
    }
    public Event deleteEventById(int id) {
       return eventRepository.deleteById(id);
    }
    public List<Event> findByDateBetween(LocalDate start, LocalDate end) {
        return eventRepository.findByDateBetween(start, end);
    }
}
