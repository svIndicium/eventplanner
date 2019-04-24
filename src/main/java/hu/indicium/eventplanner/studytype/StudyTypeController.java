package hu.indicium.eventplanner.studytype;

import hu.indicium.eventplanner.studytype.dto.NewStudyTypeDTO;
import hu.indicium.eventplanner.studytype.dto.StudyTypeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudyTypeController {
    private final StudyTypeServiceInterface studyTypeService;

    private final ModelMapper modelMapper;

    @Autowired
    public StudyTypeController(StudyTypeServiceInterface studyTypeService, ModelMapper modelMapper) {
        this.studyTypeService = studyTypeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/types")
    public List<StudyTypeDTO> getAllTypes() {
        return this.studyTypeService.getAllStudyTypes()
                .stream()
                .map(this::toStudyTypeDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/types")
    public StudyTypeDTO addNewType(@RequestBody NewStudyTypeDTO studyTypeDTO) {
        StudyType studyType = this.toStudyType(studyTypeDTO);
        return this.toStudyTypeDTO(studyTypeService.addStudyType(studyType));
    }

    private StudyTypeDTO toStudyTypeDTO(StudyType studyType) {
        return this.modelMapper.map(studyType, StudyTypeDTO.class);
    }

    private StudyType toStudyType(NewStudyTypeDTO studyTypeDTO) {
        return this.modelMapper.map(studyTypeDTO, StudyType.class);
    }
}
