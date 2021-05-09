package v2;

public class ResultadoDeAnaliseNumeroCaracteres extends ResultadoDeAnalise {
    private int contagem;
    private int bonus;
    private TipoEstado estado;
    private TipoOperacao tipoOperacao;

    public ResultadoDeAnaliseNumeroCaracteres(String senha) {
        super(senha);
        this.tipoOperacao = TipoOperacao.INCREMENTADOR;
        this.calcularResultado(senha);
        this.calcularEstado();
    }

    private void calcularResultado(String senha) {
        this.contagem = senha.length();

        if (this.contagem > 0) {
            int multiplicador = 4;
            this.bonus = this.contagem * multiplicador;
        } else {
            this.bonus = 0;
        }
    }

    private void calcularEstado() {
        if (this.contagem < TamanhoMinimoSenha.MIN.valor) {
            this.estado = TipoEstado.FALHA;
        } else if (this.contagem == TamanhoMinimoSenha.MIN.valor) {
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