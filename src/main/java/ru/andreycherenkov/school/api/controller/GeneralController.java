package ru.andreycherenkov.school.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public interface GeneralController {

    @GetMapping
    String getIndex();

}
