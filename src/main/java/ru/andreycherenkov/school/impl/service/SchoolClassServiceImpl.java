package ru.andreycherenkov.school.impl.service;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.andreycherenkov.school.api.dto.SchoolClassResponseDto;
import ru.andreycherenkov.school.api.service.SchoolClassService;
import ru.andreycherenkov.school.db.entity.SchoolClass;
import ru.andreycherenkov.school.db.entity.Teacher;
import ru.andreycherenkov.school.db.repository.SchoolClassRepository;
import ru.andreycherenkov.school.db.repository.TeacherRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SchoolClassServiceImpl implements SchoolClassService {

    private SchoolClassRepository schoolClassRepository;
    private TeacherRepository teacherRepository;

    @Override
    public List<SchoolClass> findAll() {
        return schoolClassRepository.findAllByOrderByClassGradeAscClassCharacterAsc();
    }

    @Override
    public SchoolClass findById(UUID uuid) {
        return schoolClassRepository.findById(uuid).orElse(null);
    }

    @Override
    @Transactional
    public ResponseEntity<SchoolClassResponseDto> createSchoolClass(SchoolClass schoolClass) {
        Teacher teacher = teacherRepository.findById(schoolClass.getClassTeacher().getEmployeeId()).get(); //todo refactor
        schoolClass.setClassTeacher(teacher);
        SchoolClass newClass = schoolClassRepository.save(schoolClass);
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

}
