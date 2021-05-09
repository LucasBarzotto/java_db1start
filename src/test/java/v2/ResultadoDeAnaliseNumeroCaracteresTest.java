package v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultadoDeAnaliseNumeroCaracteresTest {

    @Test
    void deveObterValoresZeradosQuandoTesteDeSenhaVazia() {
        var resultado = new ResultadoDeAnaliseNumeroCaracteres("");
        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());        
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverCaracteresAbaixoDoMinimo() {
        var resultado = new ResultadoDeAnaliseNumeroCaracteres("123456");
        assertEquals(6, resultado.obterContagem());
        assertEquals(24, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverCaracteresIgualAoMinimo() {
        var resultado = new ResultadoDeAnaliseNumeroCaracteres("abc123de");
        assertEquals(8, resultado.obterContagem());
        assertEquals(32, resultado.obterBonus());
        assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverCaracteresAcimaDoMinimo() {
        var resultado = new ResultadoDeAnaliseNumeroCaracteres("abc123de@#");
        assertEquals(10, resultado.obterContagem());
        assertEquals(40, resultado.obterBonus());
        assertEquals(TipoEstado.EXCEPCIONAL, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

}