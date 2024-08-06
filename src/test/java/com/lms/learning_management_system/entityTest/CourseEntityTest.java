package com.lms.learning_management_system.entityTest;

import com.lms.learning_management_system.entities.CourseEntity;
import com.lms.learning_management_system.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CourseEntityTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    @Transactional
    void testCourseEntity() {
        CourseEntity course = new CourseEntity();
        course.setTitle("Course Title");
        course.setDescription("Course Description");

        CourseEntity savedCourse = courseRepository.save(course);

        assertNotNull(savedCourse.getId());
        assertEquals("Course Title", savedCourse.getTitle());
        assertEquals("Course Description", savedCourse.getDescription());
    }
}
