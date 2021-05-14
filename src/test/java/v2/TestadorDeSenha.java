package v2;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestadorDeSenha {

    public static void testarSenha(ResultadoDeAnalise tipoDeAnalise, int resultadoEsperadoContagem, int resultadoEsperadoBonus, TipoEstado tipoEstado, boolean trueCasoIncrementador) {
        assertEquals(resultadoEsperadoContagem, tipoDeAnalise.obterContagem());
        assertEquals(resultadoEsperadoBonus, tipoDeAnalise.obterBonus());
        Assertions.assertEquals(tipoEstado, tipoDeAnalise.obterEstado());
        Assertions.assertEquals(trueCasoIncrementador, tipoDeAnalise.retornaTrueQuandoTipoIncrementador());
    }
}
