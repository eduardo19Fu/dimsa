package xyz.pangosoft.dimsa.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "facturas")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;
    private Long noFactura;
    private String serie;
    private Double total;
    private String autorizacionSat;
    private String resultadoSat;
    private String serieSat;
    private Long correlativoSat;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Cliente cliente;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_factura")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private List<FacturaDetalle> items;

    public Factura(){
        this.items = new ArrayList<>();
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public Long getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(Long noFactura) {
        this.noFactura = noFactura;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getAutorizacionSat() {
        return autorizacionSat;
    }

    public void setAutorizacionSat(String autorizacionSat) {
        this.autorizacionSat = autorizacionSat;
    }

    public String getResultadoSat() {
        return resultadoSat;
    }

    public void setResultadoSat(String resultadoSat) {
        this.resultadoSat = resultadoSat;
    }

    public String getSerieSat() {
        return serieSat;
    }

    public void setSerieSat(String serieSat) {
        this.serieSat = serieSat;
    }

    public Long getCorrelativoSat() {
        return correlativoSat;
    }

    public void setCorrelativoSat(Long correlativoSat) {
        this.correlativoSat = correlativoSat;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<FacturaDetalle> getItems() {
        return items;
    }

    public void setItems(List<FacturaDetalle> items) {
        this.items = items;
    }

    private static final long serialVersionUID = 1L;
}
