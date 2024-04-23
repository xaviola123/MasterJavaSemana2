package bibilioteca_jdbc_BBDD.clases.usuarios;

import bibilioteca_jdbc_BBDD.interfaces.Prestable;

public abstract class Usuarios implements Prestable {
    private String dni;
    private String nombre;
    private String tipoUsuario;

    public Usuarios(String dni, String nombre, String tipoUsuario) {
        this.dni = dni;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuarios() {

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public abstract boolean estaDisponible();

    public abstract int calcularPrestamo(Usuarios usuario);

}
