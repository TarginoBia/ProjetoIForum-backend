package com.projeto.IForum.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.IForum.dto.AlunoDTO;
import com.projeto.IForum.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController extends UsuarioController<AlunoDTO, Long> {
    private final AlunoService alunoService; 
}