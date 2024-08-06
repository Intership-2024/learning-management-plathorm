package com.lms.learning_management_system.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RoleEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private RoleEnum role;


    public RoleEntity(UUID id, RoleEnum role) {
        this.id = id;
        this.role = role;
    }
}
