package ru.andreycherenkov.school.impl.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.andreycherenkov.school.api.controller.TeacherController;
import ru.andreycherenkov.school.api.dto.CreateTeacherDto;
import ru.andreycherenkov.school.api.service.TeacherService;
import ru.andreycherenkov.school.db.entity.Teacher;

@AllArgsConstructor
@RestController
public class TeacherControllerImpl implements TeacherController {

    private TeacherService teacherService;

    @Override
    public ResponseEntity<Teacher> createTeacher(CreateTeacherDto createTeacherDto) {
        return teacherService.createTeacher(createTeacherDto);
    }

}
