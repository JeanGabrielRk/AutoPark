// Controlador.java
package br.edu.up.controles;

import br.edu.up.daos.GerenciadorDeArquivos;
import br.edu.up.modelos.Estacionamento;
import br.edu.up.modelos.Mensalista;
import br.edu.up.modelos.Veiculo;
import br.edu.up.telas.Totem;

import java.util.ArrayList;
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
