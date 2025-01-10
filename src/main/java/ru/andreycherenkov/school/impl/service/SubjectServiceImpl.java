package ru.andreycherenkov.school.impl.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.andreycherenkov.school.api.service.SubjectService;
import ru.andreycherenkov.school.db.entity.SchoolClass;
import ru.andreycherenkov.school.db.entity.Subject;
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
    public List<Subject> findByClassId(UUID classId) {
        return subjectRepository.findSubjectsBySchoolClassClassId(classId);
    }

    @Override
    @Transactional
    public void addSubject(UUID classId, String title) {
        SchoolClass schoolClass = schoolClassRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("Класс не найден")); //todo refactor

        Subject subject = new Subject();
        subject.setSchoolClass(schoolClass);
        subject.setTitle(title);
        schoolClass.getSubjects().add(subject);

        subjectRepository.save(subject);
        schoolClassRepository.save(schoolClass);
    }
}
