package com.bliblioteca.usuarios;

public class Socio extends Usuarios {

    public Socio(String DNI, String nombre, int numPrestamos) {
        super(DNI, nombre, numPrestamos);
    }

    @Override
    public boolean cantidadPrestamos() {
        return getNumPrestamos() >= 0 && getNumPrestamos() <= 20;
    }

    @Override
    public boolean estaDisponible() {
        return false;
    }

    @Override
    public int calcularPrestamo(Usuarios usuario) {
        return 0;
    }
}