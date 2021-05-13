package v2.incrementadores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import v2.CalculadorDeBonus;
import v2.ContadorDeOcorrencias;
import v2.TipoEstado;
import v2.TipoOperacao;
import v2.incrementadores.ResultadoDeAnaliseNumeroCaracteres;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultadoDeAnaliseNumeroCaracteresTest {

    @Test
    void deveObterValoresZeradosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);
        var resultado = new ResultadoDeAnaliseNumeroCaracteres(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        Assertions.assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        Assertions.assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverCaracteresAbaixoDoMinimo() {
        String senha = "123456";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);
        var resultado = new ResultadoDeAnaliseNumeroCaracteres(senha, contador, calculador);

        assertEquals(6, resultado.obterContagem());
        assertEquals(24, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverCaracteresIgualAoMinimo() {
        String senha = "abc123de";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);
        var resultado = new ResultadoDeAnaliseNumeroCaracteres(senha, contador, calculador);

        assertEquals(8, resultado.obterContagem());
        assertEquals(32, resultado.obterBonus());
        assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverCaracteresAcimaDoMinimo() {
        String senha = "abc123de@#";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);
        var resultado = new ResultadoDeAnaliseNumeroCaracteres(senha, contador, calculador);

        assertEquals(10, resultado.obterContagem());
        assertEquals(40, resultado.obterBonus());
        assertEquals(TipoEstado.EXCEPCIONAL, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

}