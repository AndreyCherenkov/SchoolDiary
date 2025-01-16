package ru.andreycherenkov.school.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.andreycherenkov.school.db.entity.enums.Specialization;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "school_classes")
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID classId;

    private int classGrade;

    private String classCharacter;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @ManyToOne
    private Teacher classTeacher;

    @OneToMany(mappedBy = "schoolClass")
    private List<Student> students;

    @OneToMany(mappedBy = "schoolClass")
    private List<Schedule> schedules;

    @OneToMany(mappedBy = "schoolClass")
    private List<SchoolSubject> schoolSubjects;

}
