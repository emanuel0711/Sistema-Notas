import org.example.Aluno;
import org.example.RelacaoNota;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RelacaoNotaTest {
    private Aluno aluno1, aluno2, aluno3, aluno4;

    @BeforeEach
    public void setup() {
        System.out.println("Criando novos alunos :) ...");
        aluno1 = new Aluno("JovemNey", 80.0);
        aluno2 = new Aluno("Arthur", 10.0);
        aluno3 = new Aluno("Ariel", 40.0);
        aluno4 = new Aluno("Mariana", 90.0);
    }

    @Test
    public void testNotaBoa() {
        System.out.println("Testando aluno com nota boa...");
        String resultado = RelacaoNota.calcularDesempenho(aluno1);
        assertEquals("Bom desempenho! Continue estudando e não desista.", resultado,
                "Bom desempenho! Continue estudando e não desista.");
    }

    @Test
    public void testNotaRuim() {
        System.out.println("Testando aluno com nota ruim...");
        String resultado = RelacaoNota.calcularDesempenho(aluno2);
        assertEquals("Reprovado. Você foi reprovado! Busque apoio e estude mais para a próxima.", resultado,
                "Reprovado. Você foi reprovado! Busque apoio e estude mais para a próxima.");
    }

    @Test
    public void testNotaMediana() {
        System.out.println("Testando aluno com nota mediana...");
        String resultado = RelacaoNota.calcularDesempenho(aluno3);
        assertEquals("Desempenho insuficiente. Você não passou, precisa melhorar. Não desista!", resultado,
                "Desempenho insuficiente. Você não passou, precisa melhorar. Não desista!");
    }

    @Test
    public void testNotaExcelente() {
        System.out.println("Testando aluno com nota excelente...");
        String resultado = RelacaoNota.calcularDesempenho(aluno4);
        assertEquals("Excelente desempenho! Parabéns!", resultado,
                "Excelente desempenho! Parabéns!");
    }
}
