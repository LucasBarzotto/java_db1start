package v2.decrementadores;

import v2.*;

import static v2.Constantes.NUMEROS;

public class ResultadoDeAnaliseNumerosSequenciais extends ResultadoDeAnalise {

    public ResultadoDeAnaliseNumerosSequenciais(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha, contador, calculador);
        this.incrementador = false;
    }

    @Override
    protected void calcularResultado() {
        int multiplicador = 3;
        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasLetrasSequenciais(NUMEROS);
        this.bonus = this.calculadorDeBonus.calculadorDeBonusTipoFlat(this.contagem, multiplicador);
    }

    @Override
    protected void calcularEstado() {
        if (this.contagem == 0) {
            this.estado = TipoEstado.SUFICIENTE;
        } else {
            this.estado = TipoEstado.ALERTA;
        }
    }
    
    @Override
    protected void setarContagemEBonus() {
        this.contadorDeOcorrencias.setContagemNumerosSequenciais(this.contagem);
        this.calculadorDeBonus.setBonusNumerosSequenciais(this.bonus);
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
