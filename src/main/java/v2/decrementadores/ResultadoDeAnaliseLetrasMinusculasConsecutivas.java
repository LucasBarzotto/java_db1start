package v2.decrementadores;
import v2.*;

public class ResultadoDeAnaliseLetrasMinusculasConsecutivas extends ResultadoDeAnalise {

    public ResultadoDeAnaliseLetrasMinusculasConsecutivas(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        this.incrementador = false;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 2;
        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasCaracteresConsecutivosDeAcordoComRegex("[a-z]");
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
        this.contadorDeOcorrencias.setContagemLetrasMinusculasConsecutivas(this.contagem);
        this.calculadorDeBonus.setBonusLetrasMinusculasConsecutivas(this.bonus);
    }

}
