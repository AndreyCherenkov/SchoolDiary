package ru.andreycherenkov.school.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andreycherenkov.school.db.entity.Schedule;

import java.util.List;
import java.util.UUID;

public interface ScheduleRepository extends JpaRepository<Schedule, UUID> {

    List<Schedule> findScheduleBySchoolClassClassId(UUID classId);

}
