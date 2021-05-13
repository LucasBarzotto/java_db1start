package v2.incrementadores;
import v2.*;

public class ResultadoDeAnaliseNumeros extends ResultadoDeAnalise {

    public ResultadoDeAnaliseNumeros (String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        incrementador = true;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 4;
        contagem = contadorDeOcorrencias.contarOcorrenciasDeAcordoComRegex("[0-9]");
        bonus = calculadorDeBonus.calculadorDeBonusTipoCondicao(contagem, multiplicador);
    }

    @Override
    protected void calcularEstado() {
        if (contagem == 0) {
            estado = TipoEstado.FALHA;
        } else if (contagem == 1) {
            estado = TipoEstado.SUFICIENTE;
        } else {
            estado = TipoEstado.EXCEPCIONAL;
        }
    }

    @Override
    protected void setarContagemEBonus() {
        contadorDeOcorrencias.setContagemNumeros(contagem);
        calculadorDeBonus.setBonusNumeros(bonus);
    }

}
