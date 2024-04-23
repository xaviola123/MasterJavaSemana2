package bibilioteca_jdbc_BBDD;



import bibilioteca_jdbc_BBDD.Conexion.Conection;
import bibilioteca_jdbc_BBDD.clases.documentos.Documento;
import bibilioteca_jdbc_BBDD.clases.documentos.Libro;
import bibilioteca_jdbc_BBDD.clases.documentos.Revista;
import bibilioteca_jdbc_BBDD.clases.usuarios.Socio;
import bibilioteca_jdbc_BBDD.clases.usuarios.UsuarioOcasional;
import bibilioteca_jdbc_BBDD.clases.usuarios.Usuarios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static bibilioteca_jdbc_BBDD.interfaces.Funciones.duracionMaximaPrestamo;

public class Main {


    public static void main(String[] args) {
        // Establecer la conexión
        Connection connection = new Conection().conexion;
        String consultaUsuarios = "SELECT DNI, Nombre, TipoUsuario FROM usuarios";
        String consultaDocumentos = "SELECT CodigoAlfanumerico, Titulo, TipoDocumento, EjemplaresDisponibles FROM documentos";

        List<Usuarios> usuariosList = new ArrayList<>();

        try {
            Statement StmUsuarios = connection.createStatement();
            ResultSet resultSetUsuarios = StmUsuarios.executeQuery(consultaUsuarios);

            while (resultSetUsuarios.next()) {
                String dni = resultSetUsuarios.getString("DNI");
                String nombre = resultSetUsuarios.getString("Nombre");
                String tipoUsuario = resultSetUsuarios.getString("TipoUsuario");

                Usuarios usuario = null;

                if (tipoUsuario.equals("Socio")) {
                    usuario = new Socio();
                } else if (tipoUsuario.equals("UsuarioOcasional")) {
                    usuario = new UsuarioOcasional();
                }

                usuario.setDni(dni);
                usuario.setNombre(nombre);
                usuario.setTipoUsuario(tipoUsuario);
                usuariosList.add(usuario);


                System.out.println("Nombre: " + usuario.getNombre() + ", DNI: " + usuario.getDni() + ", Tipo Usuario: " + usuario.getTipoUsuario());
                int maxLoanDuration = duracionMaximaPrestamo(tipoUsuario, "LIBRO");
                System.out.println("Máxima duración de préstamo para libros: " + maxLoanDuration + " días");


            }

            Statement StmDocumentos = connection.createStatement();
            ResultSet resultSetDocumentos = StmDocumentos.executeQuery(consultaDocumentos);

            while (resultSetDocumentos.next()) {
                String codigo = resultSetDocumentos.getString("CodigoAlfanumerico");
                String titulo = resultSetDocumentos.getString("Titulo");
                String tipoDocumento = resultSetDocumentos.getString("TipoDocumento").toUpperCase();

                Documento documento;

                if (tipoDocumento.equals("LIBRO")) {
                    documento = new Libro(codigo, titulo, 10);
                } else {
                    documento = new Revista(codigo, titulo);
                }

                System.out.println("Documento: Código: " + documento.getCodigo() + ", Título: " + documento.getTitulo() + ", Tipo Documento: " + tipoDocumento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
