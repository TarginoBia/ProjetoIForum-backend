package com.projeto.IForum.repository;

public class DenunciaRepository{
    
    private Map<Long, Denuncia> repository;

    public DenunciaRepository() {
        this.repository = new HashMap<>();
    }

    @Override
    public void save(Denuncia denuncia) {
        repository.put(denuncia.getId(), denuncia);
    }

    @Override
    public Denuncia findDenunciaById(Long id) {
        return repository.get(id);
    }
}
