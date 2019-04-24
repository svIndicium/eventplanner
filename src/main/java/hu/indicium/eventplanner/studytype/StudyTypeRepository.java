package hu.indicium.eventplanner.studytype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyTypeRepository extends JpaRepository<StudyType, Long> {
}
