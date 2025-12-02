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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.IForum.dto.UsuarioDTO;
import com.projeto.IForum.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController{

    private UsuarioService usuarioService;
    
    public void UsuarioService(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(new UsuarioDTO()); 
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        return ResponseEntity.ok(Collections.emptyList()); 
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable Long id, @RequestParam String novoUsuario) {
        return ResponseEntity.ok(new UsuarioDTO());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable("id") Long id){
        usuarioService.deletarUsuario(id); 
        
        return ResponseEntity.noContent().build();
    }
}
