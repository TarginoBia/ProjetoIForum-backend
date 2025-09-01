package com.projetodac.backend.CrudUser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.projetodac.backend.CrudUser.config.DadosTokenJWT;
import com.projetodac.backend.CrudUser.dto.UserDTO; // Importe o DTO do usuário
import com.projetodac.backend.CrudUser.model.DadosAuthentication;
import com.projetodac.backend.CrudUser.model.User;
import com.projetodac.backend.CrudUser.service.TokenService;
import com.projetodac.backend.CrudUser.service.UserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService; // Injete a classe de serviço

    @PostMapping("/login")
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAuthentication dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody @Valid UserDTO dados) {
        try {
            userService.create(dados);
            return ResponseEntity.ok("Cadastrado com sucesso");
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        }
    }
}