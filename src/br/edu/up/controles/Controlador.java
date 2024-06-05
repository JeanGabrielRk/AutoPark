package br.edu.up.controles;

import br.edu.up.daos.GerenciadorDeArquivos;
import br.edu.up.modelos.Estacionamento;
import br.edu.up.modelos.Mensalista;
import br.edu.up.modelos.Veiculo;
import br.edu.up.telas.Totem;

import java.util.Scanner;

public class Controlador {
    private Estacionamento estacionamento;
    private Totem totem;
    private GerenciadorDeArquivos gerenciador;
    private Scanner scanner;

    public Controlador() {
        this.estacionamento = new Estacionamento();
        this.totem = new Totem(this);
        this.gerenciador = new GerenciadorDeArquivos();
        this.scanner = new Scanner(System.in);
    }

    public void iniciarSistema() {
        totem.telaPrincipal();
    }

    public void registrarEntrada(Veiculo veiculo) {
        estacionamento.registrarEntrada(veiculo);
    }

    public void registrarSaida(String placa, long horaSaida) {
        estacionamento.registrarSaida(placa, horaSaida);
    }

    public float calcularPagamento(long permanencia) {
        return estacionamento.calcularPagamento(permanencia);
    }

    public void salvarDados(String caminho, String dados) {
        gerenciador.salvarDados(caminho, dados);
    }

    public void salvarCSV(String caminho, String[] dados) {
        gerenciador.salvarCSV(caminho, dados);
    }

    // Método para registrar entrada usando dados fornecidos pelo usuário
    public void registrarEntrada() {
        System.out.print("Digite o tipo do veículo: ");
        String tipo = scanner.nextLine();
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
    
        // Criar um objeto Veiculo com as informações fornecidas
        Veiculo veiculo = new Veiculo(tipo, placa);
    
        // Registrar entrada usando o controlador
        registrarEntrada(veiculo);
    }

    // Método para registrar saída usando dados fornecidos pelo usuário
    public void registrarSaida() {
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        System.out.print("Digite a hora de saída (em milissegundos desde a época Unix): ");
        long horaSaida = scanner.nextLong();
        scanner.nextLine(); // Consumir nova linha
    
        // Registrar saída usando o controlador
        registrarSaida(placa, horaSaida);
    }

    public void adicionarMensalista(String nome, String placa, int id, String modelo, String cpf, String telefone) {
        Mensalista mensalista = new Mensalista(nome, placa, id, modelo, cpf, telefone);
        mensalistas.add(mensalista);
    }

    public void listarMensalistas() {
        for (Mensalista mensalista : mensalistas) {
            System.out.println("Nome: " + mensalista.getNome() + ", Placa: " + mensalista.getPlaca() + ", ID: " + mensalista.getId() + ", Modelo: " + mensalista.getModeloVeiculo() + ", CPF: " + mensalista.getCpf() + ", Telefone: " + mensalista.getTelefone());
        }
    }
}
