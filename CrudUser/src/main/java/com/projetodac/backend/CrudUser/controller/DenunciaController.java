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

import com.projeto.IForum.dto.DenunciaDTO;
import com.projeto.IForum.service.DenunciaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/denuncias")
public class DenunciaController {

    @Autowired
    private DenunciaService denunciaService;

    @PostMapping
    public ResponseEntity<DenunciaDTO> registrarDenuncia(@RequestBody DenunciaDTO denunciaDTO) {
        DenunciaDTO novaDenuncia = denunciaService.salvar(denunciaDTO);
        return new ResponseEntity<>(novaDenuncia, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DenunciaDTO>> listarDenuncias() {
        List<DenunciaDTO> listaDenuncias = denunciaService.buscarTodos();
        return ResponseEntity.ok(listaDenuncias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DenunciaDTO> buscarDenunciaPorId(@PathVariable Long id) {
        Optional<DenunciaDTO> denunciaDTO = denunciaService.buscarPorId(id);

        return denunciaDTO.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DenunciaDTO> atualizarDenuncia(
            @PathVariable Long id,
            @Valid @RequestBody DenunciaDTO denunciaDTO
    ) {
        denunciaDTO.setId(id);
        
        Optional<DenunciaDTO> denunciaAtualizado = denunciaService.atualizar(denunciaDTO);

        return denunciaAtualizado.map(ResponseEntity::ok)
                              .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDenuncia(@PathVariable Long id) {
        boolean deletado = denunciaService.deletar(id);

        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
