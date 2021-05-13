package v2.incrementadores;

import v2.*;

import static v2.Constantes.TAMANHO_MINIMO_SENHA;

public class ResultadoDeAnaliseNumeroCaracteres extends ResultadoDeAnalise {
    private int contagem;
    private int bonus;
    private TipoEstado estado;
    private boolean incrementador;
    private ContadorDeOcorrencias contadorDeOcorrencias;
    private CalculadorDeBonus calculadorDeBonus;

    public ResultadoDeAnaliseNumeroCaracteres(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha);
        this.incrementador = true;
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
        if (this.contagem < TAMANHO_MINIMO_SENHA) {
            this.estado = TipoEstado.FALHA;
        } else if (this.contagem == TAMANHO_MINIMO_SENHA) {
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
