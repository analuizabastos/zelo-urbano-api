package com.zelourbano.moradorunidade;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MoradorUnidadeId implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idMorador;
    private Integer idUnidade;

    public MoradorUnidadeId() {
    }

    public MoradorUnidadeId(Integer idMorador, Integer idUnidade) {
        this.idMorador = idMorador;
        this.idUnidade = idUnidade;
    }

    public Integer getIdMorador() {
        return idMorador;
    }

    public void setIdMorador(Integer idMorador) {
        this.idMorador = idMorador;
    }

    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoradorUnidadeId that)) return false;
        return Objects.equals(getIdMorador(), that.getIdMorador()) && Objects.equals(getIdUnidade(), that.getIdUnidade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdMorador(), getIdUnidade());
    }
}
