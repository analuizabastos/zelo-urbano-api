package com.zelourbano.moradorunidade;

import com.zelourbano.morador.Morador;
import com.zelourbano.perfilacesso.PerfilAcesso;
import com.zelourbano.statussistema.StatusSistema;
import com.zelourbano.unidade.Unidade;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "morador_unidade")
public class MoradorUnidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private MoradorUnidadeId id;

    @ManyToOne
    @MapsId("idMorador")
    @JoinColumn(name = "id_morador")
    private Morador morador;

    @ManyToOne
    @MapsId("idUnidade")
    @JoinColumn(name = "id_unidade")
    private Unidade unidade;

    @ManyToOne
    @JoinColumn(name = "id_perfil_acesso")
    private PerfilAcesso perfilAcesso;

    @ManyToOne
    @JoinColumn(name = "status")
    private StatusSistema status;

    public MoradorUnidade() {
    }

    public MoradorUnidade(MoradorUnidadeId id, Morador morador, Unidade unidade, PerfilAcesso perfilAcesso, StatusSistema status) {
        this.id = id;
        this.morador = morador;
        this.unidade = unidade;
        this.perfilAcesso = perfilAcesso;
        this.status = status;
    }

    public MoradorUnidadeId getId() {
        return id;
    }

    public void setId(MoradorUnidadeId id) {
        this.id = id;
    }

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public PerfilAcesso getPerfilAcesso() {
        return perfilAcesso;
    }

    public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
        this.perfilAcesso = perfilAcesso;
    }

    public StatusSistema getStatus() {
        return status;
    }

    public void setStatus(StatusSistema status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoradorUnidade that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
