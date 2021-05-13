package v2.decrementadores;
import v2.*;

public class ResultadoDeAnaliseNumerosConsecutivos extends ResultadoDeAnalise {

    public ResultadoDeAnaliseNumerosConsecutivos(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        this.incrementador = false;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 2;
        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasCaracteresConsecutivosDeAcordoComRegex("[0-9]");
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
        this.contadorDeOcorrencias.setContagemNumerosConsecutivos(this.contagem);
        this.calculadorDeBonus.setBonusNumerosConsecutivos(this.bonus);
    }

}
