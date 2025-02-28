package org.example;

public class RelacaoNota {
    // Método que calcula o desempenho do aluno com base na nota
    public static String calcularDesempenho(Aluno aluno) {
        double nota = aluno.getNota();

        // Verifica se a nota é inválida
        if (nota < 0 || nota > 100) {
            return "Esse número nem existe! Por favor, insira uma nota válida.";
        }

        // Classificação do desempenho do aluno
        if (nota <= 20.0) {
            return "Reprovado. Você foi reprovado! Busque apoio e estude mais para a próxima.";
        } else if (nota <= 45.0) {
            return "Desempenho insuficiente. Você não passou, precisa melhorar. Não desista!";
        } else if (nota <= 85.0) {
            return "Bom desempenho! Continue estudando e não desista.";
        } else if (nota <= 95.0) {
            return "Excelente desempenho! Parabéns!";
        } else {
            return "Nota perfeita! Você foi incrível! 🎉";
        }
    }
}
