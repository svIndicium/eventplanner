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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
