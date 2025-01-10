package ru.andreycherenkov.school.api.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/schedules")
public interface ScheduleController {

    @GetMapping("/{classId}")
    String viewSchedule(@PathVariable UUID classId, Model model);

    @PostMapping("/add")
    String addSchedule(@RequestParam UUID classId,
                              @RequestParam int lessonNumber,
                              @RequestParam String dayOfWeek,
                              @RequestParam String subject);

}
