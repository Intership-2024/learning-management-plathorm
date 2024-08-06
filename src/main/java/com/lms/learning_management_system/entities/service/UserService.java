package com.lms.learning_management_system.entities.service;

import com.lms.learning_management_system.dto.UserDTO;
import com.lms.learning_management_system.entities.RoleEntity;
import com.lms.learning_management_system.entities.UserEntity;
import com.lms.learning_management_system.exception.UserAlreadyExistsException;
import com.lms.learning_management_system.exception.UserNotFoundException;
import com.lms.learning_management_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private static final String userWithId = "User with Id";
    private static final String notFound = "Not found";

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList(); // Use Stream.toList() for an immutable list
    }

    public UserDTO getUserById(UUID id) {
        return userRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new UserNotFoundException(userWithId + " " + id + " " + notFound));
    }

    public UserDTO createUser(UserDTO userDTO) {
        Optional<UserEntity> existingUser = userRepository.findByEmail(userDTO.getEmail());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException(userWithId + " " + userDTO.getEmail() + " already exists");
        }
        UserEntity userEntity = new UserEntity();
        userEntity = convertToEntity(userEntity, userDTO);
        userEntity = userRepository.save(userEntity);
        return convertToDTO(userEntity);
    }

    public UserDTO updateUser(UUID id, UserDTO userDTO) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(userWithId + " " + id + " " + notFound));

        userEntity = convertToEntity(userEntity, userDTO);
        userEntity = userRepository.save(userEntity);
        return convertToDTO(userEntity);
    }

    public void deleteUser(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(userWithId + " " + id + " " + notFound);
        }
        userRepository.deleteById(id);
    }

    private UserDTO convertToDTO(UserEntity userEntity) {
        return new UserDTO(userEntity.getId(), userEntity.getFirstName(), userEntity.getLastName(),
                userEntity.getEmail(), userEntity.getRole().getRole().toString());
    }

    private UserEntity convertToEntity(UserEntity userEntity, UserDTO userDTO) {
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setEmail(userDTO.getEmail());

        RoleEntity roleEntity = userEntity.getRole();
        userEntity.setRole(roleEntity);

        return userEntity;
    }
}
