package br.edu.up.telas;

import java.util.Scanner;
import br.edu.up.controles.Controlador;
import br.edu.up.modelos.Veiculo;


public class Totem {
    private Controlador controlador;
    private Scanner scanner;

    public Totem(Controlador controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    public void telaPrincipal() {
        while (true) {
            System.out.println("------ AUTO PARK ------");
            System.out.println("1. Entrar");
            System.out.println("2. Sair");
            System.out.println("3. Mensalista");
            System.out.println("4. Encerrar");
            System.out.print("= ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (escolha) {
                case 1:
                    registrarEntrada();
                    break;
                case 2:
                    registrarSaida();
                    break;
                case 3:
                    gerenciarMensalista();
                    break;
                case 4:
                    System.out.println("Encerrando o sistema...");
                    return; // Encerra o método e, consequentemente, o sistema
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private void registrarEntrada() {
        System.out.print("Digite o tipo do veículo: ");
        String tipo = scanner.nextLine();
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();

        // Registrar entrada usando o controlador
        controlador.registrarEntrada(new Veiculo(tipo, placa));
    }

    private void registrarSaida() {
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();

        // Registrar saída usando o controlador
        controlador.registrarSaida(placa, System.currentTimeMillis());
    }

    private void gerenciarMensalista() {
        System.out.println("1. Adicionar Mensalista");
        System.out.println("2. Ver Mensalistas");
        System.out.print("= ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        switch (escolha) {
            case 1:
                adicionarMensalista();
                break;
            case 2:
                listarMensalistas();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private void adicionarMensalista() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        System.out.print("Modelo do Veículo: ");
        String modelo = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        // Adicionar mensalista usando o controlador
        controlador.adicionarMensalista(nome, placa, id, modelo, cpf, telefone);
    }

    private void listarMensalistas() {
        // Listar mensalistas usando o controlador
        controlador.listarMensalistas();
    }
}
