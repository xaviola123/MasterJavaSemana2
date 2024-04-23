package com.bliblioteca.documentos;

import com.bliblioteca.usuarios.Socio;
import com.bliblioteca.usuarios.UsuarioOcasional;
import com.bliblioteca.usuarios.Usuarios;

public class Revista extends Documento {
    private int cantidadRevistas;
    public Revista(String codigo, String titulo,int cantidadRevistas) {
        super(codigo, titulo);
        this.cantidadRevistas=cantidadRevistas;
    }

    public int getCantidadRevistas() {
        return cantidadRevistas;
    }

    public void setCantidadRevistas(int cantidadRevistas) {
        this.cantidadRevistas = cantidadRevistas;
    }

    @Override
    public int calcularPrestamo(Usuarios usuario) {
        if (usuario instanceof Socio) {
            return super.getTIEMPO_MAXIMO_SOCIO() / 3;
        }
        if (usuario instanceof UsuarioOcasional) {
            return super.getTIEMPO_MAXIMO_OCASIONAL() / 3;
        }
        return 0;
    }
}