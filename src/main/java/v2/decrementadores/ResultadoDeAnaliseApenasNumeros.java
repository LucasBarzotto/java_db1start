package v2.decrementadores;
import v2.*;

public class ResultadoDeAnaliseApenasNumeros extends ResultadoDeAnalise {

    public ResultadoDeAnaliseApenasNumeros(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        this.incrementador = false;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 1;
        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasCasoHajaApenasNumeros();
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
        this.contadorDeOcorrencias.setContagemApenasNumeros(this.contagem);
        this.calculadorDeBonus.setBonusApenasNumeros(this.bonus);
    }

}
