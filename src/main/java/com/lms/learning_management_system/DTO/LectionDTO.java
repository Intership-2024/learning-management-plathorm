package com.lms.learning_management_system.DTO;


import java.util.UUID;

public class LectionDTO {
    private UUID id;
    private String title;
    private String description;


    public LectionDTO() {}

    public LectionDTO(UUID id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
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
}
