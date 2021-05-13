package v2.decrementadores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import v2.CalculadorDeBonus;
import v2.ContadorDeOcorrencias;
import v2.TipoEstado;

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
        Assertions.assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        Assertions.assertEquals(false, resultado.retornaTrueQuandoTipoIncrementador());
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
        assertEquals(false, resultado.retornaTrueQuandoTipoIncrementador());
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
        assertEquals(false, resultado.retornaTrueQuandoTipoIncrementador());
    }

}