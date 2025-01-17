package ru.andreycherenkov.school.impl.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.andreycherenkov.school.api.Pages;
import ru.andreycherenkov.school.api.controller.SubjectController;
import ru.andreycherenkov.school.api.service.SchoolClassService;
import ru.andreycherenkov.school.api.service.SubjectService;
import ru.andreycherenkov.school.api.service.TeacherService;

import java.util.UUID;

@AllArgsConstructor
@Controller
public class SubjectControllerImpl implements SubjectController {

    private SubjectService subjectService;
    private SchoolClassService schoolClassService;
    private TeacherService teacherService;

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

    @Override
    public String getMarks(UUID subjectId,
                           UUID teacherId,
                           UUID classId,
                           Model model) {
        model.addAttribute("subject", subjectService.findSubjectById(subjectId));
        model.addAttribute("teacherFullName", teacherService.findTeacherFullNameById(teacherId));
        model.addAttribute("students", schoolClassService.findBySchoolClassId(classId));
        model.addAttribute("schoolClass", schoolClassService.findById(classId));
        return Pages.MARKS_PAGE;
    }
}
