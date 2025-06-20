
// RETO 1 SESION 2 ___________________________________________________________

package Sesion2.Reto1.misionespacial;

import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1500);
        return "Comunicaciones: enlace con estación terrestre establecido.";
    }

}
