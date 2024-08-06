package com.lms.learning_management_system.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDTO {
    private UUID id;
    private String title;
    private String description;
    private UUID courseId;
    private List<UUID> lectionIds;
}
