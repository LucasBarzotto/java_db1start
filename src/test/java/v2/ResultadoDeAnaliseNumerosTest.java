package v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultadoDeAnaliseNumerosTest {

    @Test
    void deveObterValoresZeradosQuandoTesteDeSenhaVazia() {
        var resultado = new ResultadoDeAnaliseNumeros("");
        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresZeradosQuandoSenhaNaoContiverNumeros() {
        var resultado = new ResultadoDeAnaliseNumeros(("ASUH#jsasn$"));
        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverUmNumero() {
        var resultado = new ResultadoDeAnaliseNumeros(("ASDIj2as(#"));
        assertEquals(1, resultado.obterContagem());
        assertEquals(4, resultado.obterBonus());
        assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverMaisQueUmNumero() {
        var resultado = new ResultadoDeAnaliseNumeros(("A2SD3Ij2as(#"));
        assertEquals(3, resultado.obterContagem());
        assertEquals(12, resultado.obterBonus());
        assertEquals(TipoEstado.EXCEPCIONAL, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }
}