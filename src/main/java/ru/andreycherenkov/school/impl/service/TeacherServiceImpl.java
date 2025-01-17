package ru.andreycherenkov.school.impl.service;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.andreycherenkov.school.api.dto.CreateTeacherDto;
import ru.andreycherenkov.school.api.service.TeacherService;
import ru.andreycherenkov.school.db.entity.Teacher;
import ru.andreycherenkov.school.db.repository.TeacherRepository;

import java.util.UUID;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    //todo добавить валидацию номера и почты
    @Override
    public ResponseEntity<Teacher> createTeacher(CreateTeacherDto createTeacherDto) {

        if (createTeacherDto.firstName.isEmpty() || createTeacherDto.lastName.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Teacher teacher = teacherRepository.save(
                Teacher.builder()
                        .firstName(createTeacherDto.firstName.trim())
                        .lastName(createTeacherDto.lastName.trim())
                        .email(createTeacherDto.email)
                        .phoneNumber(createTeacherDto.phoneNumber)
                        .build()
        );

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(teacher);
    }

    @Override
    public String findTeacherFullNameById(UUID teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(
                () -> new RuntimeException(String.format("Учитель c id %s  не найден", teacherId)));
        return String.format("%s %s", teacher.getFirstName(), teacher.getLastName());
    }
}
