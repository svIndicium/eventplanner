package hu.indicium.eventplanner.event;

import hu.indicium.eventplanner.schedule.Schedule;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(generator = "event_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "event_id_seq", sequenceName = "event_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "location")
    private String location;

    @Column(name = "summary")
    private String summary;

    @Column(name = "description", length = 10233)
    private String description;

    @Column(name = "startDateTime")
    private Date startDate;

    @Column(name = "endDateTime")
    private Date endDate;

    @ManyToOne()
    @JoinColumn(name = "calendar_id")
    private Schedule schedule;

    public Event() {
    }

    public Event(String location, String summary, String description, Date startDate, Date endDate, Schedule schedule) {
        this.location = location;
        this.summary = summary;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.schedule = schedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(summary, event.summary) &&
                Objects.equals(startDate.getTime(), event.startDate.getTime()) &&
                Objects.equals(endDate.getTime(), event.endDate.getTime());
    }
}
