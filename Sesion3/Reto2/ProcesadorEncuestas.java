
// RETO 2 SESION 3 ___________________________________________________________

package Sesion3.Reto2;

import java.util.*;

public class ProcesadorEncuestas {

    public static void main(String[] args) {

        List<Sucursal> sucursales = Arrays.asList(
            new Sucursal("Sucursal Portales", Arrays.asList(
                new Encuesta("Ivana", "La atención fue buena", 4),
                new Encuesta("Fernanda", null, 5)
            )),
            new Sucursal("Sucursal Indios Verdes", Arrays.asList(
                new Encuesta("Marta", "Estuve esperando por mas de 3 horas", 1),
                new Encuesta("Pedro", "No es mala pero prefiero la Sucursal de Portales", 4)
            )),
            new Sucursal("Sucursal Coacalco", Arrays.asList(
                new Encuesta("Carlos", null, 2),
                new Encuesta("Sofía", "Cerraron la sucrusal sin previo aviso", 3)
            )),
            new Sucursal("Sucursal Copilco", Arrays.asList(
                new Encuesta("Carlos", "Si tienen la oportunidad de venir a esta sucursal desaprovechenla", 1),
                new Encuesta("Sofía", "El personal fue muy prepotente y no tienen ganas de atender", 0)
            ))
        );

        System.out.println("COMENTARIOS NEGATIVOS SOBRE LAS SUCURSALES ");

        sucursales.stream()
            .flatMap(sucursal ->
                sucursal.getEncuestas().stream()
                    .filter(e -> e.getCalificacion() <= 3) // Puntuaciones menores o iguales a 3
                    .filter(e -> e.getComentario().map(c -> !c.trim().isEmpty()).orElse(false))
                    .map(e -> new AbstractMap.SimpleEntry<>(sucursal.getNombre(), e))
            )
            .map(entry -> {
                String sucursal = entry.getKey();
                String comentario = entry.getValue().getComentario().get();
                return sucursal + ": Seguimiento a paciente con comentario: \"" + comentario + "\"";
            })
            .forEach(System.out::println);

    }

}
