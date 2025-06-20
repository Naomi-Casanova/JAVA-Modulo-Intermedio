
// RETO 2 SESION 1 ___________________________________________________________

package Sesion1.Reto2;

import java.util.*;


public class PlataformaEducativa {

    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
       
        System.out.println("\n ***********************************************************************");
        System.out.println("Materiales del curso:");

        for (MaterialCurso material : lista) {
            material.mostrarDetalle();
        }

    }

    // DURACIONES DE  LOS VIDEOS 
    public static void contarDuracionVideos(List<? extends Video> lista) {
        
        int duracion_total = 0;
        for ( Video v : lista) {
            duracion_total += v.getDuracion();
        }

        System.out.println("La duración total de videos es de " + duracion_total + " minutos");
    }

    
    // EJERCICIOS REVISADOS 
    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {

        System.out.println("\n EJERCICIOS REVISADOS");

        for (Object obj : lista ) {
        
            try { Ejercicio e = (Ejercicio) obj;
                  e.setRevisado(true);
                  System.out.println("Ejercicio '" + e.getTitulo() + "' marcado como revisado.");

            }catch (Exception e) {
                System.out.println("No se pudo marcar el ejercicio como revisado");
            }

        }

    }


    public static void main(String[] args) {
        

        List<MaterialCurso> materiales = Arrays.asList(
                new Video("Cómo crear una tarifa", "Salvador", 120),
                new Articulo("Reservas", "Alma", 2000),
                new Ejercicio("Danza", "Josefina"),

                new Video("Finanzas Corporativas", "Tinoco", 45),
                new Articulo("Cienica de Datos", "Damian", 4900),
                new Ejercicio("Ecuaciones Diferenciales", "Fernanda"),

                new Video("Inteligencia Artificial", "Gonzalo", 50),
                new Articulo("Tipos de datos", "Luis", 800),
                new Ejercicio("Calculo de Primas", "Daniel")
                
        );

        // VIDEOS Y EJERCICIOS 
        List<Video> videos = new ArrayList<>();
        List<Ejercicio> ejercicios = new ArrayList<>();

        for (MaterialCurso m : materiales) {

            if (m instanceof Video) {
                videos.add((Video) m);
            }
            
            if (m instanceof Ejercicio) {
                ejercicios.add((Ejercicio) m);
            }

        }

        // IMPRIMIENDO TODOS LOS MATERIALES 
        mostrarMateriales(materiales);

        // DURACION TOTAL DE LOS VIDEOS 
        System.out.println();
        System.out.println("***********************************************************************");
        contarDuracionVideos(videos);
        System.out.println("***********************************************************************");
        
        // EJERCICIOS REVISADOS 
        marcarEjerciciosRevisados(ejercicios);
        System.out.println();


    }

}