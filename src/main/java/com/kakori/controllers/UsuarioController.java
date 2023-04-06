package com.kakori.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kakori.models.UsuarioModel;
import com.kakori.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("")
    public List<UsuarioModel> list() {
        return usuarioService.listAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> get(@PathVariable Integer id) {
        try {
            UsuarioModel usuario = usuarioService.getUsuario(id);
            return new ResponseEntity<UsuarioModel>(usuario, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<UsuarioModel>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody UsuarioModel usuario) {
    	usuarioService.saveUser(usuario);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody UsuarioModel usuario, @PathVariable Integer id) {
        try {
            UsuarioModel existUsuario = usuarioService.getUsuario(id);
            usuario.setID_USUARIO(id);            
            usuarioService.saveUser(usuario);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

    	usuarioService.deleteUsuario(id);
    }
}