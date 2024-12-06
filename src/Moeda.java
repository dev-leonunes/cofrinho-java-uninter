public abstract class Moeda {
    protected double valor;
    protected String moeda;
    protected double cotacao;

    public Moeda(double valor, String moeda, double cotacao) {
        this.valor = valor;
        this.moeda = moeda;
        this.cotacao = cotacao;
    }

    public double getValor() {
        return valor;
    }

    public String getMoeda() {
        return moeda;
    }

    public double getCotacao() {
        return cotacao;
    }

    public abstract void info();

    public abstract double converter();
}
