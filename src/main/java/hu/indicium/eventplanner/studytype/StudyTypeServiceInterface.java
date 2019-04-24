package hu.indicium.eventplanner.studytype;

import java.util.List;

public interface StudyTypeServiceInterface {
    List<StudyType> getAllStudyTypes();

    StudyType addStudyType(StudyType studyType);
}
