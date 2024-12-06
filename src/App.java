import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Cofrinho cofrinho = new Cofrinho();
        Scanner scanner = new Scanner(System.in);
        int opcaoTarefa = 0;

        while (opcaoTarefa != 5) {
            try {
                menuPrincipal();
                opcaoTarefa = scanner.nextInt();

                switch (opcaoTarefa) {
                    case 1:
                        scanner.nextLine();
                        System.out.println("Selecione o tipo de moeda:");
                        moedaOpcoes();
                        int tipoMoeda = scanner.nextInt();

                        System.out.print("Digite o valor: ");
                        double valor = scanner.nextDouble();

                        Moeda moeda;

                        switch (tipoMoeda) {
                            case 1:
                                moeda = new Dolar(valor);
                                break;
                            case 2:
                                moeda = new Euro(valor);
                                break;
                            case 3:
                                moeda = new Real(valor);
                                break;
                            default:
                                System.out.println("Opcao invalida");
                                continue;
                        }

                        cofrinho.adicionar(moeda);
                        System.out.println("\nMoeda adicionada");
                        break;
                    case 2:
                        System.out.println("Selecione o tipo de moeda:");
                        moedaOpcoes();
                        int tipoMoedaRemover = scanner.nextInt();

                        System.out.print("Qual o valor da moeda que deseja remover? ");
                        double valorMoeda = scanner.nextDouble();

                        Moeda moedaRemover = null;

                        switch (tipoMoedaRemover) {
                            case 1:
                                moedaRemover = new Dolar(valorMoeda);
                                break;
                            case 2:
                                moedaRemover = new Euro(valorMoeda);
                                break;
                            case 3:
                                moedaRemover = new Real(valorMoeda);
                                break;
                            default:
                                System.out.println("\nOpcao invalida");
                                break;
                        }

                        int index = 0;

                        for (Moeda m : cofrinho.getListaMoedas()) {
                            if (m.getMoeda() == moedaRemover.moeda && m.getValor() == moedaRemover.valor) {
                                cofrinho.remover(m);
                                index++;
                                break;
                            }
                        }

                        if (index > 0) {
                            System.out.println("\nMoeda removida");
                        } else {
                            System.out.println("\nMoeda nao encontrada");
                        }
                        continue;
                    case 3:
                        if (cofrinho.getListaMoedas().isEmpty()) {
                            System.out.println("\n--------------------");
                            System.out.println("Cofrinho vazio");
                            System.out.println("--------------------");
                            break;
                        } else {
                            System.out.println("\n--------------------");
                            System.out.println("Moedas no cofrinho:");
                            cofrinho.listar();
                            System.out.println("--------------------");
                            break;
                        }
                    case 4:
                        System.out.println("\n--------------------");
                        cofrinho.totalConvertido();
                        System.out.println("--------------------");
                        break;
                    case 5:
                        System.out.println("\nSaindo...");
                        break;
                    default:
                        System.out.println("\nOpcao invalida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nEntrada inválida. Por favor, insira um número.");
                scanner.next();
            } catch (NoSuchElementException | IllegalStateException e) {
                System.out.print("\nErro ao ler a entrada. Por favor, tente novamente.");
                break;
            }
        }
        scanner.close();
    }

    public static void menuPrincipal() {
        System.out.println("\nMenu Principal:");
        System.out.println("1 - Adicionar moeda");
        System.out.println("2 - Remover moeda");
        System.out.println("3 - Listar moedas");
        System.out.println("4 - Total convertido");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opcao: ");
    }

    public static void menuOpcoes() {
        System.out.println("\nMenu de opcoes:");
        System.out.println("1 - Real");
        System.out.println("2 - Dolar");
        System.out.println("3 - Euro");
        System.out.println("4 - Sair");
        System.out.print("Escolha uma opcao: ");
    }

    public static void moedaOpcoes() {
        System.out.println("1 - Dolar");
        System.out.println("2 - Euro");
        System.out.println("3 - Real");
        System.out.print("Escolha uma opcao: ");
    }
}