package com.projetodac.backend.CrudUser.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.projetodac.backend.CrudUser.dto.UserDTO;
import com.projetodac.backend.CrudUser.model.User;
import com.projetodac.backend.CrudUser.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    
    private static UserDTO toDTO(User u) {
        UserDTO dto = new UserDTO();
        dto.setId(u.getId());
        dto.setName(u.getName());
        dto.setEmail(u.getEmail());
        dto.setSenha(u.getSenha());
        return dto;
    }

    private static void copyFromDTO(UserDTO dto, User entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
    }

    @Transactional
    public UserDTO create(UserDTO dto) {
        if (repo.existsByEmail(dto.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail já cadastrado");
        }
        var entity = new User();
        copyFromDTO(dto, entity);
        var saved = repo.save(entity);
        return toDTO(saved);
    }

    @Transactional
    public UserDTO update(Long id, UserDTO dto) {
    var entity = repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

    if (repo.existsByEmailAndIdNot(dto.getEmail(), id)) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail já cadastrado por outro usuário");
    }

    copyFromDTO(dto, entity);
    var saved = repo.save(entity);
    return toDTO(saved);
    }

    @Transactional(readOnly = true)
    public List<UserDTO> listAll() {
        return repo.findAll().stream()
                .map(UserService::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        return repo.findById(id)
                .map(UserService::toDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    @Transactional
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
        repo.deleteById(id);
    }
}
