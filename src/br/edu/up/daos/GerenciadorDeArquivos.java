package br.edu.up.daos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeArquivos {

    public void salvarDados(String caminho, String dados) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho, true))) {
            writer.write(dados);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> lerDados(String caminho) {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linhas;
    }

    public void salvarCSV(String caminho, String[] dados) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho, true))) {
            writer.write(String.join(",", dados));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> lerCSV(String caminho) {
        List<String[]> linhas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linhas;
    }
}
