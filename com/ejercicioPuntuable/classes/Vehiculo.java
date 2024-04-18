package com.ejercicioPuntuable.classes;

import com.ejercicioPuntuable.Interfaces.Conducible;

import java.util.Scanner;

public abstract class Vehiculo implements Conducible {
    Scanner scanner = new Scanner(System.in);
    protected String modelo;
    protected double depositoCombustible;
    protected int kilometraje;
    protected int kmIncioViaje;
    protected int kmFinalViaje;
    private static  String matricula ;
    private int velocidad;
    private double tiempoViaje;
    private int distanciaRecorrida;
    private double  combustibleGastado;

    public Vehiculo(){

    }
    public Vehiculo(String modelo, String matricula,double depositoCombustible, int kilometraje ,int velocidad) {
        this.modelo = modelo;
        this.depositoCombustible = depositoCombustible;
        this.kilometraje = kilometraje;
        this.velocidad = velocidad;
        this.matricula = matricula;

    }
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public double getDepositoCombustible() {
        return depositoCombustible;
    }

    public void setDepositoCombustible(double depositoCombustible) {
        this.depositoCombustible = depositoCombustible;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public int getKmIncioViaje() {
        return kmIncioViaje;
    }

    public void setKmIncioViaje(int kmIncioViaje) {
        this.kmIncioViaje = kmIncioViaje;
    }

    public int getKmFinalViaje() {
        return kmFinalViaje;
    }

    public void setKmFinalViaje(int kmFinalViaje) {
        this.kmFinalViaje = kmFinalViaje;
    }

    public static String getMatricula() {
        return matricula;
    }

    public static void setMatricula(String matricula) {
        Vehiculo.matricula = matricula;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public double getTiempoViaje() {
        return tiempoViaje;
    }
    public void setTiempoViaje(double tiempoViaje) {
        this.tiempoViaje = tiempoViaje;
    }

    //-------------------------------------------------------------------------------------------------------------//

    public  void cambiarColor(String color){

    };
    /**
     * este motodo devuelve un texto si el viaje se a iniciado o apagamos el coche atraves de un switch
     * para controlar la decision que queremos tomar.
     * @param kmIncioViaje
     * @param kmFinalViaje
     */

    @Override
    public void arrancar(int kmIncioViaje,int kmFinalViaje) {

        System.out.println("Con el mododelo de coche: "+ this.getModelo());
        System.out.println(" MATRICULA--> "+getMatricula());
        System.out.println(" DEPOSITO-----> "+this.getDepositoCombustible()+" LITROS");
        System.out.println("==============================================================================");
        System.out.println("Comenzar viaje pulsa 1");
        System.out.println("Apagar  pulsa 2");

        int option2 = scanner.nextInt();
        switch (option2){
            case 1:
                System.out.println("Arrancando....");


                if(this.getDepositoCombustible()>0){
                    avanzar(kmIncioViaje,kmFinalViaje,this.getVelocidad());
                    parar();



                }else{
                    System.out.println("Tienes que repostar");
                }

                break;
            case 2:
                System.out.println("VEHICULO APAGADO!!!");

                break;
        }
    }


    /**
     * este metodo saca el tiempo que nos llevo el viaje
     * @param kmInicio km donde inicia el trayecto puede ser 0 o mayor.
     * @param kmFinal   km donde finaliza el trayecto
     * @param velocidad
     * @return tiempo de viaje
     */

    @Override
    public double avanzar(int kmInicio, int kmFinal,int velocidad) {

        double tiempoViaje;
        this.distanciaRecorrida=kmFinal-kmInicio;
        tiempoViaje = (this.distanciaRecorrida/velocidad);
        StringBuilder concatenar =new StringBuilder();
        System.out.println( concatenar.append("Distancia Recorrida >>>> "+this.distanciaRecorrida+" KM "+
                         "el tiempo de viaje a sido: >>>>>"+tiempoViaje+" (horas)"));
        return tiempoViaje;
    }


    /**
     * metodo que nos dice que nuestro trayecto acabo e invoca al metodo actualizarKilometraje
     * que nos actualizara el cuentaKilometros
     */

    @Override
    public void parar() {

        actualizarKilometraje();

    }


    /**
     * metodo que nos dice el gasto de combustible y si no llega el combustible nos dice que tenemos que para a repostar
     * @param consumo consumo del vehiculo 5.6,8.1, en 100 km
     * @return nos devuelve el combustible que nos queda en caso de sobrar y si no es asi tenemos que repostar
     */

    @Override
    public double consumo(double consumo) {
        System.out.println("DISTANCIA: "+distanciaRecorrida+" km");
        System.out.println("Capacidad del deposito:"+this.getDepositoCombustible()+" LITROS");

        this.combustibleGastado = distanciaRecorrida*consumo/100;
        double combustibleRestante =this.getDepositoCombustible()-combustibleGastado;

        System.out.println("Consumo del coche en: "+this.distanciaRecorrida+" km es de "+combustibleGastado+" litros");

        if(combustibleRestante<=0){
            System.out.println("tienes que repostar: ");

        }else{
            System.out.println("Queda en el deposito "+combustibleRestante+" litos");
        }
        return combustibleRestante;
    }

    /**
     * metodo que nos devuelve el cuentaKilometros actualizado.Segun el viaje echo.
     * @return nos devuelve el cuenta Kilometros actualizado segun el viaje que hemos realizado
     */
    @Override
    public int actualizarKilometraje() {
        int kilometrajeActualizado;
        kilometrajeActualizado = this.getKilometraje()+distanciaRecorrida;
        System.out.println("Kilometraje antes de la salida "+this.getKilometraje()+" kilometraje despues del viaje "+kilometrajeActualizado);
        return kilometrajeActualizado;
    }
}
