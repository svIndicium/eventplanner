package hu.indicium.eventplanner.group.dto;

import hu.indicium.eventplanner.studytype.dto.StudyTypeDTO;

public class GroupDTO {
    private Long id;

    private String name;

    private Long size;

    private StudyTypeDTO studyType;

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

    public StudyTypeDTO getStudyType() {
        return studyType;
    }

    public void setStudyType(StudyTypeDTO studyType) {
        this.studyType = studyType;
    }
}
