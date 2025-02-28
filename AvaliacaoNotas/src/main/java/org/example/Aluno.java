package org.example;

public class Aluno {
    private String nome;  // Armazena o nome do aluno
    private double nota;  // Armazena a nota do aluno

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    // Método que retorna o nome do aluno
    public String getNome() {
        return nome;
    }

    // Método que retorna a nota do aluno
    public double getNota() {
        return nota;
    }

    // Método que altera a nota do aluno
    public void setNota(double nota) {
        this.nota = nota;
    }
}
