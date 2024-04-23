package bibilioteca_jdbc_BBDD.clases.documentos;

public abstract class Documento {
    private String codigo;
    private String titulo;

    public Documento(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public abstract int calcularDuracionMaximaPrestamo();

    public abstract boolean estaPrestado();

    public void setPrestado(boolean b) {
    }
}