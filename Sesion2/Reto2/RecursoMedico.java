
// RETO 2 SESION 2 ___________________________________________________________

package Sesion2.Reto2;

import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {


    //  ATRIBUTOS
    private final String nombre; 
    private final ReentrantLock lock = new ReentrantLock(); 

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    // METODO
    public void usar(String profesional) {

        lock.lock(); 
        try {
            System.out.println(profesional + " ha ingresado a " + nombre);
            // Esperamos tantito
            Thread.sleep(1500); 

            System.out.println(profesional + " ha salido de " + nombre);

        } catch (InterruptedException e) {
            System.out.println("El/La profesional ha tenido un contratiempo :( ");
            Thread.currentThread().interrupt();

        } finally {
            lock.unlock();
        }
    }

}