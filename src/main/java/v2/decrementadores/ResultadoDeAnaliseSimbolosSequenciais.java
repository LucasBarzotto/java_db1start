package v2.decrementadores;
import v2.*;

import static v2.Constantes.SIMBOLOS;

public class ResultadoDeAnaliseSimbolosSequenciais extends ResultadoDeAnalise {

    public ResultadoDeAnaliseSimbolosSequenciais(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        incrementador = false;
        calcularEstadoParaDecrementadores();
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 3;
        contagem = contadorDeOcorrencias.contarOcorrenciasLetrasSequenciais(SIMBOLOS);
        bonus = calculadorDeBonus.calculadorDeBonusTipoFlat(contagem, multiplicador);
    }

    @Override
    protected void setarContagemEBonus() {
        contadorDeOcorrencias.setContagemSimbolosSequenciais(contagem);
        calculadorDeBonus.setBonusSimbolosSequenciais(bonus);
    }

}
