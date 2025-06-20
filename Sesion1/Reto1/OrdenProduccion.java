
// RETO 1 SESION 1 ___________________________________________________________

package Sesion1.Reto1;

public abstract class OrdenProduccion {

    // ATRIBUTOS ***********************************************
    private final String codigo;
    private final int cantidad;


    // CONSTRUCTOR *********************************************
    public OrdenProduccion(String codigo, int cantidad) {
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    // METODOS *************************************************
    public String getCodigo() { return codigo; }
    public int getCantidad() { return cantidad; }
    public abstract void mostrarResumen();


}