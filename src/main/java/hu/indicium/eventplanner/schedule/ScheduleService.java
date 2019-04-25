package hu.indicium.eventplanner.schedule;

import net.fortuna.ical4j.data.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ScheduleService implements ScheduleServiceInterface {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleService.class);

    private final ScheduleRepository scheduleRepository;

    private final ScheduleParserInterface scheduleParser;

    public ScheduleService(ScheduleRepository scheduleRepository, ScheduleParserInterface scheduleParser) {
        this.scheduleRepository = scheduleRepository;
        this.scheduleParser = scheduleParser;
    }

    @Override
    public List<Schedule> getSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    @Scheduled(cron = "0 0 12 ? * MON")
    public void updateSchedules() {
        logger.info("Started updating schedules");
        for (Schedule schedule : this.getSchedules()) {
            try {
                scheduleRepository.save(scheduleParser.updateSchedule(schedule));
            } catch (IOException | ParserException e) {
                e.printStackTrace();
            }
        }
    }
}
