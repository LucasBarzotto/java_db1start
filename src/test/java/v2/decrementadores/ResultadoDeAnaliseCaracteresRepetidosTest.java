package v2.decrementadores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import v2.CalculadorDeBonus;
import v2.ContadorDeOcorrencias;
import v2.TipoEstado;
import v2.TipoOperacao;
import v2.decrementadores.ResultadoDeAnaliseCaracteresRepetidos;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultadoDeAnaliseCaracteresRepetidosTest {

    @Test
    void deveObterValoresEsperadosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = new ResultadoDeAnaliseCaracteresRepetidos(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        Assertions.assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        Assertions.assertEquals(TipoOperacao.DECREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaNaoContiverCaracteresRepetidos() {
        String senha = "abcdefg123456!@#$";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = new ResultadoDeAnaliseCaracteresRepetidos(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        assertEquals(TipoOperacao.DECREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverCaracteresRepetidos() {
        String senha = "aaabbb12UHAS12BA555";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = new ResultadoDeAnaliseCaracteresRepetidos(senha, contador, calculador);

        assertEquals(15, resultado.obterContagem());
        assertEquals(-10, resultado.obterBonus());
        assertEquals(TipoEstado.ALERTA, resultado.obterEstado());
        assertEquals(TipoOperacao.DECREMENTADOR, resultado.obterTipoOperacao());
    }

}