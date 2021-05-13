package v2.decrementadores;
import v2.*;

public class ResultadoDeAnaliseCaracteresRepetidos extends ResultadoDeAnalise {

    public ResultadoDeAnaliseCaracteresRepetidos(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        this.incrementador = false;
    }

    @Override
    protected void calcularResultado() {
        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasCaracteresRepetidos();
        this.bonus = this.calculadorDeBonus.calculadorDeBonusTipoComplexo();
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
        this.contadorDeOcorrencias.setContagemCaracteresRepetidos(this.contagem);
        this.calculadorDeBonus.setBonusCaracteresRepetidos(this.bonus);
    }

}
