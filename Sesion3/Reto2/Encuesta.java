
// RETO 2 SESION 3 ___________________________________________________________

package Sesion3.Reto2;

import java.util.Optional;

public class Encuesta {

    // ATRIBUTOS 
    private final String paciente;
    private final String comentario; 
    private final int calificacion; 

    public Encuesta(String paciente, String comentario, int calificacion) {

        this.paciente = paciente;
        this.comentario = comentario;
        this.calificacion = calificacion;

    }

    public int getPaciente() { return paciente; }
    public int getCalificacion() { return calificacion; }

    // Método seguro para obtener el comentario como Optional
    public Optional<String> getComentario() {
        return Optional.ofNullable(comentario);
    }

}
