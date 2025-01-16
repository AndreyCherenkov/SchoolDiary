package ru.andreycherenkov.school.impl.controller;

import org.springframework.stereotype.Controller;
import ru.andreycherenkov.school.api.Pages;
import ru.andreycherenkov.school.api.controller.StudentController;

@Controller
public class StudentControllerImpl implements StudentController {

    @Override
    public String getPersonalPage() {
        return Pages.PERSONAL_PAGE;
    }
}
