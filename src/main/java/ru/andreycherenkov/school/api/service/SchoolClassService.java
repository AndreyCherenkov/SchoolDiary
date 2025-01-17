package ru.andreycherenkov.school.api.service;

import org.springframework.http.ResponseEntity;
import ru.andreycherenkov.school.api.dto.CreateSchoolClassDto;
import ru.andreycherenkov.school.api.dto.SchoolClassResponseDto;
import ru.andreycherenkov.school.db.entity.SchoolClass;
import ru.andreycherenkov.school.db.entity.Student;

import java.util.List;
import java.util.UUID;

public interface SchoolClassService {

    List<SchoolClass> findAll();

    SchoolClass findById(UUID classId);

    ResponseEntity<SchoolClassResponseDto> createSchoolClass(CreateSchoolClassDto schoolClass);

    List<Student> findBySchoolClassId(UUID classId);

}
