package v2;

public class ResultadoDeAnaliseRequerimentos extends ResultadoDeAnalise {
    private int contagem;
    private int bonus;
    private TipoEstado estado;
    private TipoOperacao tipoOperacao;
    private ContadorDeOcorrencias contadorDeOcorrencias;
    private CalculadorDeBonus calculadorDeBonus;

    public ResultadoDeAnaliseRequerimentos (String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha);
        this.tipoOperacao = TipoOperacao.INCREMENTADOR;
        this.contadorDeOcorrencias = contador;
        this.calculadorDeBonus = calculador;
        this.calcularResultado();
        this.calcularEstado();
    }

    private void calcularResultado() {

        int multiplicador = 2;

        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasDeRequerimentos();
        this.bonus = this.calculadorDeBonus.calculadorDeBonusTipoRequerimento(this.contagem, multiplicador);

    }

    private void calcularEstado() {
        if (senha.length() >= TamanhoMinimo.SENHA.valor && this.contagem == 5) {
            this.estado = TipoEstado.EXCEPCIONAL;
        } else if (senha.length() >= TamanhoMinimo.SENHA.valor && this.contagem == 4) {
            this.estado = TipoEstado.SUFICIENTE;
        } else {
            this.estado = TipoEstado.FALHA;
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
