package ru.andreycherenkov.school.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andreycherenkov.school.db.entity.Subject;

import java.util.List;
import java.util.UUID;

public interface SubjectRepository extends JpaRepository<Subject, UUID> {

    List<Subject> findSubjectsBySchoolClassClassId(UUID classId);

}
