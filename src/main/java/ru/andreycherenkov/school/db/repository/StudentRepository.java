package ru.andreycherenkov.school.db.repository;

import org.springframework.data.repository.CrudRepository;
import ru.andreycherenkov.school.db.entity.Student;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

    @Query("SELECT s FROM Student s WHERE s.schoolClass.classId = :classId")
    List<Student> findBySchoolClassId(@Param("classId") UUID classId);
}

