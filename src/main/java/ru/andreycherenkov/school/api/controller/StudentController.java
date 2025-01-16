package ru.andreycherenkov.school.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/students")
public interface StudentController {

    @GetMapping("/personal")
    String getPersonalPage();

}
