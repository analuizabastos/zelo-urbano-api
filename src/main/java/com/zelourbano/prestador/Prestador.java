package com.zelourbano.prestador;
import com.zelourbano.statussistema.StatusSistema;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "prestador")
public class Prestador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestador")
    private Integer id;

    @Column(name = "tipo_prestador", nullable = false, length = 50)
    private String tipoPrestador;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "cpf", length = 11, unique = true)
    private String cpf;

    @Column(name = "categoria_de_servico", nullable = false, length = 100)
    private String categoriaDeServico;

    @Column(name = "telefone", nullable = false, length = 20)
    private String telefone;

    @Column(name = "link_suporte", length = 255)
    private String linkSuporte;

    @Column(name = "observacoes")
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private StatusSistema status;

    public Prestador() {}

    public Prestador(String tipoPrestador, String nome, String cpf, String categoriaDeServico, String telefone, String linkSuporte, String observacoes, StatusSistema status) {
        this.tipoPrestador = tipoPrestador;
        this.nome = nome;
        this.cpf = cpf;
        this.categoriaDeServico = categoriaDeServico;
        this.telefone = telefone;
        this.linkSuporte = linkSuporte;
        this.observacoes = observacoes;
        this.status = status;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTipoPrestador() { return tipoPrestador; }
    public void setTipoPrestador(String tipoPrestador) { this.tipoPrestador = tipoPrestador; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getCategoriaDeServico() { return categoriaDeServico; }
    public void setCategoriaDeServico(String categoriaDeServico) { this.categoriaDeServico = categoriaDeServico; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getLinkSuporte() { return linkSuporte; }
    public void setLinkSuporte(String linkSuporte) { this.linkSuporte = linkSuporte; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
    public StatusSistema getStatus() { return status; }
    public void setStatus(StatusSistema status) { this.status = status; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prestador prestador)) return false;
        return Objects.equals(getId(), prestador.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}