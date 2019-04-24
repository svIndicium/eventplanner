package hu.indicium.eventplanner.group;

import hu.indicium.eventplanner.studytype.StudyType;

import javax.persistence.*;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(generator = "group_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "group_id_seq", sequenceName = "group_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "schedule_url")
    private String scheduleUrl;

    @ManyToOne
    @JoinColumn(name = "study_type")
    private StudyType studyType;

    public Group() {
    }

    public Group(String name, String scheduleUrl, StudyType studyType) {
        this.name = name;
        this.scheduleUrl = scheduleUrl;
        this.studyType = studyType;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScheduleUrl() {
        return scheduleUrl;
    }

    public void setScheduleUrl(String scheduleUrl) {
        this.scheduleUrl = scheduleUrl;
    }

    public StudyType getStudyType() {
        return studyType;
    }

    public void setStudyType(StudyType studyType) {
        this.studyType = studyType;
    }
}
