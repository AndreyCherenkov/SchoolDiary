package ru.andreycherenkov.school.impl.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.andreycherenkov.school.api.Pages;
import ru.andreycherenkov.school.api.controller.SchoolClassController;
import ru.andreycherenkov.school.api.dto.SchoolClassResponseDto;
import ru.andreycherenkov.school.api.service.SchoolClassService;
import ru.andreycherenkov.school.api.service.SubjectService;
import ru.andreycherenkov.school.db.entity.SchoolClass;

@Controller
@AllArgsConstructor
public class SchoolClassControllerImpl implements SchoolClassController {

    private SchoolClassService schoolClassService;

    @Override
    public String getClasses(Model model) {
        model.addAttribute("schoolClasses", schoolClassService.findAll());
        return Pages.CLASSES_PAGE;
    }

    @Override
    public ResponseEntity<SchoolClassResponseDto> createSchoolClass(SchoolClass schoolClass) {
        return schoolClassService.createSchoolClass(schoolClass);
    }
}
