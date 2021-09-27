package xyz.pangosoft.dimsa.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "correlativos")
public class Correlativo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCorrelativo;
    private Long correlativoInicial;
    private Long correlativoFinal;
    private Long correlativoActual;
    private String serie;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Usuario usuario;

    @PrePersist
    public void prepersist(){
        this.fechaCreacion = new Date();
    }

    public Long getIdCorrelativo() {
        return idCorrelativo;
    }

    public void setIdCorrelativo(Long idCorrelativo) {
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

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private static final long serialVersionUID = 1L;
}
