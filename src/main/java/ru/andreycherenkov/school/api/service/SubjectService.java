package ru.andreycherenkov.school.api.service;

import ru.andreycherenkov.school.db.entity.SchoolSubject;

import java.util.List;
import java.util.UUID;

public interface SubjectService {

    List<SchoolSubject> findByClassId(UUID classId);
    void addSubject(UUID classId, String subjectTitle);
    SchoolSubject findSubjectById(UUID subjectId);

}
