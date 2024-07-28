package com.lms.learning_management_system.DTO;


import java.util.List;
import java.util.UUID;

public class CourseDTO {
    private UUID id;
    private String title;
    private String description;
    private UUID teacherId;
    private List<UUID> studentIds;



    public CourseDTO() {}

    public CourseDTO(UUID id, String title, String description, UUID teacherId, List<UUID> studentIds) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.teacherId = teacherId;
        this.studentIds = studentIds;
    }

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

    public UUID getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(UUID teacherId) {
        this.teacherId = teacherId;
    }

    public List<UUID> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<UUID> studentIds) {
        this.studentIds = studentIds;
    }
}

