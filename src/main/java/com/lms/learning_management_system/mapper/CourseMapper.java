package com.lms.learning_management_system.mapper;


import com.lms.learning_management_system.DTO.CourseDTO;
import com.lms.learning_management_system.entities.CourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDTO toDTO(CourseEntity course);

    CourseEntity toEntity(CourseDTO courseDTO);
}

