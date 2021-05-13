package v2.decrementadores;
import v2.*;

public class ResultadoDeAnaliseLetrasMaiusculasConsecutivas extends ResultadoDeAnalise {

    public ResultadoDeAnaliseLetrasMaiusculasConsecutivas(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        incrementador = false;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 2;
        contagem = contadorDeOcorrencias.contarOcorrenciasCaracteresConsecutivosDeAcordoComRegex("[A-Z]");
        bonus = calculadorDeBonus.calculadorDeBonusTipoFlat(contagem, multiplicador);
    }

    @Override
    protected void calcularEstado() {
        estado = (contagem == 0) ? TipoEstado.SUFICIENTE : TipoEstado.ALERTA;
    }

    @Override
    protected void setarContagemEBonus() {
        contadorDeOcorrencias.setContagemLetrasMaiusculasConsecutivas(contagem);
        calculadorDeBonus.setBonusLetrasMaiusculasConsecutivas(bonus);
    }

}
