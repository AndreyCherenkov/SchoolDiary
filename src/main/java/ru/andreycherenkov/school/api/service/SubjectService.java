package ru.andreycherenkov.school.api.service;

import ru.andreycherenkov.school.db.entity.Subject;

import java.util.List;
import java.util.UUID;

public interface SubjectService {

    List<Subject> findByClassId(UUID classId);
    void addSubject(UUID classId, String title);

}
