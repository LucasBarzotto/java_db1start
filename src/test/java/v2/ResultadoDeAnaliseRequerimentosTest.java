package v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultadoDeAnaliseRequerimentosTest {

    @Test
    void deveObterValoresZeradosQuandoTesteDeSenhaVazia() {
        String senha = "";

        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = testSetup(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaMenorQueTamanhoMinimo() {
        String senha = "A3#gacA";

        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = testSetup(senha, contador, calculador);

        assertEquals(4, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaNaoContiverRequerimentosSuficientes() {
        String senha = "AbcdeOUHShaso";

        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = testSetup(senha, contador, calculador);

        assertEquals(3, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.FALHA, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverRequerimentosSuficientes() {
        String senha = "AbcdeOUHShaso1";

        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = testSetup(senha, contador, calculador);

        assertEquals(4, resultado.obterContagem());
        assertEquals(8, resultado.obterBonus());
        assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverRequerimentosExcepcionais() {
        String senha = "Abcde#OUHShaso1";

        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = testSetup(senha, contador, calculador);

        assertEquals(5, resultado.obterContagem());
        assertEquals(10, resultado.obterBonus());
        assertEquals(TipoEstado.EXCEPCIONAL, resultado.obterEstado());
        assertEquals(TipoOperacao.INCREMENTADOR, resultado.obterTipoOperacao());
    }

    private ResultadoDeAnaliseRequerimentos testSetup (String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        var res1 = new ResultadoDeAnaliseNumeroCaracteres(senha, contador, calculador);
        var res2 = new ResultadoDeAnaliseLetrasMaiusculas(senha, contador, calculador);
        var res3 = new ResultadoDeAnaliseLetrasMinusculas(senha, contador, calculador);
        var res4 = new ResultadoDeAnaliseNumeros(senha, contador, calculador);
        var res5 = new ResultadoDeAnaliseSimbolos(senha, contador, calculador);

        var resultado = new ResultadoDeAnaliseRequerimentos(senha, contador, calculador);
        return resultado;
    }
}