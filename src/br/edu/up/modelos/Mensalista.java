package br.edu.up.modelos;

public class Mensalista {

    private String nome;
    private String placa;
    private int id;
    private String modeloVeiculo;
    private String cpf;
    private String telefone;
    private float vlrMensal = 275;

    public Mensalista(String nome, String placa, int id, String modeloVeiculo, String cpf, String telefone) {
        this.nome = nome;
        this.placa = placa;
        this.id = id;
        this.modeloVeiculo = modeloVeiculo;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public float getVlrMensal() {
        return vlrMensal;
    }

    public void setVlrMensal(float vlrMensal) {
        this.vlrMensal = vlrMensal;
    }

    
}
