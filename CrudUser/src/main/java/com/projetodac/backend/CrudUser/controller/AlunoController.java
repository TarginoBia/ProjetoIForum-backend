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

import com.projetodac.backend.CrudUser.dto.AlunoDTO; // Importe o DTO do Aluno
import com.projetodac.backend.CrudUser.service.AlunoService; // Importe o Serviço do Aluno

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/alunos") // Mude o caminho base da URL para "alunos"
@CrossOrigin(origins = "http://localhost:5173")
public class AlunoController {

    private final AlunoService service; // Use o serviço do Aluno

    @Autowired
    public AlunoController(AlunoService alunoService) { // Injete o serviço do Aluno
        this.service = alunoService;
    }

    @GetMapping
    public List<AlunoDTO> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public AlunoDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> create(@Valid @RequestBody AlunoDTO dto) {
        var created = service.create(dto);
        return ResponseEntity
                .created(URI.create("/api/alunos/" + created.getMatricula()))
                .body(created);
    }

    @PutMapping("/{id}")
    public AlunoDTO update(@PathVariable Long id, @Valid @RequestBody AlunoDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}