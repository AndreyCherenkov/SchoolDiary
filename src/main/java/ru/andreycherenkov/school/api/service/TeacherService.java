package ru.andreycherenkov.school.api.service;

import org.springframework.http.ResponseEntity;
import ru.andreycherenkov.school.api.dto.CreateTeacherDto;
import ru.andreycherenkov.school.db.entity.Teacher;

import java.util.UUID;

public interface TeacherService {

    ResponseEntity<Teacher> createTeacher(CreateTeacherDto createTeacherDto);
    String findTeacherFullNameById(UUID teacherId);

}
