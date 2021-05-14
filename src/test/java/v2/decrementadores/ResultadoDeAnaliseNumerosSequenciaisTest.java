package v2.decrementadores;
import org.junit.jupiter.api.Test;
import v2.CalculadorDeBonus;
import v2.ContadorDeOcorrencias;
import v2.TipoEstado;

import static v2.TestadorDeSenha.testarSenha;

class ResultadoDeAnaliseNumerosSequenciaisTest {

    @Test
    void deveObterValoresEsperadosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var resultado = new ResultadoDeAnaliseNumerosSequenciais(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 0, 0, TipoEstado.SUFICIENTE, false);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaNaoContiverNumerosSequenciais() {
        String senha = "a1b2c4a6s8eE4%";
        var resultado = new ResultadoDeAnaliseNumerosSequenciais(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 0, 0, TipoEstado.SUFICIENTE, false);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverNumerosSequenciais() {
        String senha = "45610111263123asd1789";
        var resultado = new ResultadoDeAnaliseNumerosSequenciais(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 3, -9, TipoEstado.ALERTA, false);
    }

}