package ru.andreycherenkov.school.api.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/subjects")
public interface SubjectController {

    @GetMapping("/{classId}")
    String getSubjects(@PathVariable UUID classId, Model model);

    @PostMapping("/add")
    String addSubject(@RequestParam UUID classId,
                      @RequestParam String subjectTitle);

    @GetMapping("/{subjectId}/marks")
    String getMarks(@PathVariable UUID subjectId,
                    UUID teacherID,
                    UUID classId,
                    Model model);

}
