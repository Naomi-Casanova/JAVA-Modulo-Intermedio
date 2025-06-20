
// RETO 2 SESION 2 ___________________________________________________________

package Sesion2.Reto2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
    public static void main(String[] args) {

        System.out.println("************************************************************");
        System.out.println("Iniciando simulación de Hospital");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");
        RecursoMedico salaPediatria = new RecursoMedico("Sala de Pediatría");
        RecursoMedico salaOptometria = new RecursoMedico("Sala de Optomería");


        // 🧵 Creamos un pool de 4 hilos para simular concurrencia
        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(new Profesional("Cirujana Naomi Casanova", salaCirugia));
        executor.submit(new Profesional("Cirujano Frida Hernández", salaCirugia));
        executor.submit(new Profesional("Pediatra Rafael Mercado", salaPediatria));
        executor.submit(new Profesional("Pedriatra Josefina Jiménez", salaPediatria));
        executor.submit(new Profesional("Enfermero Damian López", salaOptometria));
        executor.submit(new Profesional("Oftalmologo Iván Hurtado", salaOptometria));

        executor.shutdown();
    }

}
