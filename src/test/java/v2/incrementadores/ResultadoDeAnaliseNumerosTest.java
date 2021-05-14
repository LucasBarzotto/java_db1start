package v2.incrementadores;
import org.junit.jupiter.api.Test;
import v2.CalculadorDeBonus;
import v2.ContadorDeOcorrencias;
import v2.TipoEstado;

import static v2.TestadorDeSenha.testarSenha;

class ResultadoDeAnaliseNumerosTest {

    @Test
    void deveObterValoresZeradosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var resultado = new ResultadoDeAnaliseNumeros(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 0, 0, TipoEstado.FALHA, true);
    }

    @Test
    void deveObterValoresZeradosQuandoSenhaNaoContiverNumeros() {
        String senha = "ASUH#jsasn$";
        var resultado = new ResultadoDeAnaliseNumeros(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 0, 0, TipoEstado.FALHA, true);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverUmNumero() {
        String senha = "ASDIj2as(#";
        var resultado = new ResultadoDeAnaliseNumeros(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 1, 4, TipoEstado.SUFICIENTE, true);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverMaisQueUmNumero() {
        String senha = "A2SD3Ij2as(#";
        var resultado = new ResultadoDeAnaliseNumeros(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 3, 12, TipoEstado.EXCEPCIONAL, true);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverApenasNumeros() {
        String senha = "665165184982";
        var resultado = new ResultadoDeAnaliseNumeros(senha, new ContadorDeOcorrencias(senha), new CalculadorDeBonus(senha));
        testarSenha(resultado, 12, 0, TipoEstado.EXCEPCIONAL, true);
    }
}