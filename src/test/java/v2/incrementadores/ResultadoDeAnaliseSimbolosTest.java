package v2.incrementadores;
import org.junit.jupiter.api.Test;
import v2.CalculadorDeBonus;
import v2.ContadorDeOcorrencias;
import v2.TipoEstado;

import static v2.TestadorDeSenha.testarSenha;

class ResultadoDeAnaliseSimbolosTest {

    @Test
    void deveObterValoresZeradosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var resultado = new ResultadoDeAnaliseSimbolos(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 0, 0, TipoEstado.FALHA, true);
    }

    @Test
    void deveObterValoresZeradosQuandoSenhaNaoContiverSimbolos() {
        String senha = "ASUH1jsn3";
        var resultado = new ResultadoDeAnaliseSimbolos(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 0, 0, TipoEstado.FALHA, true);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverUmSimbolo() {
        String senha = "AS@d123A456";
        var resultado = new ResultadoDeAnaliseSimbolos(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 1, 6, TipoEstado.SUFICIENTE, true);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverMaisQueUmSimbolo() {
        String senha = "Das#d123A4@!56Z";
        var resultado = new ResultadoDeAnaliseSimbolos(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 3, 18, TipoEstado.EXCEPCIONAL, true);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverApenasSimbolos() {
        String senha = "%#@@%$#$#@*()";
        var resultado = new ResultadoDeAnaliseSimbolos(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 13, 78, TipoEstado.EXCEPCIONAL, true);
    }
}