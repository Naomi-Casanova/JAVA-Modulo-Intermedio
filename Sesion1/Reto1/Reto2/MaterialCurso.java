
// RETO 2 SESION 1 ___________________________________________________________

package Sesion1.Reto2;

public abstract class MaterialCurso {

    // ATRIBUTOS 
    private final String titulo;
    private final String autor;

    public MaterialCurso(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }

    // METODO 
    public abstract void mostrarDetalle();
    
}