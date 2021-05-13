package v2.decrementadores;
import v2.*;

public class ResultadoDeAnaliseApenasLetras extends ResultadoDeAnalise {

    public ResultadoDeAnaliseApenasLetras(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        this.incrementador = false;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 1;
        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasCasoHajaApenasLetras();
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
        this.contadorDeOcorrencias.setContagemApenasLetras(this.contagem);
        this.calculadorDeBonus.setBonusApenasLetras(this.bonus);
    }

}
