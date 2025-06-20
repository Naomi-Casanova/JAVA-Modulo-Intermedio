
// RETO 2 SESION 4 ___________________________________________________________

package Sesion4.Reto2;

import java.util.concurrent.*;
import java.util.Random;

public class AeropuertoControl {

    private static final Random random = new Random();

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Verificando condiciones para aterrizaje...\n");

        CompletableFuture<Boolean> pistaFuture = verificarPista();
        CompletableFuture<Boolean> climaFuture = verificarClima();
        CompletableFuture<Boolean> traficoFuture = verificarTraficoAereo();
        CompletableFuture<Boolean> personalFuture = verificarPersonalTierra();

        CompletableFuture<Void> controlAterrizaje = CompletableFuture.allOf(pistaFuture, climaFuture, traficoFuture, personalFuture)
                .thenAccept(v -> {
                    try {
                        boolean pista = pistaFuture.get();
                        boolean clima = climaFuture.get();
                        boolean trafico = traficoFuture.get();
                        boolean personal = personalFuture.get();

                        if (pista && clima && trafico && personal) {
                            System.out.println("\n Aterrizaje autorizado: todas las condiciones óptimas.");
                        } else {
                            System.out.println("\n Aterrizaje denegado: condiciones no óptimas !!!!!!!!!!!!! ");
                        }
                    } catch (InterruptedException | ExecutionException e) {
                        System.out.println("\n No se puedieron evaluar correctamente las condiciones ");
                    }
                })
                .exceptionally(ex -> {
                    System.out.println("\n Error en el proceso de aterrizaje: " + ex.getMessage());
                    return null;
                });

        
        controlAterrizaje.join();
        System.out.println();
        
    }

    // METODOS ********************************************************************************************************
    
    // VERIFICAR PISTA
    public static CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            
            latencia(2);
            boolean disponible = random.nextInt(100) < 98; 
            System.out.println("Pista disponible: " + disponible);
            return disponible;
        });
    }

     // VERIFICAR CLIMA
    public static CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
          
            latencia(3);
            boolean bueno = random.nextInt(100) < 90; 
            System.out.println("Clima favorable: " + bueno);
            return bueno;
        });
    }

    // VERIFICAR TRAFICO AEREO 
    public static CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
           
            latencia(3);
            boolean libre = random.nextInt(100) < 95; 
            System.out.println("Tráfico aéreo despejado: " + libre);
            return libre;
        });
    }

    // VERIFICAR PERSONAL TIERRA
    public static CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            
            latencia(2);
            boolean disponible = random.nextInt(100) < 75; 
            System.out.println("Personal disponible: " + disponible);
            return disponible;
        });
    }

    // LATENCIA 
    public static void latencia(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
