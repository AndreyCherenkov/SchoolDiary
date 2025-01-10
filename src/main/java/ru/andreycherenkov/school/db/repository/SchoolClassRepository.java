package ru.andreycherenkov.school.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andreycherenkov.school.db.entity.SchoolClass;

import java.util.List;
import java.util.UUID;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, UUID> {

    List<SchoolClass> findAllByOrderByClassGradeAscClassCharacterAsc();

}
