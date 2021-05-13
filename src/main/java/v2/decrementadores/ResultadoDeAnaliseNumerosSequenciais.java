package v2.decrementadores;
import v2.*;

import static v2.Constantes.NUMEROS;

public class ResultadoDeAnaliseNumerosSequenciais extends ResultadoDeAnalise {

    public ResultadoDeAnaliseNumerosSequenciais(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        incrementador = false;
        calcularEstadoParaDecrementadores();
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 3;
        contagem = contadorDeOcorrencias.contarOcorrenciasLetrasSequenciais(NUMEROS);
        bonus = calculadorDeBonus.calculadorDeBonusTipoFlat(contagem, multiplicador);
    }
    
    @Override
    protected void setarContagemEBonus() {
        contadorDeOcorrencias.setContagemNumerosSequenciais(contagem);
        calculadorDeBonus.setBonusNumerosSequenciais(bonus);
    }

}
