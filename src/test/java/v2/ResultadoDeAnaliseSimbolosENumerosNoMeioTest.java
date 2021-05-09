package v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultadoDeAnaliseSimbolosENumerosNoMeioTest {

    @Test
    void deveObterValoresZeradosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);
        var resultado = new ResultadoDeAnaliseSimbolosENumerosNoMeio(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresZeradosQuandoSenhaNaoContiverMid() {
        String senha = "!ASUHjsn3";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);
        var resultado = new ResultadoDeAnaliseSimbolosENumerosNoMeio(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverUmMid() {
        String senha = "!Ah#naU5";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);
        var resultado = new ResultadoDeAnaliseSimbolosENumerosNoMeio(senha, contador, calculador);

        assertEquals(1, resultado.obterContagem());
        assertEquals(2, resultado.obterBonus());
        assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverMaisDeUmMid() {
        String senha = "!qwAh#na4Uas4d5";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);
        var resultado = new ResultadoDeAnaliseSimbolosENumerosNoMeio(senha, contador, calculador);

        assertEquals(3, resultado.obterContagem());
        assertEquals(6, resultado.obterBonus());
        assertEquals(TipoEstado.EXCEPCIONAL, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }
}