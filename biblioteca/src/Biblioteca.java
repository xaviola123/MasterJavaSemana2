import com.bliblioteca.documentos.Documento;
import com.bliblioteca.documentos.Libro;
import com.bliblioteca.documentos.Revista;
import com.bliblioteca.usuarios.Socio;
import com.bliblioteca.usuarios.UsuarioOcasional;
import com.bliblioteca.usuarios.Usuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private static Documento documentoActual;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear documentos
        Documento libro = new Libro("l1", "El quijote", 1981, 3);
        Documento libro2 = new Libro("l2", "El muerto", 1999, 2);
        Documento libro3 = new Libro("l3", "El perro y el camion", 1961, 9);
        Documento libro4 = new Libro("l4", "El aguila rapaz", 1981, 13);
        Documento libro5 = new Libro("l5", "la historia de siempre", 1993, 1);
        Documento libro6 = new Libro("l6", "El de siempre", 1991, 5);

        Documento revista = new Revista("r1", "La pantoja Ala Carcel", 5);
        Documento revista2 = new Revista("r2", "Revista HOLA", 9);
        Documento revista3 = new Revista("r3", "Revista lecturas", 3);
        Documento revista4 = new Revista("r4", "Revista gamestop", 1);
        Documento revista5 = new Revista("r5", "Revista corazon_DE_MELON", 2);

        // Crear socios
        Usuarios socio = new Socio("12", "JUAN", 10);
        Usuarios socio2 = new Socio("123", "manuel gabriel", 6);
        Usuarios socio3 = new Socio("1234", "anton", 23);
        //crear usuarioOcasionales
        Usuarios uOcasional = new UsuarioOcasional("34", "maria", 2);
        Usuarios uOcasional2 = new UsuarioOcasional("345", "ana", 2);
        Usuarios uOcasional3 = new UsuarioOcasional("3456", "julia", -1);

        // Lista de documentos y usuarios
        List<Documento> documentoList = new ArrayList<>();
        documentoList.add(libro);
        documentoList.add(libro2);
        documentoList.add(libro3);
        documentoList.add(libro4);
        documentoList.add(libro5);
        documentoList.add(revista);
        documentoList.add(revista2);
        documentoList.add(revista3);
        documentoList.add(revista4);
        documentoList.add(revista5);

        List<Usuarios> usuariosList = new ArrayList<>();
        //agrego usuario socios
        usuariosList.add(socio);
        usuariosList.add(socio2);
        usuariosList.add(socio3);
        //agrego Usuarios ocasionales
        usuariosList.add(uOcasional);
        usuariosList.add(uOcasional2);
        usuariosList.add(uOcasional3);

        int option;
        do {
            // Mostrar menú
            mostrarMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    seleccionarDocumento(scanner, documentoList);
                    break;
                case 2:
                    prestarDocumento(scanner, usuariosList, documentoList);
                    break;
                case 3:
                    devolverDocumento(scanner, usuariosList);
                    break;
                case 4:
                    listarUsuariosConLibros(usuariosList);
                    break;
                default:
                    break;
            }
        } while (option != 0);
    }

    private static void mostrarMenu() {
        System.out.println("Pulsa 1 SELECCIONA DOCUMENTO");
        System.out.println("Pulsa 2 Para Prestar Documento");
        System.out.println("Pulsa 3 Para Devolver Documento");
        System.out.println("Pulsa 4 Para ver USUARIOS");
    }

    private static void seleccionarDocumento(Scanner scanner, List<Documento> documentos) {
        System.out.println("Introduce el código del documento a seleccionar: ");
        String codigo = scanner.nextLine();
        documentoActual = buscarDocumento(documentos, codigo);
        if (documentoActual == null) {
            System.out.println("Documento no encontrado.");
        } else {
            System.out.println("Documento seleccionado: " + documentoActual.getTitulo());
        }
    }

    private static Documento buscarDocumento(List<Documento> documentos, String codigo) {
        for (Documento documento : documentos) {
            if (documento.getCodigo().equals(codigo)) {
                return documento;
            }
        }
        return null;
    }

    private static void prestarDocumento(Scanner scanner, List<Usuarios> usuariosList, List<Documento> documentoList) {
        if (documentoActual == null) {
            System.out.println("No hay ningún documento seleccionado.");
        } else {
            System.out.println("Introduce el DNI del usuario al que se va a prestar el documento: ");
            String dni = scanner.nextLine();
            Usuarios usuario = buscarUsuario(usuariosList, dni);
            if (usuario == null) {
                System.out.println("Usuario no encontrado.");
            } else if (!usuario.cantidadPrestamos()) {
                System.out.println("El usuario ha alcanzado el límite de préstamos.");
            } else if (!documentoActual.estaDisponible()) {
                System.out.println("El documento seleccionado ya está prestado.");
            } else {
                for (Documento documento : documentoList) {
                    if (documento instanceof Libro) {
                        if (((Libro) documento).getCantidadLibros() > 0) {
                            usuario.agregarDocumentoUsuario(documentoActual);
                            documentoActual.setPrestado(true);
                            ((Libro) documento).setCantidadLibros(((Libro) documento).getCantidadLibros() - 1);
                            System.out.println("Documento prestado correctamente a " + usuario.getNombre() +
                                    " Numero documentos actualizado: " + (usuario.getNumPrestamos() + 1));
                            System.out.println("Cantidad de libros--->" + (((Libro) documento).getCantidadLibros()-1));
                            break;
                        }
                    } else if (documento instanceof Revista) {
                        if (((Revista) documento).getCantidadRevistas() > 0) {
                            usuario.agregarDocumentoUsuario(documentoActual);
                            documentoActual.setPrestado(true);
                            ((Revista) documento).setCantidadRevistas(((Revista) documento).getCantidadRevistas() - 1);
                            System.out.println("Documento prestado correctamente a " + usuario.getNombre() +
                                    " Numero documentos actualizado: " + (usuario.getNumPrestamos() + 1));
                            System.out.println("Cantidad de revistas--->" + (((Revista) documento).getCantidadRevistas()-1));
                            break;
                        }
                    }
                }
            }
        }
    }

    private static Usuarios buscarUsuario(List<Usuarios> usuariosList, String dni) {
        for (Usuarios usuario : usuariosList) {
            if (usuario.getDNI().equals(dni)) {
                return usuario;
            }
        }
        return null;
    }

    private static void devolverDocumento(Scanner scanner, List<Usuarios> usuariosList) {
        if (documentoActual == null) {
            System.out.println("No hay ningún documento seleccionado.");
        } else {
            // Mostrar lista de documentos prestados
            System.out.println("Lista de documentos prestados:");
            for (Usuarios usuario : usuariosList) {
                if (usuario.getListaDocumentos().contains(documentoActual)) {
                    System.out.println("- " + documentoActual.getTitulo() + "con el codigo " + documentoActual.getCodigo() + " prestado a " + usuario.getNombre());
                }
            }

            // Pedir el código del documento a devolver
            System.out.println("Introduce el código del documento a devolver: ");
            String codigoDocumento = scanner.nextLine();
            Documento documentoDevolver = buscarDocumentoPorCodigo(codigoDocumento, usuariosList);

            // Verificar si el documento está prestado
            if (documentoDevolver == null) {
                System.out.println("El documento no está prestado o no existe.");
            } else {
                // Obtener el usuario que tiene prestado el documento
                Usuarios usuario = buscarUsuarioPorDocumento(documentoDevolver, usuariosList);
                if (usuario == null) {
                    System.out.println("Error: no se encontró el usuario que tiene prestado el documento.");
                } else {
                    usuario.eliminarDocumentoUsuario(documentoDevolver);
                    documentoDevolver.setPrestado(false);
                    System.out.println("Documento devuelto correctamente por " + usuario.getNombre() + "Numero de documentos actualizado " + (usuario.getNumPrestamos() - 1));
                }
            }
        }
    }

    private static Documento buscarDocumentoPorCodigo(String codigo, List<Usuarios> usuariosList) {
        for (Usuarios usuario : usuariosList) {
            for (Documento documento : usuario.getListaDocumentos()) {
                if (documento.getCodigo().equals(codigo)) {
                    return documento;
                }
            }
        }
        return null;
    }

    private static Usuarios buscarUsuarioPorDocumento(Documento documento, List<Usuarios> usuariosList) {
        for (Usuarios usuario : usuariosList) {
            if (usuario.getListaDocumentos().contains(documento)) {
                return usuario;
            }
        }
        return null;
    }

    private static void listarUsuariosConLibros(List<Usuarios> usuariosList) {
        for (Usuarios usuario : usuariosList) {
            System.out.println("Usuario: " + usuario.getNombre());
            usuario.listarDocumentosPrestados();
            System.out.println();
        }
    }
}
