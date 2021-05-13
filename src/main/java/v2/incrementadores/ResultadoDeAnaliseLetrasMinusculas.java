package v2.incrementadores;

import v2.*;

public class ResultadoDeAnaliseLetrasMinusculas extends ResultadoDeAnalise {

    public ResultadoDeAnaliseLetrasMinusculas(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        this.incrementador = true;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 2;
        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasDeAcordoComRegex("[a-z]");
        this.bonus = this.calculadorDeBonus.calculadorDeBonusTipoCondicaoIncremento(this.contagem, multiplicador);
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
        this.contadorDeOcorrencias.setContagemLetrasMinusculas(this.contagem);
        this.calculadorDeBonus.setBonusLetrasMinusculas(this.bonus);
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
