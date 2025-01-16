package ru.andreycherenkov.school.api.dto;

import lombok.Getter;
import ru.andreycherenkov.school.db.entity.enums.Specialization;

import java.util.UUID;

@Getter
public class CreateSchoolClassDto {

    private int classGrade;
    private String classCharacter;
    private Specialization specialization;
    private UUID classTeacherId;

}
