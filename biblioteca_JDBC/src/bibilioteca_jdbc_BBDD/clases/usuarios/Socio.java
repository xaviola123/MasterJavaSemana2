package bibilioteca_jdbc_BBDD.clases.usuarios;

public class Socio extends Usuarios{

    public Socio(String dni, String nombre, String tipoUsuario) {
        super(dni, nombre, tipoUsuario);

    }

    public Socio() {
        super();
    }

    @Override
    public boolean estaDisponible() {
        return false;
    }

    @Override
    public int calcularPrestamo(Usuarios usuario) {
        return 0;
    }

    @Override
    public void calcularPrestamoLibro() {

    }
}
