package ru.andreycherenkov.school.impl.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.andreycherenkov.school.api.Pages;
import ru.andreycherenkov.school.api.controller.ScheduleController;
import ru.andreycherenkov.school.api.service.ScheduleService;
import ru.andreycherenkov.school.api.service.SchoolClassService;

import java.util.UUID;

@AllArgsConstructor
@Controller
public class ScheduleControllerImpl implements ScheduleController {

    private ScheduleService scheduleService;
    private SchoolClassService schoolClassService;

    @Override
    public String viewSchedule(UUID classId, Model model) {
        model.addAttribute("schoolClass", schoolClassService.findById(classId));
        model.addAttribute("scheduleList", scheduleService.getSchedule(classId));
        return Pages.VIEW_SCHEDULE_PAGE;
    }

    @Override
    public String addSchedule(UUID classId, int lessonNumber, String dayOfWeek, String subject) {
        scheduleService.addSchedule(classId, lessonNumber, dayOfWeek, subject);
        return "redirect:/schedules/" + classId;
    }

}

