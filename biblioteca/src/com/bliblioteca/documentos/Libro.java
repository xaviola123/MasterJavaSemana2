package com.bliblioteca.documentos;

import com.bliblioteca.usuarios.Socio;
import com.bliblioteca.usuarios.UsuarioOcasional;
import com.bliblioteca.usuarios.Usuarios;

public class Libro extends Documento {
    private int anioPublicacion;
    private int cantidadLibros;

    public Libro(String codigo, String titulo, int anioPublicacion,int cantidadLibros) {
        super(codigo, titulo);
        this.anioPublicacion = anioPublicacion;
        this.cantidadLibros=cantidadLibros;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    @Override
    public int calcularPrestamo(Usuarios usuario) {
        if (usuario instanceof Socio) {
            return super.getTIEMPO_MAXIMO_SOCIO();
        }
        if (usuario instanceof UsuarioOcasional) {
            return super.getTIEMPO_MAXIMO_OCASIONAL();
        }
        return 0;
    }
}
