package com.zelourbano.morador;

public class CadastroMoradorRequest {

    private Morador morador;
    private String senha;

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}