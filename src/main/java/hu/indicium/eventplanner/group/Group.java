package hu.indicium.eventplanner.group;

public class Group {
    private String name;

    private String scheduleICalUrl;

    private StudyType studyType;

    public Group(String name, String scheduleICalUrl, StudyType studyType) {
        this.name = name;
        this.scheduleICalUrl = scheduleICalUrl;
        this.studyType = studyType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScheduleICalUrl() {
        return scheduleICalUrl;
    }

    public void setScheduleICalUrl(String scheduleICalUrl) {
        this.scheduleICalUrl = scheduleICalUrl;
    }

    public StudyType getStudyType() {
        return studyType;
    }

    public void setStudyType(StudyType studyType) {
        this.studyType = studyType;
    }
}
