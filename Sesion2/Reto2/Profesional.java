
// RETO 2 SESION 2 ___________________________________________________________

package Sesion2.Reto2;

public class Profesional implements Runnable {

    // ATRIBUTOS 
    private final String nombre;
    private final RecursoMedico recurso;

    public Profesional(String nombre, RecursoMedico recurso) {
        this.nombre = nombre;
        this.recurso = recurso;
    }

    @Override
    public void run() {
        recurso.usar(nombre);
    }

}
