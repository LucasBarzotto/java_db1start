package v2.incrementadores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import v2.CalculadorDeBonus;
import v2.ContadorDeOcorrencias;
import v2.TipoEstado;

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
        Assertions.assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        Assertions.assertEquals(true, resultado.retornaTrueQuandoTipoIncrementador());
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
        assertEquals(true, resultado.retornaTrueQuandoTipoIncrementador());
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
        assertEquals(true, resultado.retornaTrueQuandoTipoIncrementador());
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
        assertEquals(true, resultado.retornaTrueQuandoTipoIncrementador());
    }
}