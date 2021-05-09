package v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultadoDeAnaliseLetrasMaiusculasConsecutivasTest {

    @Test
    void deveObterValoresEsperadosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = new ResultadoDeAnaliseLetrasMaiusculasConsecutivas(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        assertEquals(TipoOperacao.DECREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaNaoContiverLetrasMaiusculasConsecutivas() {
        String senha = "AbCdEfG1234A5B6!@#$";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = new ResultadoDeAnaliseLetrasMaiusculasConsecutivas(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        assertEquals(TipoOperacao.DECREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverLetrasMaiusculasConsecutivas() {
        String senha = "AaAAaBB121354CCC%@EE";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = new ResultadoDeAnaliseLetrasMaiusculasConsecutivas(senha, contador, calculador);

        assertEquals(5, resultado.obterContagem());
        assertEquals(-10, resultado.obterBonus());
        assertEquals(TipoEstado.ALERTA, resultado.obterEstado());
        assertEquals(TipoOperacao.DECREMENTADOR, resultado.obterTipoOperacao());
    }

}