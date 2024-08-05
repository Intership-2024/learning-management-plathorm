package com.lms.learning_management_system.entities;

public enum RoleEnum {
    ADMIN,
    STUDENT,
    TEACHER;

    public static RoleEnum fromString(String role) {
        for (RoleEnum r : RoleEnum.values()) {
            if (r.name().equalsIgnoreCase(role)) {
                return r;
            }
        }
        throw new IllegalArgumentException("No enum constant for role: " + role);
    }
}

