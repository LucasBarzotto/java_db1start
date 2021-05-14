package v2.incrementadores;
import org.junit.jupiter.api.Test;
import v2.CalculadorDeBonus;
import v2.ContadorDeOcorrencias;
import v2.TipoEstado;

import static v2.TestadorDeSenha.testarSenha;

class ResultadoDeAnaliseLetrasMinusculasTest {

    @Test
    void deveObterValoresZeradosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var resultado = new ResultadoDeAnaliseLetrasMinusculas(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 0, 0, TipoEstado.FALHA, true);
    }

    @Test
    void deveObterValoresZeradosQuandoSenhaNaoContiverCaracteresMinusculos() {
        String senha = "1ABC#23456";
        var resultado = new ResultadoDeAnaliseLetrasMinusculas(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 0, 0, TipoEstado.FALHA, true);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverUmCaractereMinusculo() {
        String senha = "AS@d123A456";
        var resultado = new ResultadoDeAnaliseLetrasMinusculas(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 1, 20, TipoEstado.SUFICIENTE, true);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverMaisQueUmCaractereMinusculo() {
        String senha = "Das#d123A456Z";
        var resultado = new ResultadoDeAnaliseLetrasMinusculas(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 3, 20, TipoEstado.EXCEPCIONAL, true);
    }
}