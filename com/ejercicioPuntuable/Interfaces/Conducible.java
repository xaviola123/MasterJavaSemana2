package com.ejercicioPuntuable.Interfaces;

public interface Conducible {
    public double avanzar(int kmInicio, int kmFinal,int velocidad);
    public void arrancar(int kmInicio,int kmFinal);
    public void parar();
    public double consumo(double consumo);
    public int actualizarKilometraje();
}
