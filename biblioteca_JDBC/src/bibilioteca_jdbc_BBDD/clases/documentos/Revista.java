package bibilioteca_jdbc_BBDD.clases.documentos;

public class Revista extends Documento {
    public Revista(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int calcularDuracionMaximaPrestamo() {
        return 10;
    }

    @Override
    public boolean estaPrestado() {
        return false;
    }
}