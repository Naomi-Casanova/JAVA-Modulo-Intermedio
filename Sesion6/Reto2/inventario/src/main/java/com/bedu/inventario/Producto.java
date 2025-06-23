package com.bedu.inventario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    protected Producto() {}

    // Constructor con marca
    public Producto(String nombre, String descripcion, double precio, Marca marca) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.marca = marca;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public Marca getMarca() { return marca; }

    @Override
    public String toString() {
        return String.format("Producto[id=%d, nombre='%s', precio=%.2f, marca='%s']",
                id, nombre, precio, marca != null ? marca.getNombre() : "Sin marca");
    }
}
