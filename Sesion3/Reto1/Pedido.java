
// RETO 1 SESION 3 ___________________________________________________________

package Sesion3.Reto1;

import java.util.Optional;

public class Pedido {

    // ATRIBUTOS 
    private final String cliente;
    private final String tipoEntrega; 
    private final String telefono; 


    public Pedido(String cliente, String tipoEntrega, String telefono) {
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
        
    }

    public String getCliente() { return cliente; }
    public String getTipoEntrega() { return tipoEntrega; }

    public Optional<String> getTelefono() {
        return Optional.ofNullable(telefono);
    }


}
