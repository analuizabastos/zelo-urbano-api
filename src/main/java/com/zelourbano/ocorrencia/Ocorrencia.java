package com.zelourbano.ocorrencia;

import com.zelourbano.camera.Camera;
import com.zelourbano.comunidade.Comunidade;
import com.zelourbano.prestador.Prestador;
import com.zelourbano.statussistema.StatusSistema;
import com.zelourbano.tipoocorrencia.TipoOcorrencia;
import com.zelourbano.usuario.Usuario;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "ocorrencia")
public class Ocorrencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ocorrencia")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario_autor", nullable = false)
    private Usuario usuarioAutor;

    @ManyToOne
    @JoinColumn(name = "id_comunidade", nullable = false)
    private Comunidade comunidade;

    @ManyToOne
    @JoinColumn(name = "status", nullable = false)
    private StatusSistema status;

    @Column(name = "protocolo", nullable = false, unique = true, length = 12)
    private String protocolo;

    @ManyToOne
    @JoinColumn(name = "id_tipo_ocorrencia", nullable = false)
    private TipoOcorrencia tipoOcorrencia;

    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "midia", length = 255)
    private String midia;

    @Column(name = "latitude", nullable = false)
    private BigDecimal latitude;

    @Column(name = "longitude", nullable = false)
    private BigDecimal longitude;

    @Column(name = "denuncia_anonima", nullable = false)
    private Boolean denunciaAnonima;

    @Column(name = "data_do_registro", nullable = false)
    private LocalDateTime dataDoRegistro;

    @Column(name = "data_da_resolucao")
    private LocalDateTime dataDaResolucao;

    @ManyToOne
    @JoinColumn(name = "id_usuario_destino")
    private Usuario usuarioDestino;

    @ManyToOne
    @JoinColumn(name = "id_camera")
    private Camera camera;

    @ManyToOne
    @JoinColumn(name = "id_prestador")
    private Prestador prestador;

    public Ocorrencia() {
    }

    public Ocorrencia(Integer id, Usuario usuarioAutor, Comunidade comunidade, StatusSistema status, String protocolo, TipoOcorrencia tipoOcorrencia, String titulo, String descricao, String midia, BigDecimal latitude, BigDecimal longitude, Boolean denunciaAnonima, LocalDateTime dataDoRegistro, LocalDateTime dataDaResolucao, Usuario usuarioDestino, Camera camera, Prestador prestador) {
        this.id = id;
        this.usuarioAutor = usuarioAutor;
        this.comunidade = comunidade;
        this.status = status;
        this.protocolo = protocolo;
        this.tipoOcorrencia = tipoOcorrencia;
        this.titulo = titulo;
        this.descricao = descricao;
        this.midia = midia;
        this.latitude = latitude;
        this.longitude = longitude;
        this.denunciaAnonima = denunciaAnonima;
        this.dataDoRegistro = dataDoRegistro;
        this.dataDaResolucao = dataDaResolucao;
        this.usuarioDestino = usuarioDestino;
        this.camera = camera;
        this.prestador = prestador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuarioAutor() {
        return usuarioAutor;
    }

    public void setUsuarioAutor(Usuario usuarioAutor) {
        this.usuarioAutor = usuarioAutor;
    }

    public Comunidade getComunidade() {
        return comunidade;
    }

    public void setComunidade(Comunidade comunidade) {
        this.comunidade = comunidade;
    }

    public StatusSistema getStatus() {
        return status;
    }

    public void setStatus(StatusSistema status) {
        this.status = status;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public TipoOcorrencia getTipoOcorrencia() {
        return tipoOcorrencia;
    }

    public void setTipoOcorrencia(TipoOcorrencia tipoOcorrencia) {
        this.tipoOcorrencia = tipoOcorrencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMidia() {
        return midia;
    }

    public void setMidia(String midia) {
        this.midia = midia;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Boolean getDenunciaAnonima() {
        return denunciaAnonima;
    }

    public void setDenunciaAnonima(Boolean denunciaAnonima) {
        this.denunciaAnonima = denunciaAnonima;
    }

    public LocalDateTime getDataDoRegistro() {
        return dataDoRegistro;
    }

    public void setDataDoRegistro(LocalDateTime dataDoRegistro) {
        this.dataDoRegistro = dataDoRegistro;
    }

    public LocalDateTime getDataDaResolucao() {
        return dataDaResolucao;
    }

    public void setDataDaResolucao(LocalDateTime dataDaResolucao) {
        this.dataDaResolucao = dataDaResolucao;
    }

    public Usuario getUsuarioDestino() {
        return usuarioDestino;
    }

    public void setUsuarioDestino(Usuario usuarioDestino) {
        this.usuarioDestino = usuarioDestino;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ocorrencia ocorrencia)) return false;
        return Objects.equals(getId(), ocorrencia.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}