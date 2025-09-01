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

import com.projetodac.backend.CrudUser.dto.CoordenadorDTO;
import com.projetodac.backend.CrudUser.service.CoordenadorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/coordenadores")
@CrossOrigin(origins = "http://localhost:5173") 
public class CoordenadorController {
    
    private final CoordenadorService service;

    @Autowired
    public CoordenadorController(CoordenadorService coordenadorService) {
        this.service = coordenadorService;
    }

    @GetMapping
    public List<CoordenadorDTO> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CoordenadorDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<CoordenadorDTO> create(@Valid @RequestBody CoordenadorDTO dto) {
        var created = service.create(dto);
        return ResponseEntity
                .created(URI.create("/api/coordenadores/" + created.getId())) // Correção aqui!
                .body(created);
    }

    @PutMapping("/{id}")
    public CoordenadorDTO update(@PathVariable Long id, @Valid @RequestBody CoordenadorDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
    
}
