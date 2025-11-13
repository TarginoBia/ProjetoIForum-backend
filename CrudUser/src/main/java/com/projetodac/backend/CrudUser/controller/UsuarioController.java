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

public abstract class UsuarioController<D, I> {

    @GetMapping
    public ResponseEntity<List<D>> findAll() {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> findById(@PathVariable Long id) {
        return ResponseEntity.notFound().build(); 
    }
    
    @PostMapping
    public ResponseEntity<D> create(@Valid @RequestBody D dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dto); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> update(@PathVariable Long id, @Valid @RequestBody D dto) {
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}