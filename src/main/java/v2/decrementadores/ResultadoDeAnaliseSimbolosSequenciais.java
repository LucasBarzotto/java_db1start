package v2.decrementadores;

import v2.*;

import static v2.Constantes.SIMBOLOS;

public class ResultadoDeAnaliseSimbolosSequenciais extends ResultadoDeAnalise {
    private int contagem;
    private int bonus;
    private TipoEstado estado;
    private boolean incrementador;
    private ContadorDeOcorrencias contadorDeOcorrencias;
    private CalculadorDeBonus calculadorDeBonus;

    public ResultadoDeAnaliseSimbolosSequenciais(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
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

        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasLetrasSequenciais(SIMBOLOS);
        this.bonus = this.calculadorDeBonus.calculadorDeBonusTipoFlat(this.contagem, multiplicador);

    }

    private void setarContagemEBonus() {
        this.contadorDeOcorrencias.setContagemSimbolosSequenciais(this.contagem);
        this.calculadorDeBonus.setBonusSimbolosSequenciais(this.bonus);
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
