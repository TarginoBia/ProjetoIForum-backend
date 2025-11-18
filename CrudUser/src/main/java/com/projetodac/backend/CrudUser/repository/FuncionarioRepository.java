package com.projeto.IForum.repository;

public class FuncionarioRepository implements UsuarioRepository{
    
    private Map<Long, Funcionario> repository;

    public FuncionarioRepository() {
        this.repository = new HashMap<>();
    }

    @Override
    public void save(Funcionario funcionario) {
        repository.put(funcionario.getId(), funcionario);
    }

    @Override
    public Funcionario findFuncionarioById(Long id) {
        return repository.get(id);
    }
}
