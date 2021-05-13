package v2.incrementadores;
import v2.*;

import static v2.Constantes.TAMANHO_MINIMO_SENHA;

public class ResultadoDeAnaliseNumeroCaracteres extends ResultadoDeAnalise {

    public ResultadoDeAnaliseNumeroCaracteres(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        this.incrementador = true;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 4;
        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasNumeroDeCaracteres();
        this.bonus = this.calculadorDeBonus.calculadorDeBonusTipoFlat(this.contagem, multiplicador);
    }

    @Override
    protected void calcularEstado() {
        if (this.contagem < TAMANHO_MINIMO_SENHA) {
            this.estado = TipoEstado.FALHA;
        } else if (this.contagem == TAMANHO_MINIMO_SENHA) {
            this.estado = TipoEstado.SUFICIENTE;
        } else {
            this.estado = TipoEstado.EXCEPCIONAL;
        }
    }

    @Override
    protected void setarContagemEBonus() {
        this.contadorDeOcorrencias.setContagemNumeroCaracteres(this.contagem);
        this.calculadorDeBonus.setBonusNumeroCaracteres(this.bonus);
    }

}
