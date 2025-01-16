package ru.andreycherenkov.school.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.andreycherenkov.school.db.entity.User;

public interface AuthController {


    @GetMapping("/login")
    String login();

    @GetMapping("/register")
    String registration();

    @PostMapping("/register")
    String registerUser(User user);

}
