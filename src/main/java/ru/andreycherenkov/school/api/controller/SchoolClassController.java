package ru.andreycherenkov.school.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.andreycherenkov.school.api.dto.CreateSchoolClassDto;
import ru.andreycherenkov.school.api.dto.SchoolClassResponseDto;


@RequestMapping("/classes")
public interface SchoolClassController {

    @GetMapping("/all")
    String getClasses(Model model);

    @PostMapping
    @ResponseBody
    ResponseEntity<SchoolClassResponseDto> createSchoolClass(@RequestBody CreateSchoolClassDto schoolClassDto);

}
