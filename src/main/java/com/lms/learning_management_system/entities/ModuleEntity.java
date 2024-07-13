package com.lms.learning_management_system.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
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


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public List<LectionEntity> getLections() {
        return lections;
    }

    public void setLections(List<LectionEntity> lections) {
        this.lections = lections;
    }
}