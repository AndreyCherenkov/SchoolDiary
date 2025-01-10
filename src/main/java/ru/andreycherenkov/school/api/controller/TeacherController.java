package ru.andreycherenkov.school.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.andreycherenkov.school.api.dto.CreateTeacherDto;
import ru.andreycherenkov.school.db.entity.Teacher;

@RequestMapping("/api/v1/teachers")
public interface TeacherController {

    @PostMapping
    ResponseEntity<Teacher> createTeacher(@RequestBody CreateTeacherDto createTeacherDto);

}
