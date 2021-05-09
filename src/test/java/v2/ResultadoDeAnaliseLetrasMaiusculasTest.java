package v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultadoDeAnaliseLetrasMaiusculasTest {

    @Test
    void deveObterValoresZeradosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);
        var resultado = new ResultadoDeAnaliseLetrasMaiusculas(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresZeradosQuandoSenhaNaoContiverCaracteresMaiusculos() {
        String senha = "1abc#23456";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);
        var resultado = new ResultadoDeAnaliseLetrasMaiusculas(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverUmCaractereMaiusculo() {
        String senha = "asd123A456";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);
        var resultado = new ResultadoDeAnaliseLetrasMaiusculas(senha, contador, calculador);

        assertEquals(1, resultado.obterContagem());
        assertEquals(18, resultado.obterBonus());
        assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverMaisQueUmCaractereMaiusculo() {
        String senha = "Dasd123A456Z";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);
        var resultado = new ResultadoDeAnaliseLetrasMaiusculas(senha, contador, calculador);

        assertEquals(3, resultado.obterContagem());
        assertEquals(18, resultado.obterBonus());
        assertEquals(TipoEstado.EXCEPCIONAL, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }
}