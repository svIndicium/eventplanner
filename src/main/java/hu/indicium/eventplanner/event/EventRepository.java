package hu.indicium.eventplanner.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    boolean existsBySummaryAndStartDateAndEndDateAndScheduleId(String summary, Date startDate, Date endDate, Long scheduleId);
}
