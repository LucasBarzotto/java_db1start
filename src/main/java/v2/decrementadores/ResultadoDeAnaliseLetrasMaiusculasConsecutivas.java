package v2.decrementadores;
import v2.*;

public class ResultadoDeAnaliseLetrasMaiusculasConsecutivas extends ResultadoDeAnalise {

    public ResultadoDeAnaliseLetrasMaiusculasConsecutivas(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        incrementador = false;
        calcularEstadoParaDecrementadores();
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 2;
        contagem = contadorDeOcorrencias.contarOcorrenciasCaracteresConsecutivosDeAcordoComRegex("[A-Z]");
        bonus = calculadorDeBonus.calculadorDeBonusTipoFlat(contagem, multiplicador);
    }

    @Override
    protected void setarContagemEBonus() {
        contadorDeOcorrencias.setContagemLetrasMaiusculasConsecutivas(contagem);
        calculadorDeBonus.setBonusLetrasMaiusculasConsecutivas(bonus);
    }

}
