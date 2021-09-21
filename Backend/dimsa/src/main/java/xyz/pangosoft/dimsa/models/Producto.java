package xyz.pangosoft.dimsa.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    private String codProducto;
    private String nombre;
    private Double precioCompra;
    private Double precioVenta;
    private Double porcentajeGanancia;
    private Integer stock;
    private String imagen;

    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_producto")
    private TipoProducto tipoProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca_producto")
    private MarcaProducto marcaProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @PrePersist
    public void prepersist(){
        this.fechaRegistro = new Date();
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public Double getPorcentajeGanancia() {
        return porcentajeGanancia;
    }

    public Integer getStock() {
        return stock;
    }

    public String getImagen() {
        return imagen;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public MarcaProducto getMarcaProducto() {
        return marcaProducto;
    }

    public Estado getEstado() {
        return estado;
    }

    private static final long serialVersionUID = 1L;
}
