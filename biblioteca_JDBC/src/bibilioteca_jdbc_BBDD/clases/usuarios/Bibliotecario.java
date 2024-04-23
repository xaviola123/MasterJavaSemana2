package bibilioteca_jdbc_BBDD.clases.usuarios;

import bibilioteca_jdbc_BBDD.clases.documentos.Documento;

import java.util.List;

public class Bibliotecario {
    private Documento documentoActual;

    public void seleccionaDocumento(String codigo, List<Documento> documentos) {
        for (Documento documento : documentos) {
            if (documento.getCodigo().equals(codigo)) {
                documentoActual = documento;
                return;
            }
        }
        System.out.println("No se encontró ningún documento con el código " + codigo);
    }

    public void prestaDocumentoActual(String dni, Usuarios usuario) {
        if (documentoActual == null) {
            System.out.println("No hay ningún documento seleccionado.");
            return;
        }

        if (documentoActual.estaPrestado()) {
            System.out.println("No es posible prestar el documento actual.");
            return;
        }

        documentoActual.setPrestado(true);
        System.out.println("El documento " + documentoActual.getTitulo() + " ha sido prestado a " + usuario.getNombre());
    }

    public void devuelveDocumentoActual() {
        if (documentoActual == null) {
            System.out.println("No hay ningún documento seleccionado.");
            return;
        }

        if (!documentoActual.estaPrestado()) {
            System.out.println("El documento no está prestado.");
            return;
        }

        documentoActual.setPrestado(false);
        System.out.println("El documento " + documentoActual.getTitulo() + " ha sido devuelto.");
    }
}