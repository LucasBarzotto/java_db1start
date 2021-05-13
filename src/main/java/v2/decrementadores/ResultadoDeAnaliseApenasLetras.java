package v2.decrementadores;
import v2.*;

public class ResultadoDeAnaliseApenasLetras extends ResultadoDeAnalise {

    public ResultadoDeAnaliseApenasLetras(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        incrementador = false;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 1;
        contagem = contadorDeOcorrencias.contarOcorrenciasCasoHajaApenasLetras();
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
        contadorDeOcorrencias.setContagemApenasLetras(contagem);
        calculadorDeBonus.setBonusApenasLetras(bonus);
    }

}
