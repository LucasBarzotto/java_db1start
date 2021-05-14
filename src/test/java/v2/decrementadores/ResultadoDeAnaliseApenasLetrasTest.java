package v2.decrementadores;
import org.junit.jupiter.api.Test;
import v2.CalculadorDeBonus;
import v2.ContadorDeOcorrencias;
import v2.TipoEstado;
import v2.incrementadores.*;

import static v2.TestadorDeSenha.testarSenha;

class ResultadoDeAnaliseApenasLetrasTest {

    @Test
    void deveObterValoresEsperadosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var resultado = testSetup(senha);
        testarSenha(resultado, 0, 0, TipoEstado.SUFICIENTE, false);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaNaoContiverApenasLetras() {
        String senha = "!oshasohasohao1";
        var resultado = testSetup(senha);
        testarSenha(resultado, 0, 0, TipoEstado.SUFICIENTE, false);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverApenasLetras() {
        String senha = "ASohASHOUHASouHSOUS";
        var resultado = testSetup(senha);
        testarSenha(resultado, 19, -19, TipoEstado.ALERTA, false);
    }

    private ResultadoDeAnaliseApenasLetras testSetup (String senha) {
        ContadorDeOcorrencias contador = new ContadorDeOcorrencias(senha);
        CalculadorDeBonus calculador = new CalculadorDeBonus(senha);
        new ResultadoDeAnaliseNumeroCaracteres(senha, contador, calculador);
        new ResultadoDeAnaliseLetrasMaiusculas(senha, contador, calculador);
        new ResultadoDeAnaliseLetrasMinusculas(senha, contador, calculador);
        new ResultadoDeAnaliseNumeros(senha, contador, calculador);
        new ResultadoDeAnaliseSimbolos(senha, contador, calculador);

        return new ResultadoDeAnaliseApenasLetras(senha, contador, calculador);
    }
}