public class Peso extends Moeda {
    public Peso(double valor) {
        super(valor, "Peso", 0.05);
    }

    @Override
    public void info() {
        System.out.println("Peso " + valor);
    }

    @Override
    public double converter() {
        return valor * cotacao;
    }
}
