package com.projeto.IForum.controller;

import java.util.List;
import java.util.Optional;

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

import com.projeto.IForum.dto.CoordenadorDTO;
import com.projeto.IForum.service.CoordenadorService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("api/coordenadores")
public class CoordenadorController{

    @Autowired
    private CoordenadorService coordenadorService;

    @PostMapping
    public ResponseEntity<CoordenadorDTO> registrarCoordenador(@RequestBody CoordenadorDTO coordenadorDTO) {
        CoordenadorDTO novoCoordenador = coordenadorService.salvar(coordenadorDTO);
        return new ResponseEntity<>(novoCoordenador, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CoordenadorDTO>> listarCoordenadores() {
        List<CoordenadorDTO> listaCoordenadores = coordenadorService.buscarTodos();
        return ResponseEntity.ok(listaCoordenadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoordenadorDTO> buscarCoordenadorPorId(@PathVariable Long id) {
        Optional<CoordenadorDTO> coordenadorDTO = coordenadorService.buscarPorId(id);

        return coordenadorDTO.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoordenadorDTO> atualizarCoordenador(
            @PathVariable Long id,
            @Valid @RequestBody CoordenadorDTO coordenadorDTO
    ) {
        coordenadorDTO.setId(id);
        
        Optional<CoordenadorDTO> coordenadorAtualizado = coordenadorService.atualizar(coordenadorDTO);

        return coordenadorAtualizado.map(ResponseEntity::ok)
                              .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCoordenador(@PathVariable Long id) {
        boolean deletado = coordenadorService.deletar(id);

        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
