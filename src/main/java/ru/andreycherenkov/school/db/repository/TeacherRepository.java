package ru.andreycherenkov.school.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.andreycherenkov.school.db.entity.Teacher;

import java.util.Optional;
import java.util.UUID;

public interface TeacherRepository extends JpaRepository<Teacher, UUID> {

    @Query("SELECT t FROM Teacher t LEFT JOIN t.classes c WHERE t.employeeId = :teacherId AND c IS NULL")
    Optional<Teacher> findTeacherWithoutClassesById(@Param("teacherId") UUID teacherId);

}
