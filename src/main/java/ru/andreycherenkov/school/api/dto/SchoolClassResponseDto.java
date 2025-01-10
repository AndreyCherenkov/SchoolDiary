package ru.andreycherenkov.school.api.dto;

import lombok.Builder;
import ru.andreycherenkov.school.db.entity.enums.Specialization;

@Builder
public class SchoolClassResponseDto {

    private int classGrade;

    private String classCharacter;

    private Specialization specialization;

    private String teacherFullName;

}
