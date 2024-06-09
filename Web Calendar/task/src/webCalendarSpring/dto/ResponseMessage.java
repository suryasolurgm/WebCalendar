package webCalendarSpring.dto;

public class ResponseMessage {
    private String message;
    private String event;
    private String date;

    public ResponseMessage(String message, String event, String date) {
        this.message = message;
        this.event = event;
        this.date = date;
    }

    // Getters
    public String getMessage() {
        return message;
    }

    public String getEvent() {
        return event;
    }

    public String getDate() {
        return date;
    }
}
