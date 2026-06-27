package com.zelourbano.prestador;

import com.zelourbano.prestador.Prestador;

public class CadastroPrestadorRequest {
    private Prestador prestador;
    private String senha;

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
