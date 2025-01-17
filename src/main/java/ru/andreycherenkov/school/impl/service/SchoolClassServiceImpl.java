package ru.andreycherenkov.school.impl.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.andreycherenkov.school.api.dto.CreateSchoolClassDto;
import ru.andreycherenkov.school.api.dto.SchoolClassResponseDto;
import ru.andreycherenkov.school.api.service.SchoolClassService;
import ru.andreycherenkov.school.db.entity.SchoolClass;
import ru.andreycherenkov.school.db.entity.Student;
import ru.andreycherenkov.school.db.entity.Teacher;
import ru.andreycherenkov.school.db.repository.SchoolClassRepository;
import ru.andreycherenkov.school.db.repository.StudentRepository;
import ru.andreycherenkov.school.db.repository.TeacherRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SchoolClassServiceImpl implements SchoolClassService {

    private SchoolClassRepository schoolClassRepository;
    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;

    @Override
    public List<SchoolClass> findAll() {
        return schoolClassRepository.findAllByOrderByClassGradeAscClassCharacterAsc();
    }

    @Override
    public SchoolClass findById(UUID classId) {
        return schoolClassRepository.findById(classId).orElseThrow(
                (() -> new RuntimeException(String.format("Класс с id %s не найден", classId))));
    }

    @Override
    @Transactional
    public ResponseEntity<SchoolClassResponseDto> createSchoolClass(CreateSchoolClassDto schoolClassDto) {
        Teacher teacher = teacherRepository.findById(schoolClassDto.getClassTeacherId())
                .orElseThrow(() -> new EntityNotFoundException("Teacher not found"));

        SchoolClass newClass = new SchoolClass();
        newClass.setClassGrade(schoolClassDto.getClassGrade());
        newClass.setClassCharacter(schoolClassDto.getClassCharacter());
        newClass.setSpecialization(schoolClassDto.getSpecialization());
        newClass.setClassTeacher(teacher);

        schoolClassRepository.save(newClass);

        teacher.getClasses().add(newClass);
        teacherRepository.save(teacher);

        SchoolClassResponseDto responseDto = SchoolClassResponseDto.builder()
                .classGrade(newClass.getClassGrade())
                .classCharacter(newClass.getClassCharacter())
                .specialization(newClass.getSpecialization())
                .teacherFullName(String.format("%s %s", teacher.getFirstName(), teacher.getLastName()))
                .build();

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseDto);
    }

    @Override
    public List<Student> findBySchoolClassId(UUID classId) {
        return studentRepository.findBySchoolClassId(classId); //todo вынести в сервис студентов
    }
}
