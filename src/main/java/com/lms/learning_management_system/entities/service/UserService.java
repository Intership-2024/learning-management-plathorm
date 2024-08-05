package com.lms.learning_management_system.entities.service;


import com.lms.learning_management_system.entities.RoleEntity;
import com.lms.learning_management_system.entities.RoleEnum;
import com.lms.learning_management_system.entities.UserEntity;
import com.lms.learning_management_system.DTO.UserDTO;
import com.lms.learning_management_system.exception.UserNotFoundException;
import com.lms.learning_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(UUID id) {
        return userRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
    }

    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = convertToEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        return convertToDTO(userEntity);
    }

    public UserDTO updateUser(UUID id, UserDTO userDTO) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));

        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setEmail(userDTO.getEmail());
        // Assuming role mapping is handled elsewhere
        // userEntity.setRole(userDTO.getRole());

        userEntity = userRepository.save(userEntity);
        return convertToDTO(userEntity);
    }

    public void deleteUser(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User with id " + id + " not found");
        }
        userRepository.deleteById(id);
    }

    private UserDTO convertToDTO(UserEntity userEntity) {
        return new UserDTO(userEntity.getId(), userEntity.getFirstName(), userEntity.getLastName(),
                userEntity.getEmail(), userEntity.getRole().getRole().toString());
    }

    private UserEntity convertToEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        RoleEntity roleEntity = new RoleEntity();
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setEmail(userDTO.getEmail());
        roleEntity.setRole(userDTO.getRole());
        userEntity.setRole(roleEntity);
        return userEntity;
    }
}