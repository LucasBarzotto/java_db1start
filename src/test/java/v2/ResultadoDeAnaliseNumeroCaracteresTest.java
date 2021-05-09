package v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void deveObterValoresEsperadosQuandoSenhaContiverCaracteres() {
        var resultado = new ResultadoDeAnaliseNumeroCaracteres("123456");
        assertEquals(6, resultado.obterContagem());
        assertEquals(24, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

}