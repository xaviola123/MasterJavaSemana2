package com.bliblioteca;

import com.bliblioteca.usuarios.Usuarios;

public interface Prestable {
    boolean estaDisponible();

    int calcularPrestamo(Usuarios usuario);
}

