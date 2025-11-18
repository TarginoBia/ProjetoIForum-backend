package com.projeto.IForum.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.IForum.dto.DenunciaDTO;

@RestController
@RequestMapping("/denuncias")
public class DenunciaController {

    @PostMapping
    public ResponseEntity<DenunciaDTO> registrarDenuncia(@RequestBody DenunciaDTO denunciaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(denunciaDTO); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<DenunciaDTO> buscarDenuncia(@PathVariable Long id) {
        return ResponseEntity.ok(new DenunciaDTO()); 
    }

    @GetMapping
    public ResponseEntity<List<DenunciaDTO>> listarDenuncias() {
        return ResponseEntity.ok(Collections.emptyList()); 
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<DenunciaDTO> atualizarStatus(@PathVariable Long id, @RequestParam String novoStatus) {
        return ResponseEntity.ok(new DenunciaDTO());
    }
}
