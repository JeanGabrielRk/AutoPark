package br.edu.up.modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private int[] vagasDisp = new int[50];
    private List<Veiculo> veiculosEstacionados = new ArrayList<>();
    private float vlrHora = 10;

    public Estacionamento() {
        for (int i = 0; i < 50; i++) {
            vagasDisp[i] = 1;
        }
    }

    public void registrarEntrada(Veiculo veiculo) {
        for (int i = 0; i < vagasDisp.length; i++) {
            if (vagasDisp[i] == 1) {
                veiculo.setNumeroVaga(i);
                veiculosEstacionados.add(veiculo);
                vagasDisp[i] = 0;
                System.out.println("Veículo registrado na vaga: " + i);
                return;
            }
        }
        System.out.println("Não há vagas disponíveis.");
    }

    public Veiculo registrarSaida(String placa, LocalDateTime horaSaida) {
        for (Veiculo veiculo : veiculosEstacionados) {
            if (veiculo.getPlaca().equals(placa)) {
                veiculo.setHoraSaida(horaSaida);
                vagasDisp[veiculo.getNumeroVaga()] = 1; // Libera a vaga
                veiculosEstacionados.remove(veiculo);
                System.out.println("Veículo removido da vaga: " + veiculo.getNumeroVaga());
                return veiculo;
            }
        }
        return null; // Veículo não encontrado
    }

    public float calcularPagamento(long permanencia) {
        // Calcula o valor total com base no tempo de permanência em horas
        float valorAPagar = (float) permanencia * vlrHora;
        return valorAPagar;
    }
}
