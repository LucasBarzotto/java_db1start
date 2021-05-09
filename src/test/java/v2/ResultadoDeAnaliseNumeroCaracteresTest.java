package v2;

import org.junit.jupiter.api.Test;

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
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());        
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