package hu.indicium.eventplanner.group;

import hu.indicium.eventplanner.schedule.Schedule;
import hu.indicium.eventplanner.studytype.StudyType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(generator = "group_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "group_id_seq", sequenceName = "group_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "size")
    private Long size = 0L;

    @ManyToOne
    @JoinColumn(name = "study_type")
    private StudyType studyType;

    @OneToMany(mappedBy = "group")
    private Set<Schedule> schedules = new HashSet<>();

    public Group() {
    }

    public Group(String name, Long size, StudyType studyType) {
        this.name = name;
        this.size = size;
        this.studyType = studyType;
    }

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

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public StudyType getStudyType() {
        return studyType;
    }

    public void setStudyType(StudyType studyType) {
        this.studyType = studyType;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    public void addCalendar(Schedule schedule) {
        this.schedules.add(schedule);
    }
}
