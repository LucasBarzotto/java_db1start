package v2.decrementadores;
import v2.*;

public class ResultadoDeAnaliseApenasNumeros extends ResultadoDeAnalise {

    public ResultadoDeAnaliseApenasNumeros(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        incrementador = false;
        calcularEstadoParaDecrementadores();
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 1;
        contagem = contadorDeOcorrencias.contarOcorrenciasCasoHajaApenasNumeros();
        bonus = calculadorDeBonus.calculadorDeBonusTipoFlat(contagem, multiplicador);
    }

    @Override
    protected void setarContagemEBonus() {
        contadorDeOcorrencias.setContagemApenasNumeros(contagem);
        calculadorDeBonus.setBonusApenasNumeros(bonus);
    }

}
