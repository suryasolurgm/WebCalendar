package webCalendarSpring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public class EventRequest {

    @NotNull
    @NotBlank
    private String event;

    @NotNull
    private LocalDate date;
    public EventRequest() {}
    public EventRequest(String event, LocalDate date) {
        this.event = event;
        this.date = date;
    }
    // Getters and setters
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}