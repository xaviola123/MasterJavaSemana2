package com.bliblioteca.usuarios;

import com.bliblioteca.Prestable;
import com.bliblioteca.documentos.Documento;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuarios implements Prestable {
    private String DNI;
    private String nombre;
    private int numPrestamos;
    private List<Documento> listaDocumentos = new ArrayList<>();

    public Usuarios(String DNI, String nombre, int numPrestamos) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.numPrestamos = numPrestamos;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumPrestamos() {
        return numPrestamos;
    }

    public List<Documento> getListaDocumentos() {
        return listaDocumentos;
    }

    public void agregarDocumentoUsuario(Documento doc) {

        listaDocumentos.add(doc);
    }

    public void eliminarDocumentoUsuario(Documento doc) {
        listaDocumentos.remove(doc);
    }

    public void listarDocumentosPrestados() {
        if (listaDocumentos.isEmpty()) {
            System.out.println("El usuario no tiene ningún documento prestado.");
        } else {
            System.out.println("Documentos prestados a " + nombre + ":");
            for (Documento documento : listaDocumentos) {
                System.out.println("- " + documento.getTitulo());
            }
        }
    }

    public abstract boolean cantidadPrestamos();
}
