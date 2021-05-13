package v2.decrementadores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import v2.CalculadorDeBonus;
import v2.ContadorDeOcorrencias;
import v2.TipoEstado;
import v2.TipoOperacao;
import v2.decrementadores.ResultadoDeAnaliseNumerosSequenciais;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultadoDeAnaliseNumerosSequenciaisTest {

    @Test
    void deveObterValoresEsperadosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = new ResultadoDeAnaliseNumerosSequenciais(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        Assertions.assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        Assertions.assertEquals(TipoOperacao.DECREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaNaoContiverNumerosSequenciais() {
        String senha = "a1b2c4a6s8eE4%";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = new ResultadoDeAnaliseNumerosSequenciais(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        assertEquals(TipoOperacao.DECREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverNumerosSequenciais() {
        String senha = "45610111263123asd1789";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = new ResultadoDeAnaliseNumerosSequenciais(senha, contador, calculador);

        assertEquals(3, resultado.obterContagem());
        assertEquals(-9, resultado.obterBonus());
        assertEquals(TipoEstado.ALERTA, resultado.obterEstado());
        assertEquals(TipoOperacao.DECREMENTADOR, resultado.obterTipoOperacao());
    }

}