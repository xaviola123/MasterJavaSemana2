package com.ejercicioPuntuable.Main;

import com.ejercicioPuntuable.classes.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String selecion ;

        Vehiculo coche = new Coche("Mercedes Clase A","1956wld",30,150,"NEGRO",100,TipoCombustible.GASOLINA,6.5);
        Vehiculo coche2 = new Coche("Fiat 500L","1554QLK",21,200,"NEGRO",80,TipoCombustible.DIESEl,5.8);
        Vehiculo moto = new Moto("suzuki","1596xls",15,300,100,"AZUL", TipoCombustible.GASOLINA);
        Vehiculo camion = new Camion ("GranCamion","1956qql",500,65000,90,"VERDE",TipoCombustible.DIESEl);

        List<Vehiculo> vehiculoList = new ArrayList<>();
        vehiculoList.add(coche);
        vehiculoList.add(coche2);
        vehiculoList.add(moto);
        vehiculoList.add(camion);


        for (Vehiculo unVehiculo : vehiculoList){
            if(unVehiculo instanceof Coche){
                selecion = JOptionPane.showInputDialog("elije el color a cambiar",JOptionPane.QUESTION_MESSAGE);
                ((Coche)unVehiculo).cambiarColor(selecion);
                ((Coche)unVehiculo).arrancar(0,150);
                ((Coche)unVehiculo).consumo(7.6);
            }

            if(unVehiculo instanceof Moto){
                selecion = JOptionPane.showInputDialog("elije el color a cambiar",JOptionPane.QUESTION_MESSAGE);
                ((Moto)unVehiculo).cambiarColor(selecion);
                ((Moto)unVehiculo).arrancar(0,100);
                ((Moto)unVehiculo).consumo(4.6);

            }
            System.out.println("------------------------------------------------------------------------------");
            if(unVehiculo instanceof Camion){
                selecion = JOptionPane.showInputDialog("elije el color a cambiar",JOptionPane.QUESTION_MESSAGE);
                ((Camion)unVehiculo).cambiarColor(selecion);
                ((Camion)unVehiculo).arrancar(0,600);
                ((Camion)unVehiculo).consumo(10.6);
                ((Camion)unVehiculo).tacometro(0,350,5);
            }
        }
    }
}
