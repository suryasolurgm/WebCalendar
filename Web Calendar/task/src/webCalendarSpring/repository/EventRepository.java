package webCalendarSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webCalendarSpring.models.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByDate(LocalDate date);
    Event findById(int id);
    Event deleteById(int id);
    List<Event> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
