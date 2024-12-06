public class Euro extends Moeda {
    public Euro(double valor) {
        super(valor, "Euro", 6.5);
    }

    @Override
    public void info() {
        System.out.println("Euro " + valor);
    }

    @Override
    public double converter() {
        return valor * cotacao;
    }
}
