package v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultadoDeAnaliseNumerosConsecutivosTest {

    @Test
    void deveObterValoresEsperadosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = new ResultadoDeAnaliseNumerosConsecutivos(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        assertEquals(TipoOperacao.DECREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaNaoContiverNumerosConsecutivos() {
        String senha = "a1b2c4a6s8eE4%";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = new ResultadoDeAnaliseNumerosConsecutivos(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        assertEquals(TipoOperacao.DECREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverNumerosConsecutivos() {
        String senha = "321a4s5s4a8s4e5a322s4s4s888";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = new ResultadoDeAnaliseNumerosConsecutivos(senha, contador, calculador);

        assertEquals(6, resultado.obterContagem());
        assertEquals(-12, resultado.obterBonus());
        assertEquals(TipoEstado.ALERTA, resultado.obterEstado());
        assertEquals(TipoOperacao.DECREMENTADOR, resultado.obterTipoOperacao());
    }

}