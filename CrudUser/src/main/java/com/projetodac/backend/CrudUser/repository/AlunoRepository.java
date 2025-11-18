package com.projeto.IForum.repository;

public class AlunoRepository implements UsuarioRepository<Aluno>{

    private Map<Long, Aluno> repository;

    public AlunoRepository() {
        this.repository = new HashMap<>();
    }

    @Override
    public void save(Aluno aluno) {
        repository.put(aluno.getId(), aluno);
    }

    @Override
    public Aluno findAlunoById(Long id) {
        return repository.get(id);
    }
}
