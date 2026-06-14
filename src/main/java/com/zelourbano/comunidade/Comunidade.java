package com.zelourbano.comunidade;

import com.zelourbano.statussistema.StatusSistema;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "comunidade")
public class Comunidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comunidade")
    private Integer id;

    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Column(name = "cnpj", length = 14, unique = true)
    private String cnpj;

    @Column(name = "razao_social", length = 200)
    private String razaoSocial;

    @Column(name = "nome_fantasia", length = 200)
    private String nomeFantasia;

    @Column(name = "inscricao_estadual", length = 14)
    private String inscricaoEstadual;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "quantidade_de_lotes", nullable = false)
    private Integer quantidadeLotes;

    @Column(name = "area_total", nullable = false)
    private BigDecimal areaTotal;

    @Column(name = "observacoes")
    private String observacoes;

    @Column(name = "doc_identificacao", length = 254)
    private String docIdentificacao;

    @ManyToOne
    @JoinColumn(name = "status")
    private StatusSistema status;
    public Comunidade() {
    }

    public Comunidade(Integer id, String nome, String cnpj, String razaoSocial, String nomeFantasia, String inscricaoEstadual, String email, Integer quantidadeLotes, BigDecimal areaTotal, String observacoes, String docIdentificacao, StatusSistema status) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.inscricaoEstadual = inscricaoEstadual;
        this.email = email;
        this.quantidadeLotes = quantidadeLotes;
        this.areaTotal = areaTotal;
        this.observacoes = observacoes;
        this.docIdentificacao = docIdentificacao;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getQuantidadeLotes() {
        return quantidadeLotes;
    }

    public void setQuantidadeLotes(Integer quantidadeLotes) {
        this.quantidadeLotes = quantidadeLotes;
    }

    public BigDecimal getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(BigDecimal areaTotal) {
        this.areaTotal = areaTotal;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getDocIdentificacao() {
        return docIdentificacao;
    }

    public void setDocIdentificacao(String docIdentificacao) {
        this.docIdentificacao = docIdentificacao;
    }

    public StatusSistema getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comunidade that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
