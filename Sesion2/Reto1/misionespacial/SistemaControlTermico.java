
// RETO 1 SESION 2 ___________________________________________________________

package Sesion2.Reto1.misionespacial;

import java.util.concurrent.Callable;

public class SistemaControlTermico implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1250);
        return "Control térmico: temperatura estable (22°C).";
    }

}
