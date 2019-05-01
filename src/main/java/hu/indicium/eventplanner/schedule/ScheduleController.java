package hu.indicium.eventplanner.schedule;

import hu.indicium.eventplanner.schedule.dto.ScheduleDTO;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {
    private final ScheduleServiceInterface scheduleService;

    private final ModelMapper modelMapper;

    public ScheduleController(ScheduleServiceInterface scheduleService, ModelMapper modelMapper) {
        this.scheduleService = scheduleService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/schedules/{id}")
    public ScheduleDTO getSchedule(@PathVariable Long id) {
        return this.convertToDTO(scheduleService.getScheduleById(id));
    }

    private ScheduleDTO convertToDTO(Schedule schedule) {
        return modelMapper.map(schedule, ScheduleDTO.class);
    }
}
