package com.zelourbano.camera;

import com.zelourbano.comunidade.Comunidade;
import com.zelourbano.statussistema.StatusSistema;
import com.zelourbano.usuario.Usuario;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "camera")
public class Camera implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_camera")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_comunidade", nullable = false)
    private Comunidade comunidade;

    @Column(name = "origem_morador", nullable = false)
    private Boolean origemMorador;

    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;

    @Column(name = "latitude", nullable = false)
    private BigDecimal latitude;

    @Column(name = "longitude", nullable = false)
    private BigDecimal longitude;

    @Column(name = "link_rtsp_url", nullable = false, length = 255)
    private String linkRtspUrl;

    @ManyToOne
    @JoinColumn(name = "id_status", nullable = false)
    private StatusSistema status;

    public Camera() {
    }

    public Camera(Integer id, Usuario usuario, Comunidade comunidade, Boolean origemMorador, String descricao, BigDecimal latitude, BigDecimal longitude, String linkRtspUrl, StatusSistema status) {
        this.id = id;
        this.usuario = usuario;
        this.comunidade = comunidade;
        this.origemMorador = origemMorador;
        this.descricao = descricao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.linkRtspUrl = linkRtspUrl;
        this.status = status;
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

    public Comunidade getComunidade() {
        return comunidade;
    }

    public void setComunidade(Comunidade comunidade) {
        this.comunidade = comunidade;
    }

    public Boolean getOrigemMorador() {
        return origemMorador;
    }

    public void setOrigemMorador(Boolean origemMorador) {
        this.origemMorador = origemMorador;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public String getLinkRtspUrl() {
        return linkRtspUrl;
    }

    public void setLinkRtspUrl(String linkRtspUrl) {
        this.linkRtspUrl = linkRtspUrl;
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
        if (!(o instanceof Camera camera)) return false;
        return Objects.equals(getId(), camera.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}