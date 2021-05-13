package v2.incrementadores;
import v2.*;

public class ResultadoDeAnaliseSimbolosENumerosNoMeio extends ResultadoDeAnalise {

    public ResultadoDeAnaliseSimbolosENumerosNoMeio(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        incrementador = true;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 2;
        contagem = contadorDeOcorrencias.contarOcorrenciasNoMeioDeAcordoComRegex("[^a-zA-Z0-9_]|[0-9]");
        bonus = calculadorDeBonus.calculadorDeBonusTipoFlat(contagem, multiplicador);
    }

    @Override
    protected void calcularEstado() {
        if (contagem == 0) {
            estado = TipoEstado.FALHA;
        } else if (contagem == 1) {
            estado = TipoEstado.SUFICIENTE;
        } else {
            estado = TipoEstado.EXCEPCIONAL;
        }
    }

    @Override
    protected void setarContagemEBonus() {
        contadorDeOcorrencias.setContagemSimbolosENumerosNoMeio(contagem);
        calculadorDeBonus.setBonusSimbolosENumerosNoMeio(bonus);
    }

}
