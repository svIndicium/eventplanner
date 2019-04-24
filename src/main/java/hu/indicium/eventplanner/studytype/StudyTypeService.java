package hu.indicium.eventplanner.studytype;

import hu.indicium.eventplanner.studytype.exceptions.NameEmptyException;
import hu.indicium.eventplanner.studytype.exceptions.ShortNameEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyTypeService implements StudyTypeServiceInterface {

    private final StudyTypeRepository studyTypeRepository;

    @Autowired
    public StudyTypeService(StudyTypeRepository studyTypeRepository) {
        this.studyTypeRepository = studyTypeRepository;
    }

    @Override
    public List<StudyType> getAllStudyTypes() {
        return studyTypeRepository.findAll();
    }

    @Override
    public StudyType addStudyType(StudyType studyType) {
        if (studyType.getShortName() == null || studyType.getShortName().isEmpty()) {
            throw new ShortNameEmptyException();
        }
        if (studyType.getName() == null || studyType.getName().isEmpty()) {
            throw new NameEmptyException();
        }
        return studyTypeRepository.save(studyType);
    }
}
