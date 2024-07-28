package com.lms.learning_management_system.DTO;


import java.util.List;
import java.util.UUID;

public class ModuleDTO {
    private UUID id;
    private String title;
    private String description;
    private List<UUID> lectionIds;


    public ModuleDTO() {}

    public ModuleDTO(UUID id, String title, String description, List<UUID> lectionIds) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.lectionIds = lectionIds;
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

    public List<UUID> getLectionIds() {
        return lectionIds;
    }

    public void setLectionIds(List<UUID> lectionIds) {
        this.lectionIds = lectionIds;
    }
}

