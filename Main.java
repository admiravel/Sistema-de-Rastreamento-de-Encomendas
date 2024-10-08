import entidade.Cliente;
import entidade.Encomenda;
import entidade.EncomendaInternacional;
import entidade.EncomendaNacional;
import entidade.Transportadora;
import repositorio.Encomendas;
import repositorio.EncomendasImpl;
import repositorio.iEncomendas;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static iEncomendas repositorio = new EncomendasImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int usuarioTipo = 0;

        try {
            // Solicitar tipo de usuário
            System.out.println("Escolha o tipo de usuário:");
            System.out.println("1. Administrador");
            System.out.println("2. Cliente");
            System.out.print("Digite o número correspondente: ");
            usuarioTipo = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (usuarioTipo) {
                case 1:
                    menuAdministrador();
                    break;
                case 2:
                    menuCliente();
                    break;
                default:
                    System.out.println("Tipo de usuário inválido.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.nextLine(); // Limpa o buffer do scanner
        } finally {
            scanner.close();
        }
    }

    // Menu para administrador com as funcionalidades principais
    private static void menuAdministrador() {
        int opcao = 0;

        do {
            try {
                // Exibir menu de administrador
                System.out.println("Menu Administrador");
                System.out.println("1. Adicionar Encomenda Nacional");
                System.out.println("2. Adicionar Encomenda Internacional");
                System.out.println("3. Listar Encomendas");
                System.out.println("4. Rastrear Encomenda");
                System.out.println("5. Deletar Encomenda");
                System.out.println("6. Sair");
                System.out.print("Escolha uma opção: ");
                
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a nova linha

                switch (opcao) {
                    case 1:
                        adicionarEncomendaNacional();
                        break;

                    case 2:
                        adicionarEncomendaInternacional();
                        break;

                    case 3:
                        listarEncomendas();
                        break;

                    case 4:
                        rastrearEncomenda();
                        break;

                    case 5:
                        deletarEncomenda();
                        break;

                    case 6:
                        System.out.println("Saindo do sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
            System.out.println(); // Linha em branco para separar as opções

        } while (opcao != 6);
    }

    // Menu para cliente com opções limitadas
    private static void menuCliente() {
        int opcao = 0;

        do {
            try {
                // Exibir menu de cliente
                System.out.println("Menu Cliente");
                System.out.println("1. Adicionar Encomenda Nacional");
                System.out.println("2. Adicionar Encomenda Internacional");
                System.out.println("3. Sair");
                System.out.print("Escolha uma opção: ");
                
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a nova linha

                switch (opcao) {
                    case 1:
                        adicionarEncomendaNacional();
                        break;

                    case 2:
                        adicionarEncomendaInternacional();
                        break;

                    case 3:
                        System.out.println("Saindo do sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
            System.out.println(); // Linha em branco para separar as opções

        } while (opcao != 3);
    }

    // Adicionar uma encomenda nacional
    private static void adicionarEncomendaNacional() {
        try {
            System.out.print("Digite o código da encomenda: ");
            String codigo = scanner.nextLine();
            System.out.print("Digite o peso da encomenda: ");
            double peso = scanner.nextDouble();
            scanner.nextLine(); // Consome a nova linha
            Encomenda encomenda = new EncomendaNacional(codigo, new Cliente("João Silva", "Rua A, 123"), new Cliente("Maria Souza", "Rua B, 456"), new Transportadora("Transportadora XYZ", "TX123"), peso);
            repositorio.adicionarEncomenda(encomenda);
            System.out.println("Encomenda Nacional adicionada com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um número válido para o peso.");
            scanner.nextLine(); // Limpa o buffer do scanner
        }
    }

    // Adicionar uma encomenda internacional
    private static void adicionarEncomendaInternacional() {
        try {
            System.out.print("Digite o código da encomenda: ");
            String codigo = scanner.nextLine();
            System.out.print("Digite o peso da encomenda: ");
            double peso = scanner.nextDouble();
            scanner.nextLine(); // Consome a nova linha
            System.out.print("Digite o país de destino: ");
            String paisDestino = scanner.nextLine();
            Encomenda encomenda = new EncomendaInternacional(codigo, new Cliente("João Silva", "Rua A, 123"), new Cliente("Maria Souza", "Rua B, 456"), new Transportadora("Transportadora XYZ", "TX123"), peso, paisDestino);
            repositorio.adicionarEncomenda(encomenda);
            System.out.println("Encomenda Internacional adicionada com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um número válido para o peso.");
            scanner.nextLine(); // Limpa o buffer do scanner
        }
    }

    // Listar todas as encomendas
    private static void listarEncomendas() {
        List<Encomenda> encomendas = repositorio.listarEncomendas();
        if (encomendas.isEmpty()) {
            System.out.println("Nenhuma encomenda cadastrada.");
        } else {
            System.out.println("Encomendas cadastradas:");
            for (Encomenda e : encomendas) {
                System.out.println("Código: " + e.getCodigo() + ", Tipo: " + e.getTipo() + ", Peso: " + e.getPeso() + "kg");
            }
        }
    }

    // Rastrear uma encomenda pelo código
    private static void rastrearEncomenda() {
        System.out.print("Digite o código da encomenda para rastrear: ");
        String codigo = scanner.nextLine();
        Encomenda encomenda = repositorio.buscarEncomenda(codigo);
        if (encomenda != null) {
            System.out.println("Encomenda encontrada: Código: " + encomenda.getCodigo() + ", Tipo: " + encomenda.getTipo() + ", Peso: " + encomenda.getPeso() + "kg");
        } else {
            System.out.println("Encomenda não encontrada.");
        }
    }

    // Deletar uma encomenda
    private static void deletarEncomenda() {
        System.out.print("Digite o código da encomenda para deletar: ");
        String codigo = scanner.nextLine();
        repositorio.removerEncomenda(codigo);
        System.out.println("Encomenda deletada com sucesso!");
    }
}
