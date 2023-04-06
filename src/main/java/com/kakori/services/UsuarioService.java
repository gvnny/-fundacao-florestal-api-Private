package com.kakori.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakori.models.UsuarioModel;
import com.kakori.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public List<UsuarioModel> listAllUser() {
        return usuarioRepository.findAll();
    }

    public void saveUser(UsuarioModel usuario) {
    	usuarioRepository.save(usuario);
    }

    public UsuarioModel getUsuario(Integer id) {
        return usuarioRepository.findById(id).get();
    }

    public void deleteUsuario(Integer id) {
    	usuarioRepository.deleteById(id);
    }
}