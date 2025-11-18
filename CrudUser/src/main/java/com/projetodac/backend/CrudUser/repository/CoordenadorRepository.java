package com.projeto.IForum.repository;

public class CoordenadorRepository implements UsuarioRepository<Coordenador>{
    
    private Map<Long, Coordenador> repository;

    public CoordenadorRepository() {
        this.repository = new HashMap<>();
    }

    @Override
    public void save(Coordenador coordenador) {
        repository.put(coordenador.getId(), coordenador);
    }

    @Override
    public Coordenador findCoordenadorById(Long id) {
        return repository.get(id);
    }
}
