package com.projeto.IForum.repository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

    public void save(Usuario usuario);

    public Usuario findUsuarioById(Long id);

}
    
