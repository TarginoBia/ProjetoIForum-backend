package com.projeto.IForum.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{

    private List<Usuario> usuarios = new ArrayList<>();

    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {
        return usuarios;
    }

    @PostMapping("/usuarios")
    public String addUsuario(@RequestBody Usuario usuario) {
        usuarios.add(usuario);
        return "Usuário inserido com sucesso";
    }

    @PutMapping("/usuarios/{id}")
    public String updateUsuario(@PathVariable int id, @RequestBody Usuario updatedUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                usuario.setName(updatedUsuario.getName());
                return "Usuário atualizado com sucesso";
            }
        }
        return "Usuário não encontrado!";
    }

    @DeleteMapping("/usuarios/{id}")
    public String deleteUsuario(@PathVariable int id) {
        usuarios.removeIf(usuario -> usuario.getId() == id);
        return "Usuário deletado com sucesso";
    }
}
