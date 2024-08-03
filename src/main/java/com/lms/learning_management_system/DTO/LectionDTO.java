package com.lms.learning_management_system.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LectionDTO {
    private UUID id;
    private String title;
    private String description;
    private UUID moduleId;
}
