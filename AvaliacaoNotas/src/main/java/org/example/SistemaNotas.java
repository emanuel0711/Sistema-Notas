package org.example;// Importação das bibliotecas necessárias para criar a interface gráfica
import org.example.Aluno;
import org.example.RelacaoNota;

import javax.swing.*; // Para componentes gráficos como janelas, botões e campos de texto
import java.awt.*; // Para layout e organização dos componentes
import java.awt.event.ActionEvent; // Para lidar com eventos, como o clique de um botão
import java.awt.event.ActionListener; // Para ouvir o clique de um botão e reagir a isso

public class SistemaNotas extends JFrame { // Classe principal, que herda funcionalidades de JFrame (uma janela)

    // Declaração das variáveis de componentes gráficos
    private JTextField nomeTextField; // Campo de texto onde o usuário vai digitar o nome do aluno
    private JTextField notaTextField; // Campo de texto onde o usuário vai digitar a nota do aluno
    private JTextArea resultadoTextArea; // Área de texto onde será mostrado o resultado do cálculo

    // Construtor da classe SistemaNotas, que configura e inicializa a janela
    public SistemaNotas() {
        // Configurações da janela principal
        setTitle("Sistema de Avaliação de Notas"); // Define o título da janela
        setSize(400, 300); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao fechar a janela
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Layout da janela
        setLayout(new BorderLayout());

        // Painel para inserir dados do usuário
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new GridLayout(3, 2));

        // Adicionando um label (etiqueta) e um campo de texto para o nome do aluno
        painelEntrada.add(new JLabel("Nome do Aluno:"));
        nomeTextField = new JTextField();
        painelEntrada.add(nomeTextField);

        // Adicionando um label e um campo de texto para a nota do aluno
        painelEntrada.add(new JLabel("Nota do Aluno:"));
        notaTextField = new JTextField();
        painelEntrada.add(notaTextField);

        // Botão para calcular a nota
        JButton calcularButton = new JButton("Calcular Desempenho");
        painelEntrada.add(calcularButton);

        // Área de texto onde o resultado será mostrado
        resultadoTextArea = new JTextArea(5, 30);
        resultadoTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoTextArea); // Barra de rolagem caso o texto seja longo

        // Adicionando os componentes à janela
        add(painelEntrada, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Ação do botão de calcular
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularDesempenho();
            }
        });
    }

    // Método que calcula o desempenho baseado na nota
    private void calcularDesempenho() {
        String nome = nomeTextField.getText();
        String notaTexto = notaTextField.getText();

        try {
            double nota = Double.parseDouble(notaTexto);

            // Criação do objeto 'Aluno' com os dados fornecidos
            Aluno aluno = new Aluno(nome, nota);

            // Chama o método para calcular o desempenho
            String resultado = RelacaoNota.calcularDesempenho(aluno);

            // Exibe o resultado
            resultadoTextArea.setText("Resultado para " + nome + ":\n" + resultado);

        } catch (NumberFormatException ex) { // Caso o usuário insira um valor inválido
            resultadoTextArea.setText("Erro: A nota deve ser um número válido.");
        }
    }

    // Método principal que inicializa a interface gráfica
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SistemaNotas sistema = new SistemaNotas();
                sistema.setVisible(true);
            }
        });
    }
}
