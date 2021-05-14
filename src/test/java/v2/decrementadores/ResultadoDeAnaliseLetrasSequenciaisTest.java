package v2.decrementadores;
import org.junit.jupiter.api.Test;
import v2.CalculadorDeBonus;
import v2.ContadorDeOcorrencias;
import v2.TipoEstado;

import static v2.TestadorDeSenha.testarSenha;

class ResultadoDeAnaliseLetrasSequenciaisTest {

    @Test
    void deveObterValoresEsperadosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var resultado = new ResultadoDeAnaliseLetrasSequenciais(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 0, 0, TipoEstado.SUFICIENTE, false);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaNaoContiverLetrasSequenciais() {
        String senha = "a1b2c4a6s8eE4%";
        var resultado = new ResultadoDeAnaliseLetrasSequenciais(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 0, 0, TipoEstado.SUFICIENTE, false);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverLetrasSequenciais() {
        String senha = "abc1def3MNOPQ456";
        var resultado = new ResultadoDeAnaliseLetrasSequenciais(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 5, -15, TipoEstado.ALERTA, false);
    }

}