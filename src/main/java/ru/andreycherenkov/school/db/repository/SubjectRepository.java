package ru.andreycherenkov.school.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andreycherenkov.school.db.entity.SchoolSubject;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubjectRepository extends JpaRepository<SchoolSubject, UUID> {

    List<SchoolSubject> findSubjectsBySchoolClassClassId(UUID classId);

    Optional<SchoolSubject> findByTitle(String name);

}
