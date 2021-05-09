package v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultadoDeAnaliseLetrasMaiusculasTest {

    @Test
    void deveObterValoresZeradosQuandoTesteDeSenhaVazia() {
        var resultado = new ResultadoDeAnaliseLetrasMaiusculas("");
        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresZeradosQuandoSenhaNaoContiverCaracteresMaiusculos() {
        var resultado = new ResultadoDeAnaliseLetrasMaiusculas(("1abc#23456"));
        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverUmCaractereMaiusculo() {
        var resultado = new ResultadoDeAnaliseLetrasMaiusculas(("asd123A456"));
        assertEquals(1, resultado.obterContagem());
        assertEquals(18, resultado.obterBonus());
        assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverMaisQueUmCaractereMaiusculo() {
        var resultado = new ResultadoDeAnaliseLetrasMaiusculas(("Dasd123A456Z"));
        assertEquals(3, resultado.obterContagem());
        assertEquals(18, resultado.obterBonus());
        assertEquals(TipoEstado.EXCEPCIONAL, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }
}