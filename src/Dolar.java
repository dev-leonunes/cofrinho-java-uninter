public class Dolar extends Moeda {
    public Dolar(double valor) {
        super(valor, "Dolar", 5.5);
    }

    @Override
    public void info() {
        System.out.println("Dolar " + valor);
    }

    @Override
    public double converter() {
        return valor * cotacao;
    }
}
