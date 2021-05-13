package v2.decrementadores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import v2.CalculadorDeBonus;
import v2.ContadorDeOcorrencias;
import v2.TipoEstado;
import v2.incrementadores.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultadoDeAnaliseApenasNumerosTest {

    @Test
    void deveObterValoresEsperadosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = testSetup(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        Assertions.assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        Assertions.assertEquals(false, resultado.retornaTrueQuandoTipoIncrementador());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaNaoContiverApenasNumeros() {
        String senha = "!1231231239471a";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = testSetup(senha, contador, calculador);

        assertEquals(0, resultado.obterContagem());
        assertEquals(0, resultado.obterBonus());
        assertEquals(TipoEstado.SUFICIENTE, resultado.obterEstado());
        assertEquals(false, resultado.retornaTrueQuandoTipoIncrementador());
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverApenasNumeros() {
        String senha = "984234984231";
        var contador = new ContadorDeOcorrencias(senha);
        var calculador = new CalculadorDeBonus(senha);

        var resultado = testSetup(senha, contador, calculador);

        assertEquals(12, resultado.obterContagem());
        assertEquals(-12, resultado.obterBonus());
        assertEquals(TipoEstado.ALERTA, resultado.obterEstado());
        assertEquals(false, resultado.retornaTrueQuandoTipoIncrementador());
    }

    private ResultadoDeAnaliseApenasNumeros testSetup (String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        var res1 = new ResultadoDeAnaliseNumeroCaracteres(senha, contador, calculador);
        var res2 = new ResultadoDeAnaliseLetrasMaiusculas(senha, contador, calculador);
        var res3 = new ResultadoDeAnaliseLetrasMinusculas(senha, contador, calculador);
        var res4 = new ResultadoDeAnaliseNumeros(senha, contador, calculador);
        var res5 = new ResultadoDeAnaliseSimbolos(senha, contador, calculador);

        var resultado = new ResultadoDeAnaliseApenasNumeros(senha, contador, calculador);
        return resultado;
    }
}