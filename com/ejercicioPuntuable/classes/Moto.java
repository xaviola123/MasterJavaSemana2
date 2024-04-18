package com.ejercicioPuntuable.classes;

import java.util.Scanner;

public class Moto extends Vehiculo{
    private  final int NUM_RUEDAS=2;
    private TipoCombustible tipoCombustible;
    private String colorMoto;
    private double consumo;

    public Moto(String colorMoto, double consumo) {
        this.colorMoto = colorMoto;
        this.consumo = consumo;
    }

    public Moto(String modelo, String matricula,double depositoCombustible, int kilometraje, int velocidad, String colorMoto,TipoCombustible tipoCombustible) {
        super(modelo, matricula,depositoCombustible, kilometraje,velocidad);
        this.colorMoto = colorMoto;
        this.tipoCombustible=tipoCombustible;

    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getColorMoto() {
        return colorMoto;
    }

    public void setColorMoto(String colorMoto) {
        this.colorMoto = colorMoto;
    }

    public int getNUM_RUEDAS() {
        return NUM_RUEDAS;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }




    @Override
    public String toString() {
        return "Carateristicas MOTO-------->{" +
                "NUM_RUEDAS=" + NUM_RUEDAS +
                ", tipoCombustible=" + tipoCombustible +
                ", colorMoto='" + colorMoto + '\'' +
                ", consumo=" + consumo +
                '}';
    }


    @Override
    public void cambiarColor(String color) {

        super.cambiarColor(color);
        Scanner scanner = new Scanner(System.in);
        System.out.println("la moto tiene el color "+this.colorMoto);
        System.out.println("Quieres cambiar el color dela moto a "+color+"???");
        System.out.println("-------------------------");
        System.out.println("pulsa 1 para confirmar");
        System.out.println("pulsa 2 para cancelar");

        int option = scanner.nextInt();
        switch (option){
            case 1:
                this.colorMoto=color;
                System.out.println("Color del moto cambiado... tu color nuevo es: "+this.colorMoto);
                break;
            case 2:
                System.out.println("Color del moto, no cambiado... tu color es: "+this.colorMoto);
                break;
        }


    }

    /**
     * este motodo arrancar nos dice que el coche se pone en marcha el modelo y su combustible actual.
     */
    @Override
    public void arrancar(int kmIncio,int kmFinal) {
        super.arrancar( kmIncio, kmFinal);

    }

    /**
     * este metodo calcula la distancia recorrida!!!
     *
     * @param kmInicio
     * @param kmFinal
     * @return
     */
    @Override
    public double avanzar(int kmInicio, int kmFinal,int velocidad) {
        return super.avanzar(kmInicio,kmFinal,velocidad);

    }

    @Override
    public void parar() {
        super.parar();

    }

    @Override
    public double consumo(double consumo) {
        return super.consumo(consumo);


    }
}



