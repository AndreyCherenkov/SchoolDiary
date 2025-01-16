package ru.andreycherenkov.school.impl.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.andreycherenkov.school.api.Pages;
import ru.andreycherenkov.school.api.controller.ScheduleController;
import ru.andreycherenkov.school.api.service.ScheduleService;
import ru.andreycherenkov.school.api.service.SchoolClassService;
import ru.andreycherenkov.school.api.service.SubjectService;

import java.util.UUID;

@AllArgsConstructor
@Controller
public class ScheduleControllerImpl implements ScheduleController {

    private ScheduleService scheduleService;
    private SchoolClassService schoolClassService;
    private SubjectService subjectService;

    @Override
    public String viewSchedule(UUID classId, Model model) {
        model.addAttribute("schoolClass", schoolClassService.findById(classId));
        model.addAttribute("scheduleList", scheduleService.getSchedule(classId));
        model.addAttribute("schoolSubjects", subjectService.findByClassId(classId));
        return Pages.VIEW_SCHEDULE_PAGE;
    }

    @Override
    public String addSchedule(UUID classId, int lessonNumber, String dayOfWeek, String subjectTitle) {
        scheduleService.addSchedule(classId, lessonNumber, dayOfWeek, subjectTitle);
        return "redirect:/schedules/" + classId;
    }

}

