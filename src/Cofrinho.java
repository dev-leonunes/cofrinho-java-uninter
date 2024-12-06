import java.util.ArrayList;

public class Cofrinho {
    private ArrayList<Moeda> listaMoedas = new ArrayList<>();

    public ArrayList<Moeda> getListaMoedas() {
        return listaMoedas;
    }

    public void adicionar(Moeda moeda) {
        listaMoedas.add(moeda);
    }

    public void remover(Moeda moeda) {
        listaMoedas.remove(moeda);
    }

    public void listar() {
        for (Moeda moeda : listaMoedas) {
            moeda.info();
        }
    }

    public void totalConvertido() {
        double total = 0.0;
        for (Moeda moeda : listaMoedas) {
            total += moeda.converter();
        }
        System.out.println("Total em Reais: R$ " + total);
    }
}
