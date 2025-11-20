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

import com.projeto.IForum.dto.AlunoDTO;

@RestController
@RequestMapping("/alunos")
public class AlunoController{

    @PostMapping
    public ResponseEntity<AlunoDTO> registrarAluno(@RequestBody AlunoDTO alunoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoDTO); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> buscarAluno(@PathVariable Long id) {
        return ResponseEntity.ok(new AlunoDTO()); 
    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> listarAlunos() {
        return ResponseEntity.ok(Collections.emptyList()); 
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<AlunoDTO> atualizarAluno(@PathVariable Long id, @RequestParam String novoAluno) {
        return ResponseEntity.ok(new AlunoDTO());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlunoDTO> deleteAluno(@PathVariable("id") Long id){
        return ResponseEntity.ok("Aluno deletado com sucesso!.");
    }
}
