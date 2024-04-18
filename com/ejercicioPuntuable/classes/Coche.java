package com.ejercicioPuntuable.classes;

import java.util.Scanner;

public class Coche extends Vehiculo{
    private  final int NUM_RUEDAS=4;
    private String colorCoche;
    private TipoCombustible tipoCombustible;


    private double consumo;



    public Coche(String colorCoche) {
        this.colorCoche = colorCoche;
    }

    public Coche(String modelo,String matricula, int depositCombustible, int kilometraje, String colorCoche,int velocidad,TipoCombustible tipoCombustible,double consumo) {
        super(modelo, matricula,depositCombustible, kilometraje,velocidad);
        this.colorCoche = colorCoche;
        this.tipoCombustible= tipoCombustible;
        this.consumo=consumo;
    }

    public String getColorCoche() {
        return colorCoche;
    }

    public void setColorCoche(String colorCoche) {
        this.colorCoche = colorCoche;
    }

    public int getNUM_RUEDAS() {
        return NUM_RUEDAS;
    }

    /**
     * metodo to string para mostrar los atributos del objeto
     * @return
     */
    @Override
    public String toString() {
        return "Caracteristicas Coche-------------->>>>>>>{" +
                "NUM_RUEDAS=" + NUM_RUEDAS +
                ", colorCoche='" + colorCoche + '\'' +
                ", tipoCombustible=" + tipoCombustible +
                ", consumo=" + consumo +
                '}';
    }

    /**
     * este metodo cambia el color del vehiculo segun el parametro que le llegue y tiene un switch
     * para confirmar o cancelar el cambio de color.
     * @param color
     */
    @Override
    public void cambiarColor(String color) {
/* este metodo sacaba una ventana JoptionPane para confirmas si querias o no, cambiar el color del coche.
pero decicdi hacerlo con switch mejor, por tiempo.
        Component componentePadre = null;

        int confirmado = JOptionPane.showConfirmDialog(
                componentePadre,
                "¿Lo confirmas? cambiar tu coche al color "+color+" ????");

        if (JOptionPane.OK_OPTION == confirmado) {
            System.out.println("confirmado");
            this.colorCoche = color;
            System.out.println("Color del coche cambiado... tu color nuevo es: " + this.colorCoche);
        }
        else{
            System.out.println("Color del coche, no cambiado... tu color es: "+this.colorCoche);
        }
*/
        super.cambiarColor(color);

//menu para elecion de si cambiar color de coche o no

        System.out.println("el coche "+this.getModelo()+" tiene el color "+this.colorCoche);
        System.out.println("Quieres cambiar el color del coche a "+color+"???");
        System.out.println("-------------------------");
        System.out.println("pulsa 1 para confirmar");
        System.out.println("pulsa 2 para cancelar");

        int option = scanner.nextInt();
        switch (option){
            case 1:
                this.colorCoche=color;
                System.out.println("Color del coche ha CAMBIADO... tu color nuevo es-----> "+this.colorCoche);
                break;
            case 2:
                System.out.println("Color del coche, no cambiado... tu color es------> "+this.colorCoche);
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
