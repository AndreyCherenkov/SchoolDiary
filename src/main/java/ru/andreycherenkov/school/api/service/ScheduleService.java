package ru.andreycherenkov.school.api.service;

import org.springframework.web.bind.annotation.PathVariable;
import ru.andreycherenkov.school.db.entity.Schedule;

import java.util.List;
import java.util.UUID;

public interface ScheduleService {

    List<Schedule> getSchedule(@PathVariable UUID classId);

    String editSchedule(@PathVariable UUID scheduleId);

    void addSchedule(UUID classId, int lessonNumber, String dayOfWeek, String subject);

}
