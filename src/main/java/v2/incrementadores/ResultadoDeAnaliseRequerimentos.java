package v2.incrementadores;
import v2.*;

import static v2.Constantes.MINIMO_REQUERIMENTOS;
import static v2.Constantes.TAMANHO_MINIMO_SENHA;

public class ResultadoDeAnaliseRequerimentos extends ResultadoDeAnalise {

    public ResultadoDeAnaliseRequerimentos (String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        incrementador = true;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 2;
        contagem = contadorDeOcorrencias.contarOcorrenciasDeRequerimentos();
        bonus = calculadorDeBonus.calculadorDeBonusTipoRequerimento(contagem, multiplicador);
    }

    @Override
    protected void calcularEstado() {
        if (senha.length() >= TAMANHO_MINIMO_SENHA && contagem == 5) {
            estado = TipoEstado.EXCEPCIONAL;
        } else if (senha.length() >= TAMANHO_MINIMO_SENHA && contagem == 4) {
            estado = TipoEstado.SUFICIENTE;
        } else {
            estado = TipoEstado.FALHA;
        }
    }

    @Override
    protected void setarContagemEBonus() {
        contadorDeOcorrencias.setContagemRequerimentos(contagem);
        calculadorDeBonus.setBonusRequerimentos(bonus);
    }

}
