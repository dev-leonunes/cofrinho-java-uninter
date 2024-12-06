import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Cofrinho cofrinho = new Cofrinho();
        Scanner scanner = new Scanner(System.in);
        int opcaoTarefa = 0;

        try {
            while (opcaoTarefa != 5) {
                menuPrincipal();
                opcaoTarefa = scanner.nextInt();

                switch (opcaoTarefa) {
                    case 1:
                        scanner.nextLine();
                        System.out.println("Selecione o tipo de moeda:");
                        moedaOpcoes();
                        int tipoMoeda = scanner.nextInt();

                        System.out.println("Digite o valor:");
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
                        System.out.println();
                        System.out.println("Moeda adicionada");
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("Selecione o tipo de moeda:");
                        moedaOpcoes();
                        int tipoMoedaRemover = scanner.nextInt();

                        System.out.println("Qual o valor da moeda que deseja remover?");
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
                                System.out.println("Opcao invalida");
                                break;
                        }

                        for (Moeda m : cofrinho.getListaMoedas()) {
                            if (m.getValor() == moedaRemover.valor) {
                                cofrinho.remover(m);
                                break;
                            }
                        }

                        if (moedaRemover != null) {
                            System.out.println();
                            System.out.println("Moeda removida");
                            System.out.println();
                        } else {
                            System.out.println();
                            System.out.println("Moeda nao encontrada");
                            System.out.println();
                        }
                        continue;
                    case 3:
                        System.out.println();
                        System.out.println("--------------------");
                        System.out.println("Moedas no cofrinho:");
                        cofrinho.listar();
                        System.out.println("--------------------");
                        System.out.println();
                        break;
                    case 4:
                        System.out.println();
                        System.out.println("--------------------");
                        cofrinho.totalConvertido();
                        System.out.println("--------------------");
                        System.out.println();
                        break;
                    case 5:
                        System.out.println();
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println();
                        System.out.println("Opcao invalida");
                        System.out.println();
                        break;
                }
            }
        } catch (Exception e) {
            if (e instanceof java.util.InputMismatchException) {
                System.out.println("Erro: Digite um valor valido");
            }
        }
        scanner.close();
    }

    public static void menuPrincipal() {
        System.out.println("Menu Principal:");
        System.out.println("1 - Adicionar moeda");
        System.out.println("2 - Remover moeda");
        System.out.println("3 - Listar moedas");
        System.out.println("4 - Total convertido");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opcao: ");
    }

    public static void menuOpcoes() {
        System.out.println("Menu de opcoes:");
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
    }
}