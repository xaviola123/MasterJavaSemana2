package com.ejercicioPuntuable.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Camion extends Vehiculo {
    Random random = new Random();
    private final int NUMRUEDAS = 10;
    private List<Integer> tacometro;
    private String colorCamion;
    private TipoCombustible tipoCombustible;

    private double consumo;




    public Camion(String modelo,String matricula, double depositoCombustible, int kilometraje, int velocidad, String colorCamion,TipoCombustible tipoCombustible) {
        super(modelo, matricula,depositoCombustible, kilometraje, velocidad);
        this.colorCamion = colorCamion;
        this.consumo = consumo;
        this.tipoCombustible=tipoCombustible;
    }

    public List<Integer> getTacometro() {
        return tacometro;
    }

    public void setTacometro(List<Integer> tacometro) {
        this.tacometro = tacometro;
    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getColorCamion() {
        return colorCamion;
    }

    public void setColorCamion(String colorCamion) {
        this.colorCamion = colorCamion;
    }

    public int getNUMRUEDAS() {
        return NUMRUEDAS;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    @Override
    public String toString() {
        return "Caracteristicas Camion------>{" +
                "NUMRUEDAS=" + NUMRUEDAS +
                ", tacometro=" + tacometro +
                ", colorCamion='" + colorCamion + '\'' +
                ", tipoCombustible=" + tipoCombustible +
                ", consumo=" + consumo +
                '}';
    }

    @Override
    public void cambiarColor(String color) {
        super.cambiarColor(color);
        Scanner scanner = new Scanner(System.in);
        System.out.println("el camion tiene el color "+this.colorCamion);
        System.out.println("Quieres cambiar el color del coche a "+color+"???");
        System.out.println("-------------------------");
        System.out.println("pulsa 1 para confirmar");
        System.out.println("pulsa 2 para cancelar");

        int option = scanner.nextInt();
        switch (option){
            case 1:
                this.colorCamion=color;
                System.out.println("Color del camion cambiado... tu color nuevo es: "+this.colorCamion);
                break;
            case 2:
                System.out.println("Color del camion, no cambiado... tu color es: "+this.colorCamion);
                break;
        }

    }


    @Override
    public void arrancar(int kmInicio,int kmFinal) {
        super.arrancar(kmInicio, kmFinal);
        System.out.println("----------------------------------------------------------------");
        System.out.println("Con el mododelo de camion: " + this.getModelo() + " Combustible: " + this.getDepositoCombustible());



    }

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


    /**
     * Atraves de un random genero que se suba o baje la velocidad del camion de forma aleatoria siempre que esta no sea
     * negativa, ademas la almaceno en un arraylist para despues mostrar el tacometro dentro de ese trayecto.-
     * @param kmInicioViaje
     * @param kmFinalViaje
     * @param velocidadInicial
     * @return devuleve una lista de velocidades en un trayecto
     */
    public List<Integer> tacometro(int kmInicioViaje, int kmFinalViaje, int velocidadInicial) {
        ArrayList<Integer> tacometro = new ArrayList<>();
        int velocidad = 0;
        Random random = new Random();

        for (int i = kmInicioViaje; i < kmFinalViaje; i += 10) {
            int numeroAleatorio = random.nextInt(5) + 1;

            switch (numeroAleatorio) {
                case 1:
                    velocidad += 10;
                    System.out.println("Tramo " + ((i - kmInicioViaje) / 10 + 1) + " km " + i + " - Acelero 10 km/h"+" velocidad--->"+velocidad);
                    if (velocidad > 90) {
                        System.out.println("Ha sobrepasado el límite de velocidad. No puedes pasar de 90 km/h"+" velocidad--->"+velocidad);
                        velocidad = 90;
                    }
                    break;
                case 2:
                    velocidad += 15;
                    System.out.println("Tramo " + ((i - kmInicioViaje) / 10 + 1) + " km " + i + " - Acelero 15 km/h"+" velocidad--->"+velocidad);
                    if (velocidad > 90) {
                        velocidad = 90;
                        System.out.println("Ha sobrepasado el límite de velocidad. No puedes pasar de 90 km/h"+" velocidad--->"+velocidad);

                    }
                    break;
                case 3:
                    velocidad += 20;
                    System.out.println("Tramo " + ((i - kmInicioViaje) / 10 + 1) + " km " + i + " - Acelero 20 km/h"+" velocidad--->"+velocidad);
                    if (velocidad > 90) {
                        velocidad = 90;
                        System.out.println("Ha sobrepasado el límite de velocidad. No puedes pasar de 90 km/h"+" velocidad--->"+velocidad);

                    }
                    break;
                case 4:
                    velocidad -= 10;
                    System.out.println("Tramo " + ((i - kmInicioViaje) / 10 + 1) + " km " + i + " - Reduzco 10 km/h "+" velocidad--->"+velocidad);
                    if (velocidad < 0) {
                        System.out.println("Estoy parado..");
                        velocidad = 0;
                    }
                    break;
                case 5:
                    velocidad -= 20;
                    System.out.println("Tramo " + ((i - kmInicioViaje) / 10 + 1) + " km " + i + " - Reduzco 20 km/h"+" velocidad--->"+velocidad);
                    if (velocidad < 0) {
                        System.out.println("Estoy parado..");
                        velocidad = 0;
                    }
                    break;
            }
            tacometro.add(velocidad);
        }
        return tacometro;
    }


}




