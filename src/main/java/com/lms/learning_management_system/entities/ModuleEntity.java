package com.lms.learning_management_system.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class ModuleEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String description;

    @ManyToOne
    private CourseEntity course;

    @OneToMany(mappedBy = "module")
    private List<LectionEntity> lections;
}
