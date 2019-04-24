package hu.indicium.eventplanner.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements GroupServiceInterface {
    private GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    @Override
    public List<Group> getGroupsByStudyType(Long studyTypeId) {
        return groupRepository.findAllByStudyTypeId(studyTypeId);
    }
}
