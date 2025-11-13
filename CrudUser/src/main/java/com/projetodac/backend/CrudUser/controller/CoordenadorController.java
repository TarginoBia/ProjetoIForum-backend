package com.projeto.IForum.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.IForum.dto.CoordenadorDTO;

@RestController
@RequestMapping("/coordenadores")
public class CoordenadorController extends UsuarioController<CoordenadorDTO, Long> {
    private final CoordenadorService coordenadorService;
}