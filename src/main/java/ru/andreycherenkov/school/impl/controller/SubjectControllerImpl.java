package ru.andreycherenkov.school.impl.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.andreycherenkov.school.api.Pages;
import ru.andreycherenkov.school.api.controller.SubjectController;
import ru.andreycherenkov.school.api.service.SchoolClassService;
import ru.andreycherenkov.school.api.service.SubjectService;

import java.util.UUID;

@AllArgsConstructor
@Controller
public class SubjectControllerImpl implements SubjectController {

    private SubjectService subjectService;
    private SchoolClassService schoolClassService;

    @Override
    public String getSubjects(UUID classId, Model model) {
        model.addAttribute("schoolClass", schoolClassService.findById(classId));
        model.addAttribute("subjectsList", subjectService.findByClassId(classId));
        return Pages.SUBJECTS_PAGE;
    }

    @Override
    public String addSubject(UUID classId, String subjectTitle) {
        subjectService.addSubject(classId, subjectTitle);
        return "redirect:/subjects/" + classId;
    }

}
