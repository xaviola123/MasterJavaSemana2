package bibilioteca_jdbc_BBDD.clases.documentos;

public class Libro extends Documento {
    private int anioPublicacion;

    public Libro(String codigo, String titulo, int anioPublicacion) {
        super(codigo, titulo);
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public int calcularDuracionMaximaPrestamo() {
        return 30;
    }

    @Override
    public boolean estaPrestado() {
        return false;
    }
}