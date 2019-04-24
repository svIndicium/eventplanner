package hu.indicium.eventplanner.schedule;

import net.fortuna.ical4j.data.ParserException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ScheduleService implements ScheduleServiceInterface {

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
    public void updateSchedules() {
        for (Schedule schedule : this.getSchedules()) {
            try {
                scheduleRepository.save(scheduleParser.updateSchedule(schedule));
            } catch (IOException | ParserException e) {
                e.printStackTrace();
            }
        }
    }
}
