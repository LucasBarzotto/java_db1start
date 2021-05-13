package v2.decrementadores;

import v2.*;

public class ResultadoDeAnaliseNumerosSequenciais extends ResultadoDeAnalise {
    private int contagem;
    private int bonus;
    private TipoEstado estado;
    private boolean incrementador;
    private ContadorDeOcorrencias contadorDeOcorrencias;
    private CalculadorDeBonus calculadorDeBonus;

    public ResultadoDeAnaliseNumerosSequenciais(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha);
        this.incrementador = false;
        this.contadorDeOcorrencias = contador;
        this.calculadorDeBonus = calculador;
        this.calcularResultado();
        this.calcularEstado();
        this.setarContagemEBonus();
    }

    private void calcularResultado() {

        int multiplicador = 3;

        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasLetrasSequenciais(StringsPossiveis.NUMEROS.valor);
        this.bonus = this.calculadorDeBonus.calculadorDeBonusTipoFlat(this.contagem, multiplicador);

    }

    private void setarContagemEBonus() {
        this.contadorDeOcorrencias.setContagemNumerosSequenciais(this.contagem);
        this.calculadorDeBonus.setBonusNumerosSequenciais(this.bonus);
    }

    private void calcularEstado() {
        if (this.contagem == 0) {
            this.estado = TipoEstado.SUFICIENTE;
        } else {
            this.estado = TipoEstado.ALERTA;
        }
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