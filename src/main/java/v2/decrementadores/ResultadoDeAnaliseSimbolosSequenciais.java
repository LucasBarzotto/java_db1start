package v2.decrementadores;
import v2.*;

import static v2.Constantes.SIMBOLOS;

public class ResultadoDeAnaliseSimbolosSequenciais extends ResultadoDeAnalise {

    public ResultadoDeAnaliseSimbolosSequenciais(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        this.incrementador = false;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 3;
        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasLetrasSequenciais(SIMBOLOS);
        this.bonus = this.calculadorDeBonus.calculadorDeBonusTipoFlat(this.contagem, multiplicador);
    }

    @Override
    protected void calcularEstado() {
        if (this.contagem == 0) {
            this.estado = TipoEstado.SUFICIENTE;
        } else {
            this.estado = TipoEstado.ALERTA;
        }
    }

    @Override
    protected void setarContagemEBonus() {
        this.contadorDeOcorrencias.setContagemSimbolosSequenciais(this.contagem);
        this.calculadorDeBonus.setBonusSimbolosSequenciais(this.bonus);
    }

}
