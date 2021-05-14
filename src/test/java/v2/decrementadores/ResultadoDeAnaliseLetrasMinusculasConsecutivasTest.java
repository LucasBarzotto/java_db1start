package v2.decrementadores;
import org.junit.jupiter.api.Test;
import v2.CalculadorDeBonus;
import v2.ContadorDeOcorrencias;
import v2.TipoEstado;

import static v2.TestadorDeSenha.testarSenha;

class ResultadoDeAnaliseLetrasMinusculasConsecutivasTest {

    @Test
    void deveObterValoresEsperadosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var resultado = new ResultadoDeAnaliseLetrasMinusculasConsecutivas(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 0, 0, TipoEstado.SUFICIENTE, false);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaNaoContiverLetrasMaiusculasConsecutivas() {
        String senha = "AbCdEfG1234A5B6!@#$";
        var resultado = new ResultadoDeAnaliseLetrasMinusculasConsecutivas(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 0, 0, TipoEstado.SUFICIENTE, false);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverLetrasMinusculasConsecutivas() {
        String senha = "aabbCcCc321eee654aasdas";
        var resultado = new ResultadoDeAnaliseLetrasMinusculasConsecutivas(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 10, -20, TipoEstado.ALERTA, false);
    }

}