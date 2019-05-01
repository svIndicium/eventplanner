package hu.indicium.eventplanner.schedule;

import java.util.List;

public interface ScheduleServiceInterface {
    List<Schedule> getSchedules();

    Schedule getScheduleById(Long id);

    void updateSchedules();
}
