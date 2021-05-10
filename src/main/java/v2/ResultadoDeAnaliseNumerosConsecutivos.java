package v2;

public class ResultadoDeAnaliseNumerosConsecutivos extends ResultadoDeAnalise {
    private int contagem;
    private int bonus;
    private TipoEstado estado;
    private TipoOperacao tipoOperacao;
    private ContadorDeOcorrencias contadorDeOcorrencias;
    private CalculadorDeBonus calculadorDeBonus;

    public ResultadoDeAnaliseNumerosConsecutivos(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha);
        this.tipoOperacao = TipoOperacao.DECREMENTADOR;
        this.contadorDeOcorrencias = contador;
        this.calculadorDeBonus = calculador;
        this.calcularResultado();
        this.calcularEstado();
        this.setarContagemEBonus();
    }

    private void calcularResultado() {

        int multiplicador = 2;

        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasCaracteresConsecutivosDeAcordoComRegex("[0-9]");
        this.bonus = this.calculadorDeBonus.calculadorDeBonusTipoFlat(this.contagem, multiplicador);

    }

    private void setarContagemEBonus() {
        this.contadorDeOcorrencias.setContagemNumerosConsecutivos(this.contagem);
        this.calculadorDeBonus.setBonusNumerosConsecutivos(this.bonus);
    }

    private void calcularEstado() {
        if (this.contagem == 0) {
            this.estado = TipoEstado.SUFICIENTE;
        } else {
            this.estado = TipoEstado.ALERTA;
        }
    }

    @Override
    int obterBonus() {
        if (this.tipoOperacao == TipoOperacao.INCREMENTADOR) {
            return bonus;
        } else {
            return bonus * (-1);
        }
    }

    @Override
    int obterContagem() {
        return this.contagem;
    }

    @Override
    TipoEstado obterEstado() {
        return this.estado;
    }

    @Override
    TipoOperacao obterTipoOperacao() {
        return this.tipoOperacao;
    }
}
