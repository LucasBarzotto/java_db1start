package v2.incrementadores;
import v2.*;

public class ResultadoDeAnaliseSimbolosENumerosNoMeio extends ResultadoDeAnalise {

    public ResultadoDeAnaliseSimbolosENumerosNoMeio(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        this.incrementador = true;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 2;
        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasNoMeioDeAcordoComRegex("[^a-zA-Z0-9_]|[0-9]");
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
        this.contadorDeOcorrencias.setContagemSimbolosENumerosNoMeio(this.contagem);
        this.calculadorDeBonus.setBonusSimbolosENumerosNoMeio(this.bonus);
    }

}
