package com.projeto.IForum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.IForum.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long>{
    
}
