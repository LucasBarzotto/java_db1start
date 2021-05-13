package v2.incrementadores;
import v2.*;

public class ResultadoDeAnaliseSimbolos extends ResultadoDeAnalise {

    public ResultadoDeAnaliseSimbolos (String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        this.incrementador = true;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 6;
        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasDeAcordoComRegex("[^a-zA-Z0-9_]");
        this.bonus = this.calculadorDeBonus.calculadorDeBonusTipoFlat(this.contagem, multiplicador);
    }

    @Override
    protected void calcularEstado() {
        if (this.contagem == 0) {
            this.estado = TipoEstado.FALHA;
        } else if (this.contagem == 1) {
            this.estado = TipoEstado.SUFICIENTE;
        } else {
            this.estado = TipoEstado.EXCEPCIONAL;
        }
    }

    @Override
    protected void setarContagemEBonus() {
        this.contadorDeOcorrencias.setContagemSimbolos(this.contagem);
        this.calculadorDeBonus.setBonusSimbolos(this.bonus);
    }

}
