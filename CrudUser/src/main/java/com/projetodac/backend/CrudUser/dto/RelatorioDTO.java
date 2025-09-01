package com.projetodac.backend.CrudUser.dto;

import java.time.LocalDate;

public class RelatorioDTO{
    private LocalDate data;
    private long denunciasCriadas;
    private long denunciasResolvidas;

    public RelatorioDTO(LocalDate data, long denunciasCriadas, long denunciasResolvidas) {
        this.data = data;
        this.denunciasCriadas = denunciasCriadas;
        this.denunciasResolvidas = denunciasResolvidas;
    }

    public LocalDate getData() {
        return data;
    }

    public long getDenunciasCriadas() {
        return denunciasCriadas;
    }

    public long getDenunciasResolvidas() {
        return denunciasResolvidas;
    }
}