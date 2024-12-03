package ru.andreycherenkov.school.db.repository;

import org.springframework.data.repository.CrudRepository;
import ru.andreycherenkov.school.db.entity.Student;

import java.util.UUID;

public interface StudentRepository extends CrudRepository<Student, UUID> {
}
