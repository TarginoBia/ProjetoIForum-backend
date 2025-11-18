package com.projeto.IForum.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.IForum.dto.CoordenadorDTO;
import com.projeto.IForum.service.CoordenadorService;

@RestController
@RequestMapping("/coordenadores")
public class CoordenadorController{

    private List<Coordenador> Coordenadores = new ArrayList<>();

    @GetMapping("/coordenadores")
    public List<Coordenador> getAllCoordenadores() {
        return coordenadores;
    }

    @PostMapping("/coordenadores")
    public String addCoordenador(@RequestBody Coordenador coordenadores) {
        coordenadores.add(coordenadores);
        return "Coordenador inserido com sucesso";
    }

    @PutMapping("/coordenadores/{id}")
    public String updateCoordenador(@PathVariable int id, @RequestBody Coordenador updatedCoordenador) {
        for (Coordenador coordenadores : coordenadores) {
            if (coordenadores.getId() == id) {
                coordenadores.setName(updatedCoordenadors.getName());
                return "Coordenador atualizado com sucesso";
            }
        }
        return "Coordenador não encontrado!";
    }

    @DeleteMapping("/coordenadores/{id}")
    public String deleteCoordenadors(@PathVariable int id) {
        coordenadores.removeIf(coordenadores -> coordenadores.getId() == id);
        return "Coordenador deletado com sucesso";
    }
}
