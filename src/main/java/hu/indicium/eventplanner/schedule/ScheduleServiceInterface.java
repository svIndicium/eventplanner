package hu.indicium.eventplanner.schedule;

import java.util.List;

public interface ScheduleServiceInterface {
    List<Schedule> getSchedules();

    void updateSchedules();
}
