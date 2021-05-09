package v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultadoDeAnaliseRequerimentosTest {

    @Test
    void deveObterValoresZeradosQuandoTesteDeSenhaVazia() {
        var resultado = new ResultadoDeAnaliseRequerimentos("");
        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaMenorQueTamanhoMinimo() {
        var resultado = new ResultadoDeAnaliseRequerimentos(("A3#gacA"));
        assertEquals(4, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaNaoContiverRequerimentosSuficientes() {
        var resultado = new ResultadoDeAnaliseRequerimentos(("AbcdeOUHShaso"));
        assertEquals(3, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverRequerimentosSuficientes() {
        var resultado = new ResultadoDeAnaliseRequerimentos(("AbcdeOUHShaso1"));
        assertEquals(4, resultado.obterContagem());
        assertEquals(8, resultado.obterBonus());
        assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverRequerimentosExcepcionais() {
        var resultado = new ResultadoDeAnaliseRequerimentos(("Abcde#OUHShaso1"));
        assertEquals(5, resultado.obterContagem());
        assertEquals(10, resultado.obterBonus());
        assertEquals(TipoEstado.EXCEPCIONAL, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }
}