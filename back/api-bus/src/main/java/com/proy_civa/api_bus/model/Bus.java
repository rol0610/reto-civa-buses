package com.proy_civa.api_bus.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "buses")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroBus;
    private String placa;
    private LocalDateTime fechaCreacion;
    private String caracteristicas;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getNumeroBus() { return numeroBus; }
    public String getPlaca() { return placa; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public String getCaracteristicas() { return caracteristicas; }
    public boolean isActivo() { return activo; }
    public Marca getMarca() { return marca; }

    public void setNumeroBus(String numeroBus) { this.numeroBus = numeroBus; }
    public void setPlaca(String placa) { this.placa = placa; }
    public void setCaracteristicas(String caracteristicas) { this.caracteristicas = caracteristicas; }
    public void setActivo(boolean activo) { this.activo = activo; }
    public void setMarca(Marca marca) { this.marca = marca; }
}