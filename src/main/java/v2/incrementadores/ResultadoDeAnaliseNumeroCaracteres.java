package v2.incrementadores;
import v2.*;

import static v2.Constantes.TAMANHO_MINIMO_SENHA;

public class ResultadoDeAnaliseNumeroCaracteres extends ResultadoDeAnalise {

    public ResultadoDeAnaliseNumeroCaracteres(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        incrementador = true;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 4;
        contagem = contadorDeOcorrencias.contarOcorrenciasNumeroDeCaracteres();
        bonus = calculadorDeBonus.calculadorDeBonusTipoFlat(contagem, multiplicador);
    }

    @Override
    protected void calcularEstado() {
        if (contagem < TAMANHO_MINIMO_SENHA) {
            estado = TipoEstado.FALHA;
        } else if (contagem == TAMANHO_MINIMO_SENHA) {
            estado = TipoEstado.SUFICIENTE;
        } else {
            estado = TipoEstado.EXCEPCIONAL;
        }
    }

    @Override
    protected void setarContagemEBonus() {
        contadorDeOcorrencias.setContagemNumeroCaracteres(contagem);
        calculadorDeBonus.setBonusNumeroCaracteres(bonus);
    }

}
