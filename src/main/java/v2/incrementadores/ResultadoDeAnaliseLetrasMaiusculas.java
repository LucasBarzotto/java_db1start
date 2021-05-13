package v2.incrementadores;

import v2.*;

public class ResultadoDeAnaliseLetrasMaiusculas extends ResultadoDeAnalise {
    private int contagem;
    private int bonus;
    private TipoEstado estado;
    private boolean incrementador;
    private ContadorDeOcorrencias contadorDeOcorrencias;
    private CalculadorDeBonus calculadorDeBonus;

    public ResultadoDeAnaliseLetrasMaiusculas(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha);
        this.incrementador = true;
        this.contadorDeOcorrencias = contador;
        this.calculadorDeBonus = calculador;
        this.calcularResultado();
        this.calcularEstado();
        this.setarContagemEBonus();
    }

    private void calcularResultado() {

        int multiplicador = 2;

        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasDeAcordoComRegex("[A-Z]");
        this.bonus = this.calculadorDeBonus.calculadorDeBonusTipoCondicaoIncremento(this.contagem, multiplicador);

    }

    private void setarContagemEBonus() {
        this.contadorDeOcorrencias.setContagemLetrasMaiusculas(this.contagem);
        this.calculadorDeBonus.setBonusLetrasMaiusculas(this.bonus);
    }

    private void calcularEstado() {
        if (this.contagem == 0) {
            this.estado = TipoEstado.FALHA;
        } else if (this.contagem == 1) {
            this.estado = TipoEstado.SUFICIENTE;
        } else {
            this.estado = TipoEstado.EXCEPCIONAL;
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