package v2.incrementadores;
import v2.*;

public class ResultadoDeAnaliseSimbolos extends ResultadoDeAnalise {

    public ResultadoDeAnaliseSimbolos (String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        incrementador = true;
        calcularEstadoParaIncrementadores();
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 6;
        contagem = contadorDeOcorrencias.contarOcorrenciasDeAcordoComRegex("[^a-zA-Z0-9_]");
        bonus = calculadorDeBonus.calculadorDeBonusTipoFlat(contagem, multiplicador);
    }

    @Override
    protected void setarContagemEBonus() {
        contadorDeOcorrencias.setContagemSimbolos(contagem);
        calculadorDeBonus.setBonusSimbolos(bonus);
    }

}
