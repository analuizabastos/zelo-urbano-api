package com.zelourbano.unidade;

import com.zelourbano.comunidade.Comunidade;
import com.zelourbano.statussistema.StatusSistema;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "unidade")
public class Unidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unidade")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_comunidade")
    private Comunidade comunidade;

    @Column(name = "latitude", nullable = false)
    private BigDecimal latitude;

    @Column(name = "longitude", nullable = false)
    private BigDecimal longitude;

    @Column(name = "area_lote")
    private BigDecimal areaLote;

    @ManyToOne
    @JoinColumn(name = "status")
    private StatusSistema status;

    public Unidade() {
    }

    public Unidade(Integer id, Comunidade comunidade, BigDecimal latitude, BigDecimal longitude, BigDecimal areaLote, StatusSistema status) {
        this.id = id;
        this.comunidade = comunidade;
        this.latitude = latitude;
        this.longitude = longitude;
        this.areaLote = areaLote;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Comunidade getComunidade() {
        return comunidade;
    }

    public void setComunidade(Comunidade comunidade) {
        this.comunidade = comunidade;
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

    public BigDecimal getAreaLote() {
        return areaLote;
    }

    public void setAreaLote(BigDecimal areaLote) {
        this.areaLote = areaLote;
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
        if (!(o instanceof Unidade unidade)) return false;
        return Objects.equals(getId(), unidade.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
