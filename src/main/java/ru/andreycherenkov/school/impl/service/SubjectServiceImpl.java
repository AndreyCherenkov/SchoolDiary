package ru.andreycherenkov.school.impl.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.andreycherenkov.school.api.service.SubjectService;
import ru.andreycherenkov.school.db.entity.SchoolClass;
import ru.andreycherenkov.school.db.entity.SchoolSubject;
import ru.andreycherenkov.school.db.repository.SchoolClassRepository;
import ru.andreycherenkov.school.db.repository.SubjectRepository;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class SubjectServiceImpl implements SubjectService {

    private SchoolClassRepository schoolClassRepository;
    private SubjectRepository subjectRepository;

    @Override
    public List<SchoolSubject> findByClassId(UUID classId) {
        return subjectRepository.findSubjectsBySchoolClassClassId(classId);
    }

    @Override
    @Transactional
    public void addSubject(UUID classId, String subjectTitle) {
        SchoolClass schoolClass = schoolClassRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("Класс не найден")); //todo refactor

        SchoolSubject schoolSubject = new SchoolSubject();
        schoolSubject.setSchoolClass(schoolClass);
        schoolSubject.setTitle(subjectTitle);
        schoolClass.getSchoolSubjects().add(schoolSubject);

        subjectRepository.save(schoolSubject);
        schoolClassRepository.save(schoolClass);
    }

    @Override
    public SchoolSubject findSubjectById(UUID subjectId) {
        return subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Предмет не найден"));
    }
}
