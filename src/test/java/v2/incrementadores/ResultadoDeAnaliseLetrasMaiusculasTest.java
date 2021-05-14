package v2.incrementadores;
import org.junit.jupiter.api.Test;
import v2.*;
import static v2.TestadorDeSenha.testarSenha;

class ResultadoDeAnaliseLetrasMaiusculasTest {

    @Test
    void deveObterValoresZeradosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var resultado = new ResultadoDeAnaliseLetrasMaiusculas(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 0, 0, TipoEstado.FALHA, true);
    }

    @Test
    void deveObterValoresZeradosQuandoSenhaNaoContiverCaracteresMaiusculos() {
        String senha = "1abc#23456";
        var resultado = new ResultadoDeAnaliseLetrasMaiusculas(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 0, 0, TipoEstado.FALHA, true);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverUmCaractereMaiusculo() {
        String senha = "asd123A456";
        var resultado = new ResultadoDeAnaliseLetrasMaiusculas(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 1, 18, TipoEstado.SUFICIENTE, true);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverMaisQueUmCaractereMaiusculo() {
        String senha = "Dasd123A456Z";
        var resultado = new ResultadoDeAnaliseLetrasMaiusculas(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 3, 18, TipoEstado.EXCEPCIONAL, true);
    }

}