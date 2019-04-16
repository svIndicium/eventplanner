package hu.indicium.eventplanner.group;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "study_type")
public class StudyType {
    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "studyType")
    private List<Group> groups;

    public StudyType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
