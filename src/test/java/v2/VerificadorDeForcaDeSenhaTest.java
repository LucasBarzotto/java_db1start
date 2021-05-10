package v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VerificadorDeForcaDeSenhaTest {

    @Test
    void deveObterValoresEsperadosQuandoSenhaVazia() {
        String senha = "";
        var verificadorDeForcaDeSenha = new VerificadorDeForcaDeSenha(senha);
        int score = verificadorDeForcaDeSenha.obterScore();
        String complexidade = verificadorDeForcaDeSenha.obterComplexidade();

        assertEquals(0, score);
        assertEquals("Very Weak", complexidade);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaFraca() {
        String senha = "senha1";
        var verificadorDeForcaDeSenha = new VerificadorDeForcaDeSenha(senha);
        int score = verificadorDeForcaDeSenha.obterScore();
        String complexidade = verificadorDeForcaDeSenha.obterComplexidade();

        assertEquals(22, score);
        assertEquals("Weak", complexidade);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaMedia() {
        String senha = "Senha32";
        var verificadorDeForcaDeSenha = new VerificadorDeForcaDeSenha(senha);
        int score = verificadorDeForcaDeSenha.obterScore();
        String complexidade = verificadorDeForcaDeSenha.obterComplexidade();

        assertEquals(48, score);
        assertEquals("Good", complexidade);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaForte() {
        String senha = "Senha@32";
        var verificadorDeForcaDeSenha = new VerificadorDeForcaDeSenha(senha);
        int score = verificadorDeForcaDeSenha.obterScore();
        String complexidade = verificadorDeForcaDeSenha.obterComplexidade();

        assertEquals(74, score);
        assertEquals("Strong", complexidade);
    }

    @Test
    void deveObterValoresEsperadosQuandoSenhaMuitoForte() {
        String senha = "65@#$ASD$as345ha@32";
        var verificadorDeForcaDeSenha = new VerificadorDeForcaDeSenha(senha);
        int score = verificadorDeForcaDeSenha.obterScore();
        String complexidade = verificadorDeForcaDeSenha.obterComplexidade();

        assertEquals(100, score);
        assertEquals("Very Strong", complexidade);
    }
}