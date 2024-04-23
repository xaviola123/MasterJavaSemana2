package electrodomesticos.aplication;

import electrodomesticos.classes.Colores;
import electrodomesticos.classes.Electrodomestico;
import electrodomesticos.classes.Lavadora;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Electrodomestico lavadora = new Lavadora(100.00, Colores.BLANCO, 20, "F", 5);
        Electrodomestico lavadora2 = new Lavadora(135.00, Colores.BLANCO, 15, "F", 5);
        Electrodomestico lavadora3 = new Lavadora(150, Colores.BLANCO, 50, "F", 10);
        List<Electrodomestico> electrodomesticoList = new ArrayList<>();
        electrodomesticoList.add(lavadora);
        electrodomesticoList.add(lavadora2);
        electrodomesticoList.add(lavadora3);

        for (Electrodomestico unElectradomestico : electrodomesticoList) {
            if (unElectradomestico instanceof Lavadora) {
                ((Lavadora) unElectradomestico).comprobarColor("perro");
                ((Lavadora) unElectradomestico).comprobarConsumoEnergetico("g");
                double precioFinal = ((Lavadora) unElectradomestico).precioFinal();
                System.out.println("Precio final de la lavadora: " + precioFinal);
            }
        }
    }
}
