
// RETO 1 SESION 1 ___________________________________________________________
package Sesion1.Reto1;

// Importamos las bibliotecas
import java.util.*;

public class BaseOrdenes {

    // METODO PARA MOSTRAR LAS ORDENES  *****************************************************************************************
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
         
        System.out.println("************************************************************************ ");
        System.out.println("Ordenes registradas en nuestra Base: ");

        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }

    }
    
    // METODO PARA ORDENES PERSONALIZADAS CON COSTO ADICIONAL *******************************************************************
    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
       
        System.out.println("\n MODIFICANDO LAS ORDENES PERSONALIZADAS  *************************");

        for (Object obj : lista) {

            try { OrdenPersonalizada op = (OrdenPersonalizada) obj;
                  System.out.println("Orden " + op.getCodigo() + " ajustada con un costo adicional de $" + costoAdicional);
            }catch (Exception e) {
                System.out.println("Ocurrió un error al momento de capturar la orden personalizada");
            }

        }
    }

    // EJEMPLOS DE ORDENES  *******************************************************************************************
    public static void main(String[] args) {

        // LISTA DE ORDENES *******************************************************************************************

        // MASA
        List<OrdenMasa> masas = Arrays.asList(
                new OrdenMasa("M2001",  100),
                new OrdenMasa("M2002",  250),
                new OrdenMasa("M2003",  533),
                new OrdenMasa("M2004",  360)
        );

        // PERSONALIZADAS
        List<OrdenPersonalizada> personalizadas = Arrays.asList(
                new OrdenPersonalizada("PE10", 100, "Erick Gómez"),
                new OrdenPersonalizada("PE701", 150, "Evelyn León"),
                new OrdenPersonalizada("PE255", 100, "Abdi López"),
                new OrdenPersonalizada("PE904", 150, "Daniel Gárcia")
        );

        // PROTOTIPO
        List<OrdenPrototipo> prototipos = Arrays.asList(
                new OrdenPrototipo("PR1001", 8, "Planeación"),
                new OrdenPrototipo("PR1002", 5, "Testing"),
                new OrdenPrototipo("PR1003", 20, "Planeación"),
                new OrdenPrototipo("PR1004", 3, "Testing")
        );

        // MOSTRAMOS LAS ORDENES ************************************************************************
        System.out.println("\n EN MASA");
        mostrarOrdenes(masas);
        System.out.println("\n PERSONALIZADAS");
        mostrarOrdenes(personalizadas);
        System.out.println("\n PROTOTIPOS");
        mostrarOrdenes(prototipos);

        // PROCESAMOS ORDENES PERSONALIZADAS ************************************************************************
        procesarPersonalizadas(personalizadas, 200);

        // JUSTAMOS LAS ORDENES ***********************************************************************************
        List<List<? extends OrdenProduccion>> tiposDeOrden = Arrays.asList(
                masas,
                personalizadas,
                prototipos
        );

        // Nombres asociados a los tipos, en el mismo orden
        List<String> nombreTipoOrden = Arrays.asList(
                "Masa",
                "Personalizadas",
                "Prototipos"
        );


        // CONTEO
        System.out.println("________________________________________________________________________ ");
        System.out.println("RESUMEN DE ORDENES POR TIPO");
        for (int i = 0; i < tiposDeOrden.size(); i++) {

            String nombre = nombreTipoOrden.get(i);
            int cantidad = tiposDeOrden.get(i).size();
            System.out.println(nombre + " : " + cantidad);

        }

    

    }
}
