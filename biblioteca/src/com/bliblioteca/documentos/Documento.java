package com.bliblioteca.documentos;

import com.bliblioteca.FuncionesDocumentos;
import com.bliblioteca.Prestable;
import com.bliblioteca.usuarios.Socio;
import com.bliblioteca.usuarios.UsuarioOcasional;
import com.bliblioteca.usuarios.Usuarios;

public abstract class Documento implements Prestable, FuncionesDocumentos {

    private String codigo;
    private String titulo;
    private boolean prestado;
    private final int TIEMPO_MAXIMO_SOCIO = 30;
    private final int TIEMPO_MAXIMO_OCASIONAL = 15;



    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTIEMPO_MAXIMO_SOCIO() {
        return TIEMPO_MAXIMO_SOCIO;
    }

    public int getTIEMPO_MAXIMO_OCASIONAL() {
        return TIEMPO_MAXIMO_OCASIONAL;
    }

    public Documento(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.prestado = false;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public boolean estaDisponible() {
        return !prestado;
    }

    @Override
    public boolean buscarDocumento(String codigo) {
        return this.codigo.equals(codigo);
    }

    @Override
    public int calcularPrestamo(Usuarios usuario) {
        if (usuario instanceof Socio) {
            return usuario.getNumPrestamos() >= 0 ? TIEMPO_MAXIMO_SOCIO : 0;
        }
        if (usuario instanceof UsuarioOcasional) {
            return usuario.getNumPrestamos() >= 0 ? TIEMPO_MAXIMO_OCASIONAL : 0;
        }
        return 0;
    }
}
