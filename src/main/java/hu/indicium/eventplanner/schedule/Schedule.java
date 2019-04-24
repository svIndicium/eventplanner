package hu.indicium.eventplanner.schedule;

import hu.indicium.eventplanner.event.Event;
import hu.indicium.eventplanner.group.Group;
import hu.indicium.eventplanner.schedule.exceptions.EventAlreadyExistsException;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(generator = "schedule_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "schedule_id_seq", sequenceName = "schedule_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "schedule_url")
    private String scheduleUrl;

    @Column(name = "schedule_name")
    private String scheduleName;

    @Column(name = "schedule_desc")
    private String scheduleDescription;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Event> events = new HashSet<>();

    public Schedule() {
    }

    public Schedule(String scheduleUrl, Group group) {
        this.scheduleUrl = scheduleUrl;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScheduleUrl() {
        return scheduleUrl;
    }

    public void setScheduleUrl(String scheduleUrl) {
        this.scheduleUrl = scheduleUrl;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String getScheduleDescription() {
        return scheduleDescription;
    }

    public void setScheduleDescription(String scheduleDescription) {
        this.scheduleDescription = scheduleDescription;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public void addEvent(Event event) throws EventAlreadyExistsException {
        for (Event event1 : this.events) {
            if (event1.equals(event)) {
                throw new EventAlreadyExistsException(event.getSummary());
            }
        }
        this.events.add(event);
    }
}
