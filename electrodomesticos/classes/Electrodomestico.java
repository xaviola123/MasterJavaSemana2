package electrodomesticos.classes;

public abstract class Electrodomestico {
    private double precioBase;
    private Colores color;
    private int peso;
    private String consumoEnergetico;
    private final String[] VALOR_CONSUMO_ENERGETICO = {"A", "B", "C", "D", "E", "F"};


    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public Colores getColor() {
        return color;
    }

    public void setColor(Colores color) {
        this.color = color;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(String consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public String[] getVALOR_CONSUMO_ENERGETICO() {
        return VALOR_CONSUMO_ENERGETICO;
    }

    public Electrodomestico(double precioBase, int peso) {
        this.precioBase = precioBase;
        this.peso = peso;
    }

    public Electrodomestico(double precioBase, Colores color, int peso, String consumoEnergetico) {
        this.precioBase = precioBase;
        this.color = color;
        this.peso = peso;
        this.consumoEnergetico = consumoEnergetico;
    }

    public Electrodomestico() {
        this.color = Colores.BLANCO;
        this.consumoEnergetico = "F";
        this.precioBase = 100.00;
        this.peso = 5;
    }

    public void comprobarConsumoEnergetico(String consumoEnergetico) {
        String consumoEnergeticoUpper = consumoEnergetico.toUpperCase();

        boolean letraValida = false;

        for (String letra : VALOR_CONSUMO_ENERGETICO) {
            if (letra.equals(consumoEnergeticoUpper)) {
                letraValida = true;
                break;
            }
        }

        if (!letraValida) {
            consumoEnergeticoUpper = "F";
        }

        this.consumoEnergetico = consumoEnergeticoUpper;
    }

    public void comprobarColor(String colorString) {
        String colorUpper = colorString.toUpperCase();
        boolean colorValido = false;

        for (Colores color : Colores.values()) {
            if (color.name().equals(colorUpper)) {
                colorValido = true;
                this.color = color;
                break;
            }
        }

        if (!colorValido) {
            this.color = Colores.BLANCO;
        }
    }

    public double precioFinal() {
        double precioFinal = precioBase;

        switch (consumoEnergetico.toUpperCase()) {
            case "A":
                precioFinal += 100;
                break;
            case "B":
                precioFinal += 80;
                break;
            case "C":
                precioFinal += 60;
                break;
            case "D":
                precioFinal += 50;
                break;
            case "E":
                precioFinal += 30;
                break;
            default:
                precioFinal += 10;
                break;
        }

        if (peso >= 0 && peso <= 19) {
            precioFinal += 10;
        } else if (peso >= 20 && peso <= 49) {
            precioFinal += 50;
        } else if (peso >= 50 && peso <= 79) {
            precioFinal += 80;
        } else if (peso >= 80) {
            precioFinal += 100;
        }

        return precioFinal;
    }

    public abstract double precioFinal(int carga);


}
