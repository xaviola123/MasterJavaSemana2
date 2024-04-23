package bibilioteca_jdbc_BBDD.interfaces;

public interface Funciones {
    public static int duracionMaximaPrestamo(String tipoUsuario, String tipoDocumento) {
        if (tipoDocumento.equals("LIBRO")) {
            if (tipoUsuario.equals("Socio")) {

                return 30;
            } else if (tipoUsuario.equals("UsuarioOcasional")) {

                return 15;
            }
        } else if (tipoDocumento.equals("REVISTA")) {

            int duracionLibro = duracionMaximaPrestamo(tipoUsuario, "LIBRO");
            if (duracionLibro != -1) {
                return duracionLibro / 3;
            }
        }

        return -1;
    }
}
