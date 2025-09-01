package com.projetodac.backend.CrudUser.repository;

import com.projetodac.backend.CrudUser.model.Coordenador;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CoordenadorRepository extends JpaRepository<Coordenador, Long> {
    Optional<Coordenador> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, Long id);
}