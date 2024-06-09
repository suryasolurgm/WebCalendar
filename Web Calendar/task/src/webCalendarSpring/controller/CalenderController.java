package webCalendarSpring.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webCalendarSpring.dto.ErrorMessage;
import webCalendarSpring.dto.ResponseMessage;
import webCalendarSpring.dto.EventRequest;
import webCalendarSpring.models.Event;
import webCalendarSpring.service.EventService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CalenderController {
    @Autowired
    private EventService eventService;

    @PostMapping("/event")
    public ResponseEntity<Object> addEvent(@Valid @RequestBody EventRequest eventRequest) {
        Event event = eventService.saveEvent(eventRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(
                "The event has been added!",
                eventRequest.getEvent(),
                eventRequest.getDate().toString()
        ));
    }
//    @GetMapping("/event")
//    public ResponseEntity<?> getAllEvents() {
//        List<Event> events = eventService.getAllEvents();
//        if (events.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
//        }
//        return ResponseEntity.ok().body(events);
//    }
    @GetMapping("/event")
    public ResponseEntity<?> getAllEvents(@RequestParam(value = "start_time", required = false) String startTimeStr,
                                          @RequestParam(value = "end_time", required = false) String endTimeStr) {
        List<Event> events;
        if (startTimeStr != null && endTimeStr != null) {
            LocalDate startDate = LocalDate.parse(startTimeStr);
            LocalDate endDate = LocalDate.parse(endTimeStr);
            events = eventService.findByDateBetween(startDate, endDate);
        } else {
            events = eventService.getAllEvents();
        }
        if (events.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.ok(events);
    }
    @GetMapping("/event/today")
    public ResponseEntity<?> getTodayEvents() {
        List<Event> events = eventService.getTodayEvents();
//        if (events.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
//        }
        return ResponseEntity.ok(events);
    }
    @GetMapping("/event/{id}")
    public ResponseEntity<?> getEventById(@PathVariable("id") int id) {
        Event event = eventService.getEventById(id);
        if (event == null) {
            ErrorMessage errorMessage = new ErrorMessage("The event doesn't exist!");
            return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(event, HttpStatus.OK);
    }
    @DeleteMapping("/event/{id}")
    public ResponseEntity<?> deleteEventById(@PathVariable("id") int id) {
        Event event = eventService.getEventById(id);
        //Event eventToDelete = eventService.deleteEventById(id);
        if (event == null) {
            ErrorMessage errorMessage = new ErrorMessage("The event doesn't exist!");
            return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
        }
        eventService.deleteEventById(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }
}
