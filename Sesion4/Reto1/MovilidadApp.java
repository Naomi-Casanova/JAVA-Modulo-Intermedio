
// RETO 1 SESION 4 ___________________________________________________________

package Sesion4.Reto1;
import java.util.concurrent.*;

public class MovilidadApp {

    public static void main(String[] args) {

        System.out.println();
        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = estimarTarifa();

        CompletableFuture<Void> viajeCompleto = rutaFuture.thenCombine(tarifaFuture,
                        (ruta, tarifa) -> { return "Ruta calculada: " + ruta + " | Tarifa estimada: $" + tarifa; })
                        .thenAccept(System.out::println) ;

        viajeCompleto.join();
        System.out.println();
    }

    // METODOS ******************************************************

    // CALCULAR RUTA
    public static CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {

            System.out.println("Calculando ruta...");
            latencia(2); 
            return "Centro -> Norte";

        });
    }

    // ESTIMAR TARIFA 
    public static CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {

            System.out.println("Calculando tarifa...");
            latencia(2); 
            return 75.50;

        });
    }

    // COMBINAR AMBAS OPERACIONES 
    public static void latencia(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }



}
