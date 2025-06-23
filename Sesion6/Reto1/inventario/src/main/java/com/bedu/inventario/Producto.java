
// RETO 1 SESION 6 ___________________________________________________________

package com.bedu.inventario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Producto {
  
    // ATRIBUTOS Y VALIDACIONES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    private double precio;

    protected Producto() {}

    public Producto(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return String.format("Producto[id=%d, nombre='%s', precio=%.2f]",
                id, nombre, precio);

    }

}