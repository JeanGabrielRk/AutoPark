package br.edu.up.controles;

import br.edu.up.daos.GerenciadorDeArquivos;
import br.edu.up.modelos.Estacionamento;
import br.edu.up.modelos.Mensalista;
import br.edu.up.modelos.Pagamento;
import br.edu.up.modelos.Veiculo;
import br.edu.up.telas.Totem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controlador {
    private Estacionamento estacionamento;
    private Totem totem;
    private GerenciadorDeArquivos gerenciador;
    private Scanner scanner;
    private List<Mensalista> mensalistas;

    public Controlador() {
        this.estacionamento = new Estacionamento();
        this.totem = new Totem(this);
        this.gerenciador = new GerenciadorDeArquivos();
        this.scanner = new Scanner(System.in);
        this.mensalistas = new ArrayList<>();

        // Carregar dados dos arquivos
        carregarEntradas();
        carregarMensalistas();
    }

    public void iniciarSistema() {
        totem.telaPrincipal();
    }

    public void registrarEntrada(Veiculo veiculo) {
        estacionamento.registrarEntrada(veiculo);
        // Salvar entrada em arquivo
        String dadosEntrada = veiculo.getPlaca() + "," + veiculo.getHoraEntrada().toString();
        gerenciador.salvarCSV("entradas.txt", new String[]{dadosEntrada});
    }

    public void registrarSaida(String placa, LocalDateTime horaSaida) {
        Veiculo veiculo = estacionamento.registrarSaida(placa, horaSaida);
        if (veiculo != null) {
            // Calcula o tempo de permanência em horas
            long permanencia = veiculo.getTempoPermanencia();
            // Calcula o valor total a ser pago
            float valorTotal = estacionamento.calcularPagamento(permanencia);
            // Solicita o tipo de pagamento ao usuário
            System.out.println("Selecione o tipo de pagamento:");
            System.out.println("1. Cartão");
            System.out.println("2. PIX");
            System.out.print("= ");
            int tipoPagamento = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
            if (tipoPagamento == 1 || tipoPagamento == 2) {
                // Cria o objeto de pagamento
                Pagamento pagamento = new Pagamento(tipoPagamento, valorTotal);
                // Salva o comprovante de pagamento
                salvarComprovantePagamento(veiculo, pagamento);
                // Imprime o comprovante de pagamento
                imprimirComprovantePagamento(veiculo, pagamento);
            } else {
                System.out.println("Opção de pagamento inválida!");
            }
        } else {
            System.out.println("Veículo não encontrado!");
        }
    }
    

    private void salvarComprovantePagamento(Veiculo veiculo, Pagamento pagamento) {
        String dadosComprovante = "Placa: " + veiculo.getPlaca() +
                ", Hora de Entrada: " + veiculo.getHoraEntrada() +
                ", Hora de Saída: " + veiculo.getHoraSaida() +
                ", Valor Total: " + pagamento.getVlrTotal() +
                ", Tipo de Pagamento: " + pagamento.getTipo();
        gerenciador.salvarDados("comprovantes.txt", dadosComprovante);
    }

    private void imprimirComprovantePagamento(Veiculo veiculo, Pagamento pagamento) {
        System.out.println("------ COMPROVANTE DE PAGAMENTO ------");
        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Hora de Entrada: " + veiculo.getHoraEntrada());
        System.out.println("Hora de Saída: " + veiculo.getHoraSaida());
        System.out.println("Valor Total: " + pagamento.getVlrTotal());
        System.out.println("Tipo de Pagamento: " + pagamento.getTipo());
        System.out.println("---------------------------------------");
    }

    private void carregarEntradas() {
        try {
            List<String> linhas = Files.readAllLines(Paths.get("entradas.txt"));
            for (String linha : linhas) {
                String[] dados = linha.split(",");
                if (dados.length >= 2) {
                    String placa = dados[0];
                    LocalDateTime horaEntrada = LocalDateTime.parse(dados[1]);
                    Veiculo veiculo = new Veiculo("", placa, horaEntrada);
                    estacionamento.registrarEntrada(veiculo);
                } else {
                    System.out.println("Formato inválido de dados de entrada: " + linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    private void carregarMensalistas() {
    List<String[]> linhas = gerenciador.lerCSV("mensalistas.csv");
    for (String[] dados : linhas) {
        if (dados.length >= 6) { // Verificar se há pelo menos 6 elementos no array de dados
            String nome = dados[0];
            String placa = dados[1];
            int id = Integer.parseInt(dados[2]);
            String modelo = dados[3];
            String cpf = dados[4];
            String telefone = dados[5];
            Mensalista mensalista = new Mensalista(nome, placa, id, modelo, cpf, telefone);
            mensalistas.add(mensalista);
        } else {
            System.out.println("Formato inválido de dados de mensalista: " + Arrays.toString(dados));
        }
    }
}


    public void adicionarMensalista(String nome, String placa, int id, String modelo, String cpf, String telefone) {
        Mensalista mensalista = new Mensalista(nome, placa, id, modelo, cpf, telefone);
        mensalistas.add(mensalista);
        // Salvar mensalista em arquivo
        String[] dadosMensalista = {nome, placa, String.valueOf(id), modelo, cpf, telefone};
        gerenciador.salvarCSV("mensalistas.csv", dadosMensalista);
    }

    public void listarMensalistas() {
        for (Mensalista mensalista : mensalistas) {
            System.out.println("Nome: " + mensalista.getNome() + ", Placa: " + mensalista.getPlaca() + ", ID: " + mensalista.getId() + ", Modelo: " + mensalista.getModeloVeiculo() + ", CPF: " + mensalista.getCpf() + ", Telefone: " + mensalista.getTelefone());
        }
    }
}
