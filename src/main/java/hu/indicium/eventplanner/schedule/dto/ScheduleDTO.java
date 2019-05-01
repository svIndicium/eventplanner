package hu.indicium.eventplanner.schedule.dto;

import hu.indicium.eventplanner.event.dto.EventDTO;
import hu.indicium.eventplanner.group.dto.GroupDTO;

import java.util.List;

public class ScheduleDTO {
    private Long id;

    private String name;

    private String description;

    private GroupDTO group;

    private List<EventDTO> events;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GroupDTO getGroup() {
        return group;
    }

    public void setGroup(GroupDTO group) {
        this.group = group;
    }

    public List<EventDTO> getEvents() {
        return events;
    }

    public void setEvents(List<EventDTO> events) {
        this.events = events;
    }
}
