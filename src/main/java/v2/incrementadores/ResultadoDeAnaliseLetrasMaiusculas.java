package v2.incrementadores;
import v2.*;

public class ResultadoDeAnaliseLetrasMaiusculas extends ResultadoDeAnalise {

    public ResultadoDeAnaliseLetrasMaiusculas(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        incrementador = true;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 2;
        contagem = contadorDeOcorrencias.contarOcorrenciasDeAcordoComRegex("[A-Z]");
        bonus = calculadorDeBonus.calculadorDeBonusTipoCondicaoIncremento(contagem, multiplicador);
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
        contadorDeOcorrencias.setContagemLetrasMaiusculas(contagem);
        calculadorDeBonus.setBonusLetrasMaiusculas(bonus);
    }

}
