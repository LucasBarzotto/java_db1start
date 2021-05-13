package v2.incrementadores;

import v2.*;

public class ResultadoDeAnaliseNumeros extends ResultadoDeAnalise {

    public ResultadoDeAnaliseNumeros (String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        this.incrementador = true;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 4;
        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasDeAcordoComRegex("[0-9]");
        this.bonus = this.calculadorDeBonus.calculadorDeBonusTipoCondicao(this.contagem, multiplicador);
    }

    @Override
    protected void calcularEstado() {
        if (this.contagem == 0) {
            this.estado = TipoEstado.FALHA;
        } else if (this.contagem == 1) {
            this.estado = TipoEstado.SUFICIENTE;
        } else {
            this.estado = TipoEstado.EXCEPCIONAL;
        }
    }

    @Override
    protected void setarContagemEBonus() {
        this.contadorDeOcorrencias.setContagemNumeros(this.contagem);
        this.calculadorDeBonus.setBonusNumeros(this.bonus);
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
