package v2.decrementadores;
import org.junit.jupiter.api.Test;
import v2.CalculadorDeBonus;
import v2.ContadorDeOcorrencias;
import v2.TipoEstado;

import static v2.TestadorDeSenha.testarSenha;

class ResultadoDeAnaliseLetrasMaiusculasConsecutivasTest {

    @Test
    void deveObterValoresEsperadosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var resultado = new ResultadoDeAnaliseLetrasMaiusculasConsecutivas(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 0, 0, TipoEstado.SUFICIENTE, false);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaNaoContiverLetrasMaiusculasConsecutivas() {
        String senha = "AbCdEfG1234A5B6!@#$";
        var resultado = new ResultadoDeAnaliseLetrasMaiusculasConsecutivas(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 0, 0, TipoEstado.SUFICIENTE, false);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverLetrasMaiusculasConsecutivas() {
        String senha = "AaAAaBB121354CCC%@EE";
        var resultado = new ResultadoDeAnaliseLetrasMaiusculasConsecutivas(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 5, -10, TipoEstado.ALERTA, false);
    }

}