package xyz.pangosoft.dimsa.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "correlativos")
public class Correlativo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCorrelativo;
    private Long correlativoInicial;
    private Long correlativoFinal;
    private Long correlativoActual;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @PrePersist
    public void prepersist(){
        this.fechaCreacion = new Date();
    }

    public Integer getIdCorrelativo() {
        return idCorrelativo;
    }

    public void setIdCorrelativo(Integer idCorrelativo) {
        this.idCorrelativo = idCorrelativo;
    }

    public Long getCorrelativoInicial() {
        return correlativoInicial;
    }

    public void setCorrelativoInicial(Long correlativoInicial) {
        this.correlativoInicial = correlativoInicial;
    }

    public Long getCorrelativoFinal() {
        return correlativoFinal;
    }

    public void setCorrelativoFinal(Long correlativoFinal) {
        this.correlativoFinal = correlativoFinal;
    }

    public Long getCorrelativoActual() {
        return correlativoActual;
    }

    public void setCorrelativoActual(Long correlativoActual) {
        this.correlativoActual = correlativoActual;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    private static final long serialVersionUID = 1L;
}
