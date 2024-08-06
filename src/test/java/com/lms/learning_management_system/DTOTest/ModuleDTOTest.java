package com.lms.learning_management_system.DTOTest;

import com.lms.learning_management_system.DTO.ModuleDTO;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class ModuleDTOTest {

    @Test
    void testModuleDTO() {
        UUID id = UUID.randomUUID();
        String title = "Module Title";
        String description = "Module Description";
        List<UUID> lectionIds = List.of(UUID.randomUUID(), UUID.randomUUID());

        ModuleDTO moduleDTO = new ModuleDTO(id, title, description, lectionIds);

        assertEquals(id, moduleDTO.getId());
        assertEquals(title, moduleDTO.getTitle());
        assertEquals(description, moduleDTO.getDescription());
        assertEquals(lectionIds, moduleDTO.getLectionIds());
    }
}
