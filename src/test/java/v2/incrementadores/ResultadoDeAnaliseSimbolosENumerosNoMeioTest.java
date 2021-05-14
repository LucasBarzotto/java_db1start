package v2.incrementadores;
import org.junit.jupiter.api.Test;
import v2.CalculadorDeBonus;
import v2.ContadorDeOcorrencias;
import v2.TipoEstado;

import static v2.TestadorDeSenha.testarSenha;

class ResultadoDeAnaliseSimbolosENumerosNoMeioTest {

    @Test
    void deveObterValoresZeradosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var resultado = new ResultadoDeAnaliseSimbolosENumerosNoMeio(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 0, 0, TipoEstado.FALHA, true);
    }

    @Test
    void deveObterValoresZeradosQuandoSenhaNaoContiverMid() {
        String senha = "!ASUHjsn3";
        var resultado = new ResultadoDeAnaliseSimbolosENumerosNoMeio(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 0, 0, TipoEstado.FALHA, true);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverUmMid() {
        String senha = "!Ah#naU5";
        var resultado = new ResultadoDeAnaliseSimbolosENumerosNoMeio(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 1, 2, TipoEstado.SUFICIENTE, true);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverMaisDeUmMid() {
        String senha = "!qwAh#na4Uas4d5";
        var resultado = new ResultadoDeAnaliseSimbolosENumerosNoMeio(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 3, 6, TipoEstado.EXCEPCIONAL, true);
    }
}