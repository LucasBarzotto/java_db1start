package v2;

public class ResultadoDeAnaliseSimbolosENumerosNoMeio extends ResultadoDeAnalise {
    private int contagem;
    private int bonus;
    private TipoEstado estado;
    private TipoOperacao tipoOperacao;
    private ContadorDeOcorrencias contadorDeOcorrencias;
    private CalculadorDeBonus calculadorDeBonus;

    public ResultadoDeAnaliseSimbolosENumerosNoMeio(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        super(senha);
        this.tipoOperacao = TipoOperacao.INCREMENTADOR;
        this.contadorDeOcorrencias = contador;
        this.calculadorDeBonus = calculador;
        this.calcularResultado();
        this.calcularEstado();
    }

    private void calcularResultado() {

        int multiplicador = 2;

        this.contagem = this.contadorDeOcorrencias.contarOcorrenciasNoMeioDeAcordoComRegex("[^a-zA-Z0-9_]|[0-9]");
        this.bonus = this.calculadorDeBonus.calculadorDeBonusTipoFlat(this.contagem, multiplicador);

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
