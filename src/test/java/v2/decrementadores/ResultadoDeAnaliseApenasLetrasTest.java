package v2.decrementadores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import v2.CalculadorDeBonus;
import v2.ContadorDeOcorrencias;
import v2.TipoEstado;
import v2.TipoOperacao;
import v2.decrementadores.ResultadoDeAnaliseApenasLetras;
import v2.incrementadores.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultadoDeAnaliseApenasLetrasTest {

    @Test
    void deveObterValoresEsperadosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = testSetup(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        Assertions.assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        Assertions.assertEquals(TipoOperacao.DECREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaNaoContiverApenasLetras() {
        String senha = "!oshasohasohao1";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = testSetup(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        assertEquals(TipoOperacao.DECREMENTADOR, resultado.obterTipoOperacao());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverApenasLetras() {
        String senha = "ASohASHOUHASouHSOUS";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = testSetup(senha, contador, calculador);

        assertEquals(19, resultado.obterContagem());
        assertEquals(-19, resultado.obterBonus());
        assertEquals(TipoEstado.ALERTA, resultado.obterEstado());
        assertEquals(TipoOperacao.DECREMENTADOR, resultado.obterTipoOperacao());
    }

    private ResultadoDeAnaliseApenasLetras testSetup (String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        var res1 = new ResultadoDeAnaliseNumeroCaracteres(senha, contador, calculador);
        var res2 = new ResultadoDeAnaliseLetrasMaiusculas(senha, contador, calculador);
        var res3 = new ResultadoDeAnaliseLetrasMinusculas(senha, contador, calculador);
        var res4 = new ResultadoDeAnaliseNumeros(senha, contador, calculador);
        var res5 = new ResultadoDeAnaliseSimbolos(senha, contador, calculador);

        var resultado = new ResultadoDeAnaliseApenasLetras(senha, contador, calculador);
        return resultado;
    }
}