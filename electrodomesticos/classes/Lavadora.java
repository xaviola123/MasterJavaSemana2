package electrodomesticos.classes;

public class Lavadora extends Electrodomestico {
    private final int carga;

    public Lavadora() {
        this.carga = 5;
    }

    public Lavadora(double precioBase, int peso) {
        super(precioBase, peso);
        this.carga = 5;
    }

    public Lavadora(double precioBase, Colores color, int peso, String consumoEnergetico, int carga) {
        super(precioBase, color, peso, consumoEnergetico);
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    @Override
    public double precioFinal() {
        double precioFinal = super.precioFinal();

        if (getCarga() > 30) {
            precioFinal += 50;
        }

        return precioFinal;
    }

    @Override
    public double precioFinal(int carga) {
        return precioFinal();
    }
}
