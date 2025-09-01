package com.projetodac.backend.CrudUser.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projetodac.backend.CrudUser.dto.FuncionarioDTO;
import com.projetodac.backend.CrudUser.service.FuncionarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/funcionarios")
@CrossOrigin(origins = "http://localhost:5173") 
public class FuncionarioController{

    private final FuncionarioService service;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.service = funcionarioService;
    }

    @GetMapping
    public List<FuncionarioDTO> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public FuncionarioDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> create(@Valid @RequestBody FuncionarioDTO dto) {
        var created = service.create(dto);
        return ResponseEntity
                .created(URI.create("/api/funcionarios/" + created.getId()))
                .body(created);
    }

    @PutMapping("/{id}")
    public FuncionarioDTO update(@PathVariable Long id, @Valid @RequestBody FuncionarioDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
