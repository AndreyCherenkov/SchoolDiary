package ru.andreycherenkov.school.impl.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.andreycherenkov.school.api.service.ScheduleService;
import ru.andreycherenkov.school.db.entity.Schedule;
import ru.andreycherenkov.school.db.entity.SchoolClass;
import ru.andreycherenkov.school.db.entity.SchoolSubject;
import ru.andreycherenkov.school.db.repository.ScheduleRepository;
import ru.andreycherenkov.school.db.repository.SchoolClassRepository;
import ru.andreycherenkov.school.db.repository.SubjectRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private ScheduleRepository scheduleRepository;
    private SchoolClassRepository schoolClassRepository;
    private SubjectRepository subjectRepository;

    @Override
    public List<Schedule> getSchedule(UUID classId) {
        return scheduleRepository.findScheduleBySchoolClassClassId(classId);
    }

    @Override
    public String editSchedule(UUID scheduleId) {
        return "";
    }

    @Override
    @Transactional
    public void addSchedule(UUID classId, int lessonNumber, String dayOfWeek, String subjectTitle) {
        SchoolClass schoolClass = schoolClassRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("Класс не найден"));

        SchoolSubject schoolSubject = subjectRepository.findByTitle(subjectTitle)
                .orElseThrow(() -> new RuntimeException("Предмет не найден"));

        Schedule schedule = new Schedule();
        schedule.setSchoolClass(schoolClass);
        schedule.setLessonNumber(lessonNumber);
        schedule.setDayOfWeek(dayOfWeek);
        schedule.setSchoolSubject(schoolSubject);
        schoolClass.getSchedules().add(schedule);

        scheduleRepository.save(schedule);
        schoolClassRepository.save(schoolClass);
    }

}
