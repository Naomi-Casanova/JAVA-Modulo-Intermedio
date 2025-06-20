
// RETO 2 SESION 1 ___________________________________________________________

package Sesion1.Reto2;

public class Ejercicio extends MaterialCurso {

    // ATRIBUTO
    private boolean revisado;

    public Ejercicio(String titulo, String autor) {
        super(titulo, autor);
        this.revisado = false;
    }

    public boolean isRevisado() { return revisado; }
    public void setRevisado(boolean revisado) { this.revisado = revisado; }

    @Override
    public void mostrarDetalle() {
        System.out.println("Ejercicio: " + getTitulo() + " - Autor: " + getAutor() + " - Revisado: " + revisado);
    }

}
