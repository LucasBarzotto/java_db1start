package v2.decrementadores;
import v2.*;

public class ResultadoDeAnaliseCaracteresRepetidos extends ResultadoDeAnalise {

    public ResultadoDeAnaliseCaracteresRepetidos(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        incrementador = false;
        calcularEstadoParaDecrementadores();
    }

    @Override
    protected void calcularResultado() {
        contagem = contadorDeOcorrencias.contarOcorrenciasCaracteresRepetidos();
        bonus = calculadorDeBonus.calculadorDeBonusTipoComplexo();
    }

    @Override
    protected void setarContagemEBonus() {
        contadorDeOcorrencias.setContagemCaracteresRepetidos(contagem);
        calculadorDeBonus.setBonusCaracteresRepetidos(bonus);
    }

}
