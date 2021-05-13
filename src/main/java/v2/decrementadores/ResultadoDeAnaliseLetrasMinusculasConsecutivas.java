package v2.decrementadores;
import v2.*;

public class ResultadoDeAnaliseLetrasMinusculasConsecutivas extends ResultadoDeAnalise {

    public ResultadoDeAnaliseLetrasMinusculasConsecutivas(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        incrementador = false;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 2;
        contagem = contadorDeOcorrencias.contarOcorrenciasCaracteresConsecutivosDeAcordoComRegex("[a-z]");
        bonus = calculadorDeBonus.calculadorDeBonusTipoFlat(contagem, multiplicador);
    }

    @Override
    protected void calcularEstado() {
        estado = (contagem == 0) ? TipoEstado.SUFICIENTE : TipoEstado.ALERTA;
    }

    @Override
    protected void setarContagemEBonus() {
        contadorDeOcorrencias.setContagemLetrasMinusculasConsecutivas(contagem);
        calculadorDeBonus.setBonusLetrasMinusculasConsecutivas(bonus);
    }

}
