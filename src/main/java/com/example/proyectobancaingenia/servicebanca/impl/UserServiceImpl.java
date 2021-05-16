package com.example.proyectobancaingenia.servicebanca.impl;

import com.example.proyectobancaingenia.repositorybanca.UserRepository;
import com.example.proyectobancaingenia.servicebanca.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    // Inyección del repositorio userRepository
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean existeUserConId(Long id) {
        return userRepository.existsById(id);
    }
}
