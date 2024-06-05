package br.edu.up.modelos;

public class Veiculo {

    private String tipo;
    private String placa;
    private long horaEntrada; // Usando long para armazenar tempo em milissegundos
    private long horaSaida;
    private int numeroVaga;

    public Veiculo(String tipo, String placa) {
        this.tipo = tipo;
        this.placa = placa;
        this.horaEntrada = System.currentTimeMillis(); // Hora atual em milissegundos
    }

    public String getTipo() {
        return tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public long getHoraEntrada() {
        return horaEntrada;
    }

    public long getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(long horaSaida) {
        this.horaSaida = horaSaida;
    }

    public long getTempoPermanencia() {
        return horaSaida - horaEntrada;
    }

    public int getNumeroVaga() {
        return numeroVaga;
    }

    public void setNumeroVaga(int numeroVaga) {
        this.numeroVaga = numeroVaga;
    }
}
