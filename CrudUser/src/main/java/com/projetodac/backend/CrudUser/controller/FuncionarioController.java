package com.projeto.IForum.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.IForum.dto.FuncionarioDTO;
import com.projeto.IForum.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController extends UsuarioController<FuncionarioDTO, Long> {
    private final FuncionarioService funcionarioService;
}