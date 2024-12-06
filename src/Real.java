public class Real extends Moeda {
    public Real(double valor) {
        super(valor, "Real", 1.0);
    }

    @Override
    public void info() {
        System.out.println("Real " + valor);
    }

    @Override
    public double converter() {
        return valor * cotacao;
    }
}
