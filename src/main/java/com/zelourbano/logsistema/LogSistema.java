package com.zelourbano.logsistema;

import com.zelourbano.usuario.Usuario;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "log_sistema")
public class LogSistema implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "operacao", nullable = false, length = 100)
    private String operacao;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    public LogSistema() {
    }

    public LogSistema(Integer id, Usuario usuario, String operacao, LocalDateTime dataHora) {
        this.id = id;
        this.usuario = usuario;
        this.operacao = operacao;
        this.dataHora = dataHora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogSistema logSistema)) return false;
        return Objects.equals(getId(), logSistema.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}