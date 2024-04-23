package bibilioteca_jdbc_BBDD.clases.usuarios;

public class UsuarioOcasional extends Usuarios {


    public UsuarioOcasional(String dni, String nombre,String tipoUsuario) {
        super(dni, nombre, tipoUsuario);
    }

    public UsuarioOcasional() {
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
