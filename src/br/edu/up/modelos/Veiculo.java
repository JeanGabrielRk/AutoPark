package br.edu.up.modelos;

import java.time.LocalDateTime;

public class Veiculo {

    private String tipo;
    private String placa;
    private LocalDateTime horaEntrada; 
    private LocalDateTime horaSaida;
    private int numeroVaga;

    public Veiculo(String tipo, String placa, LocalDateTime horaEntrada) {
        this.tipo = tipo;
        this.placa = placa;
        this.horaEntrada = horaEntrada;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public long getTempoPermanencia() {
        
        return java.time.Duration.between(horaEntrada, horaSaida).toHours();
    }

    public int getNumeroVaga() {
        return numeroVaga;
    }

    public void setNumeroVaga(int numeroVaga) {
        this.numeroVaga = numeroVaga;
    }
}
