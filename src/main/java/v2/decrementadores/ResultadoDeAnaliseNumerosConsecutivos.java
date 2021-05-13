package v2.decrementadores;
import v2.*;

public class ResultadoDeAnaliseNumerosConsecutivos extends ResultadoDeAnalise {

    public ResultadoDeAnaliseNumerosConsecutivos(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        incrementador = false;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 2;
        contagem = contadorDeOcorrencias.contarOcorrenciasCaracteresConsecutivosDeAcordoComRegex("[0-9]");
        bonus = calculadorDeBonus.calculadorDeBonusTipoFlat(contagem, multiplicador);
    }

    @Override
    protected void calcularEstado() {
        if (contagem == 0) {
            estado = TipoEstado.SUFICIENTE;
        } else {
            estado = TipoEstado.ALERTA;
        }
    }

    @Override
    protected void setarContagemEBonus() {
        contadorDeOcorrencias.setContagemNumerosConsecutivos(contagem);
        calculadorDeBonus.setBonusNumerosConsecutivos(bonus);
    }

}
