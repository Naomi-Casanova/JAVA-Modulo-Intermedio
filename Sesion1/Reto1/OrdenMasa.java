
// RETO 1 SESION 1 ___________________________________________________________
package Sesion1.Reto1;

// Subclases de OrdenProduccion
public class OrdenMasa extends OrdenProduccion {

    public OrdenMasa(String codigo, int cantidad) {
        super(codigo, cantidad);
    }

    @Override
    public void mostrarResumen() {
        System.out.println("OrdenMasa - Código: " + getCodigo() + " - Cantidad: " + getCantidad());
    }

}