package hu.indicium.eventplanner.calendar;

import hu.indicium.eventplanner.group.Group;

import javax.persistence.*;

@Entity
@Table(name = "calendar")
public class Calendar {
    @Id
    @GeneratedValue(generator = "group_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "group_id_seq", sequenceName = "group_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "schedule_url")
    private String scheduleUrl;

    @Column(name = "calendar_name")
    private String calendarName;

    @Column(name = "calendar_desc")
    private String calendarDescription;

    @ManyToOne
    @JoinColumn(name = "group")
    private Group group;

    public Calendar() {
    }

    public Calendar(String scheduleUrl, Group group) {
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

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public String getCalendarDescription() {
        return calendarDescription;
    }

    public void setCalendarDescription(String calendarDescription) {
        this.calendarDescription = calendarDescription;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
