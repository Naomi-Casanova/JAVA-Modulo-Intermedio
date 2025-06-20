
// RETO 1 SESION 1 ___________________________________________________________

package Sesion1.Reto1;

// Subclases de OrdenProduccion
public class OrdenPrototipo extends OrdenProduccion {

    // ATRIBUTO *************************************************************************
    private final String faseDesarrollo;

    public OrdenPrototipo(String codigo, int cantidad, String faseDesarrollo) {
        super(codigo, cantidad);
        this.faseDesarrollo = faseDesarrollo;
    }

    public String getFaseDesarrollo() { return faseDesarrollo; }

    @Override
    public void mostrarResumen() {
        System.out.println("OrdenPrototipo - Código: " + getCodigo() + " - Cantidad: " + getCantidad() + " - Fase: " + faseDesarrollo);
    }
}