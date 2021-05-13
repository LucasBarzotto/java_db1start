package v2.incrementadores;

import v2.*;

public class ResultadoDeAnaliseNumeroCaracteres extends ResultadoDeAnalise {
    private int contagem;
    private int bonus;
    private TipoEstado estado;
    private TipoOperacao tipoOperacao;
    private ContadorDeOcorrencias contadorDeOcorrencias;
    private CalculadorDeBonus calculadorDeBonus;

    public ResultadoDeAnaliseNumeroCaracteres(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha);
        this.tipoOperacao = TipoOperacao.INCREMENTADOR;
        this.contadorDeOcorrencias = contador;
        this.calculadorDeBonus = calculador;
        this.calcularResultado();
        this.calcularEstado();
        this.setarContagemEBonus();
    }

    private void calcularResultado() {

        int multiplicador = 4;

        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasNumeroDeCaracteres();
        this.bonus = this.calculadorDeBonus.calculadorDeBonusTipoFlat(this.contagem, multiplicador);

    }

    private void setarContagemEBonus() {
        this.contadorDeOcorrencias.setContagemNumeroCaracteres(this.contagem);
        this.calculadorDeBonus.setBonusNumeroCaracteres(this.bonus);
    }

    private void calcularEstado() {
        if (this.contagem < TamanhoMinimo.SENHA.valor) {
            this.estado = TipoEstado.FALHA;
        } else if (this.contagem == TamanhoMinimo.SENHA.valor) {
            this.estado = TipoEstado.SUFICIENTE;
        } else {
            this.estado = TipoEstado.EXCEPCIONAL;
        }
    }

    @Override
    public int obterBonus() {
        if (this.tipoOperacao == TipoOperacao.INCREMENTADOR) {
            return bonus;
        } else {
            return bonus * (-1);
        }
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
    public TipoOperacao obterTipoOperacao() {
        return this.tipoOperacao;
    }
}
