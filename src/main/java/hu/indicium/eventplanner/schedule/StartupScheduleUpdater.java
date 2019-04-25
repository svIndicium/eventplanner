package hu.indicium.eventplanner.schedule;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupScheduleUpdater implements CommandLineRunner {
    private final ScheduleServiceInterface scheduleService;

    public StartupScheduleUpdater(ScheduleServiceInterface scheduleService) {
        this.scheduleService = scheduleService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.scheduleService.updateSchedules();
    }
}
