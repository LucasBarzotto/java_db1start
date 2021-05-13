package v2.decrementadores;
import v2.*;

import static v2.Constantes.LETRAS;

public class ResultadoDeAnaliseLetrasSequenciais extends ResultadoDeAnalise {

    public ResultadoDeAnaliseLetrasSequenciais(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        incrementador = false;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 3;
        contagem = contadorDeOcorrencias.contarOcorrenciasLetrasSequenciais(LETRAS);
        bonus = calculadorDeBonus.calculadorDeBonusTipoFlat(contagem, multiplicador);
    }

    @Override
    protected void calcularEstado() {
        estado = (contagem == 0) ? TipoEstado.SUFICIENTE : TipoEstado.ALERTA;
    }

    @Override
    protected void setarContagemEBonus() {
        contadorDeOcorrencias.setContagemLetrasSequenciais(contagem);
        calculadorDeBonus.setBonusLetrasSequenciais(bonus);
    }

}
