package com.lms.learning_management_system.DTOTest;

import com.lms.learning_management_system.DTO.LectionDTO;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class LectionDTOTest {

    @Test
    void testLectionDTO() {
        UUID id = UUID.randomUUID();
        String title = "Lection Title";
        String description = "Lection Description";

        LectionDTO lectionDTO = new LectionDTO(id, title, description);

        assertEquals(id, lectionDTO.getId());
        assertEquals(title, lectionDTO.getTitle());
        assertEquals(description, lectionDTO.getDescription());
    }
}
