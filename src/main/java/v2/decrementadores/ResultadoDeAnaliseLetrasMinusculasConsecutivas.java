package v2.decrementadores;
import v2.*;

public class ResultadoDeAnaliseLetrasMinusculasConsecutivas extends ResultadoDeAnalise {

    public ResultadoDeAnaliseLetrasMinusculasConsecutivas(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        incrementador = false;
        calcularEstadoParaDecrementadores();
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 2;
        contagem = contadorDeOcorrencias.contarOcorrenciasCaracteresConsecutivosDeAcordoComRegex("[a-z]");
        bonus = calculadorDeBonus.calculadorDeBonusTipoFlat(contagem, multiplicador);
    }

    @Override
    protected void setarContagemEBonus() {
        contadorDeOcorrencias.setContagemLetrasMinusculasConsecutivas(contagem);
        calculadorDeBonus.setBonusLetrasMinusculasConsecutivas(bonus);
    }

}
