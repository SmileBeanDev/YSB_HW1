package dev.smilebean.ysb_hw1.repository;

import dev.smilebean.ysb_hw1.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Event findByEventName(String eventName);
}
