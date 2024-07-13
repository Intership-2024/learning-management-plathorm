package com.lms.learning_management_system.entities.service;

import com.lms.learning_management_system.entities.UserEntity;
import com.lms.learning_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    public Optional<UserEntity> getUser(UUID id) {
        return userRepository.findById(id);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity updateUser(UUID id, UserEntity userDetails) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(userDetails.getFirstName());
                    user.setLastName(userDetails.getLastName());
                    user.setEmail(userDetails.getEmail());
                    user.setPassword(userDetails.getPassword());
                    user.setRole(userDetails.getRole());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    userDetails.setId(id);
                    return userRepository.save(userDetails);
                });
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
