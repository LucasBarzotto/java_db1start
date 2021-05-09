package v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultadoDeAnaliseSimbolosENumerosNoMeioTest {

    @Test
    void deveObterValoresZeradosQuandoTesteDeSenhaVazia() {
        var resultado = new ResultadoDeAnaliseSimbolosENumerosNoMeio("");
        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresZeradosQuandoSenhaNaoContiverMid() {
        var resultado = new ResultadoDeAnaliseSimbolosENumerosNoMeio(("!ASUHjsn3"));
        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverUmMid() {
        var resultado = new ResultadoDeAnaliseSimbolosENumerosNoMeio(("!Ah#naU5"));
        assertEquals(1, resultado.obterContagem());
        assertEquals(2, resultado.obterBonus());
        assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverMaisDeUmMid() {
        var resultado = new ResultadoDeAnaliseSimbolosENumerosNoMeio(("!qwAh#na4Uas4d5"));
        assertEquals(3, resultado.obterContagem());
        assertEquals(6, resultado.obterBonus());
        assertEquals(TipoEstado.EXCEPCIONAL, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }
}