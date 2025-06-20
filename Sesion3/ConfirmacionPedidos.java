
// RETO 1 SESION 3 ___________________________________________________________

package Sesion3.Reto1;

import java.util.*;
import java.util.stream.Collectors;

public class ConfirmacionPedidos {

    public static void main(String[] args) {

        List<Pedido> pedidos = Arrays.asList(
                new Pedido("Diana Loaiza", "domicilio", "+52-5514213322"),
                new Pedido("Katherin Lefort", "local", null),
                new Pedido("Ximena Morales", "domicilio", null),
                new Pedido("Itzel Acosta", "domicilio", "+52-5563567110"),
                new Pedido("Kevin Bautista", "internacional", "+51-5278123144")
        );

        List<String> mensajes = pedidos.stream()
                // Sin nulos 
                .filter(p -> p != null)
                // Filtramos los pedido de tipo entrega a domicilio
                .filter(p -> "domicilio".equalsIgnoreCase(p.getTipoEntrega()))
                .filter(p -> !p.getTelefono().orElse("").trim().isEmpty())
                .map(p -> "La confirmación ha sido enviada al número de teléfono " + p.getTelefono().get())
                .collect(Collectors.toList());
       

        
        if (mensajes.isEmpty()) {
            System.out.println("No se logrío hacer la confirmación de los pedidos ");

        } else {
            System.out.println();
            System.out.println("\nMOSTRANDO LOS NUMEROS TELEFÓNICOS A LOS QUE SE ENVIARON LAS CONFIRMACIONES");
            System.out.println("__________________________________________________________________________________");
            mensajes.forEach(System.out::println);
            System.out.println();


        }

    }

}
