package xyz.pangosoft.dimsa.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "id_estado")
public class Estado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstado;
    private String estado;

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    private static final long serialVersionUID = 1L;
}
