package com.projetodac.backend.CrudUser.controller;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projetodac.backend.CrudUser.dto.DenunciaDTO;
import com.projetodac.backend.CrudUser.service.DenunciaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/denuncias")
public class DenunciaController{

    private final DenunciaService service;
    
    @Autowired
    public DenunciaController(DenunciaService denunciaService) {
        this.service = denunciaService;
    }

    @GetMapping
    public List<DenunciaDTO> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DenunciaDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<DenunciaDTO> create(@Valid @RequestBody DenunciaDTO dto) {
        var created = service.create(dto);
        return ResponseEntity
                .created(URI.create("/api/denuncias/" + created.getId())) // Correção aqui!
                .body(created);
    }

    @PutMapping("/{id}")
    public DenunciaDTO update(@PathVariable Long id, @Valid @RequestBody DenunciaDTO dto) {
        return service.atualizarStatus(id, dto.getStatus());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
