package v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultadoDeAnaliseLetrasMinusculasTest {

    @Test
    void deveObterValoresZeradosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);
        var resultado = new ResultadoDeAnaliseLetrasMinusculas(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresZeradosQuandoSenhaNaoContiverCaracteresMinusculos() {
        String senha = "1ABC#23456";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);
        var resultado = new ResultadoDeAnaliseLetrasMinusculas(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverUmCaractereMinusculo() {
        String senha = "AS@d123A456";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);
        var resultado = new ResultadoDeAnaliseLetrasMinusculas(senha, contador, calculador);

        assertEquals(1, resultado.obterContagem());
        assertEquals(20, resultado.obterBonus());
        assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverMaisQueUmCaractereMinusculo() {
        String senha = "Das#d123A456Z";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);
        var resultado = new ResultadoDeAnaliseLetrasMinusculas(senha, contador, calculador);

        assertEquals(3, resultado.obterContagem());
        assertEquals(20, resultado.obterBonus());
        assertEquals(TipoEstado.EXCEPCIONAL, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }
}