
// RETO 1 SESION 2 ___________________________________________________________

package Sesion2.Reto1.misionespacial;

import java.util.concurrent.Callable;

public class SistemaNavegacion implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Navegación: trayectoria corregida con éxito.";
    }

}
