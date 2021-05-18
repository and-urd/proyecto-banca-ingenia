package com.example.proyectobancaingenia.service.impl;

import com.example.proyectobancaingenia.model.Usuario;
import com.example.proyectobancaingenia.repository.UserRepository;
import com.example.proyectobancaingenia.service.UserService;
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

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        if(usuario.getId() == null){
            return userRepository.save(usuario);
        }else{
            return null;
        }
    }
}
