
// RETO 1 SESION 2 ___________________________________________________________

package Sesion2.Reto1;

import Sesion2.Reto1.misionespacial.SistemaComunicaciones;
import Sesion2.Reto1.misionespacial.SistemaControlTermico;
import Sesion2.Reto1.misionespacial.SistemaNavegacion;
import Sesion2.Reto1.misionespacial.SistemaSoporteVital;

import java.util.concurrent.*;

public class main {
    public static void main(String[] args) throws Exception {

        System.err.println();
        System.out.println("La Simulación de misión espacial ha sido iniciada...");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Future<String> nav = executor.submit(new SistemaNavegacion());
        System.out.println(nav.get());

        Future<String> vital = executor.submit(new SistemaSoporteVital());
        System.out.println(vital.get());

        Future<String> com = executor.submit(new SistemaComunicaciones());
        System.out.println(com.get());
        Future<String> termico = executor.submit(new SistemaControlTermico());
        System.out.println(termico.get());

        
        executor.shutdown();
        System.out.println("_____________________________________________________");
        System.out.println("Todos los sistemas han reportado estado operativo :) ");
        System.err.println();
    
    }

}
