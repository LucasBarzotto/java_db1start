package v2.incrementadores;
import v2.*;

public class ResultadoDeAnaliseLetrasMinusculas extends ResultadoDeAnalise {

    public ResultadoDeAnaliseLetrasMinusculas(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        incrementador = true;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 2;
        contagem = contadorDeOcorrencias.contarOcorrenciasDeAcordoComRegex("[a-z]");
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
        contadorDeOcorrencias.setContagemLetrasMinusculas(contagem);
        calculadorDeBonus.setBonusLetrasMinusculas(bonus);
    }

}
