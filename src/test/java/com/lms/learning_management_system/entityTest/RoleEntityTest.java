package com.lms.learning_management_system.entityTest;

import com.lms.learning_management_system.entities.RoleEntity;
import com.lms.learning_management_system.entities.RoleEnum;
import com.lms.learning_management_system.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RoleEntityTest {

    @Autowired
    private RoleRepository roleRepository; // Assuming you have a repository for RoleEntity

    RoleEntityTest(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Test
    @Transactional
    void testRoleEntityWithArgumentsConstructor() {
        UUID id = UUID.randomUUID();
        RoleEntity roleEntity = new RoleEntity(id, RoleEnum.ADMIN);

        RoleEntity savedRoleEntity = roleRepository.save(roleEntity);

        assertNotNull(savedRoleEntity.getId()); // Ensure ID is not null after save
        assertEquals(id, savedRoleEntity.getId()); // Check that the ID is as expected
        assertEquals(RoleEnum.ADMIN, savedRoleEntity.getRole()); // Verify the role
    }

    @Test
    @Transactional
    void testRoleEntityNoArgsConstructor() {
        RoleEntity roleEntity = new RoleEntity();

        assertNull(roleEntity.getId()); // Verify that ID is null before saving
        assertNull(roleEntity.getRole()); // Verify that role is null before saving
    }

    @Test
    @Transactional
    void testRoleEntitySaveGeneratesId() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRole(RoleEnum.STUDENT);

        RoleEntity savedRoleEntity = roleRepository.save(roleEntity);

        assertNotNull(savedRoleEntity.getId()); // Ensure ID is generated and not null
        assertEquals(RoleEnum.STUDENT, savedRoleEntity.getRole()); // Verify the role after save
    }

    @Test
    @Transactional
    void testRoleEntityRoleSetterGetter() {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRole(RoleEnum.TEACHER);

        assertEquals(RoleEnum.TEACHER, roleEntity.getRole()); // Verify that the setter correctly sets the role
    }
}
