package v2.incrementadores;

import v2.*;

import static v2.Constantes.MINIMO_REQUERIMENTOS;
import static v2.Constantes.TAMANHO_MINIMO_SENHA;

public class ResultadoDeAnaliseRequerimentos extends ResultadoDeAnalise {

    public ResultadoDeAnaliseRequerimentos (String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        this.incrementador = true;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 2;
        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasDeRequerimentos();
        this.bonus = this.calculadorDeBonus.calculadorDeBonusTipoRequerimento(this.contagem, multiplicador);
    }

    @Override
    protected void calcularEstado() {
        if (senha.length() >= TAMANHO_MINIMO_SENHA && this.contagem == 5) {
            this.estado = TipoEstado.EXCEPCIONAL;
        } else if (senha.length() >= TAMANHO_MINIMO_SENHA && this.contagem == 4) {
            this.estado = TipoEstado.SUFICIENTE;
        } else {
            this.estado = TipoEstado.FALHA;
        }
    }

    @Override
    protected void setarContagemEBonus() {
        this.contadorDeOcorrencias.setContagemRequerimentos(this.contagem);
        this.calculadorDeBonus.setBonusRequerimentos(this.bonus);
    }

    @Override
    public int obterBonus() {
        return (incrementador) ? bonus : bonus*(-1);
    }

    @Override
    public int obterContagem() {
        return this.contagem;
    }

    @Override
    public TipoEstado obterEstado() {
        return this.estado;
    }

    @Override
    public boolean retornaTrueQuandoTipoIncrementador() {
        return this.incrementador;
    }
}
