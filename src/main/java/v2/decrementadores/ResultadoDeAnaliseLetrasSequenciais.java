package v2.decrementadores;
import v2.*;

import static v2.Constantes.LETRAS;

public class ResultadoDeAnaliseLetrasSequenciais extends ResultadoDeAnalise {

    public ResultadoDeAnaliseLetrasSequenciais(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        this.incrementador = false;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 3;
        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasLetrasSequenciais(LETRAS);
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
        this.contadorDeOcorrencias.setContagemLetrasSequenciais(this.contagem);
        this.calculadorDeBonus.setBonusLetrasSequenciais(this.bonus);
    }

}
