package v2.incrementadores;
import org.junit.jupiter.api.Test;
import v2.CalculadorDeBonus;
import v2.ContadorDeOcorrencias;
import v2.TipoEstado;

import static v2.TestadorDeSenha.testarSenha;

class ResultadoDeAnaliseRequerimentosTest {

    @Test
    void deveObterValoresZeradosQuandoTesteDeSenhaVazia() {
        String senha = "";
        var resultado = testSetup(senha);
        testarSenha(resultado, 0, 0, TipoEstado.FALHA, true);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaMenorQueTamanhoMinimo() {
        String senha = "A3#gacA";
        var resultado = testSetup(senha);
        testarSenha(resultado, 4, 0, TipoEstado.FALHA, true);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaNaoContiverRequerimentosSuficientes() {
        String senha = "AbcdeOUHShaso";
        var resultado = testSetup(senha);
        testarSenha(resultado, 3, 0, TipoEstado.FALHA, true);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverRequerimentosSuficientes() {
        String senha = "AbcdeOUHShaso1";
        var resultado = testSetup(senha);
        testarSenha(resultado, 4, 8, TipoEstado.SUFICIENTE, true);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaContiverRequerimentosExcepcionais() {
        String senha = "Abcde#OUHShaso1";
        var resultado = testSetup(senha);
        testarSenha(resultado, 5, 10, TipoEstado.EXCEPCIONAL, true);
    }

    private ResultadoDeAnaliseRequerimentos testSetup (String senha) {
        ContadorDeOcorrencias contador = new ContadorDeOcorrencias(senha);
        CalculadorDeBonus calculador = new CalculadorDeBonus(senha);
        new ResultadoDeAnaliseNumeroCaracteres(senha, contador, calculador);
        new ResultadoDeAnaliseLetrasMaiusculas(senha, contador, calculador);
        new ResultadoDeAnaliseLetrasMinusculas(senha, contador, calculador);
        new ResultadoDeAnaliseNumeros(senha, contador, calculador);
        new ResultadoDeAnaliseSimbolos(senha, contador, calculador);

        return new ResultadoDeAnaliseRequerimentos(senha, contador, calculador);
    }
}