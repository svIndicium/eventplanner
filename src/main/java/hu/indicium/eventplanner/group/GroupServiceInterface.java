package hu.indicium.eventplanner.group;

import java.util.List;

public interface GroupServiceInterface {
    List<Group> getGroups();

    List<Group> getGroupsByStudyType(Long studyTypeId);
}
