package ru.andreycherenkov.school.api.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface AuthController {


    @GetMapping("/login")
    String login();


}
