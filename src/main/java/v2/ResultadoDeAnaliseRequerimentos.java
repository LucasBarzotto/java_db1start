package v2;

public class ResultadoDeAnaliseRequerimentos extends ResultadoDeAnalise {
    private int contagem;
    private int bonus;
    private TipoEstado estado;
    private TipoOperacao tipoOperacao;

    public ResultadoDeAnaliseRequerimentos(String senha) {
        super(senha);
        this.tipoOperacao = TipoOperacao.INCREMENTADOR;
        this.calcularResultado(senha);
        this.calcularEstado();
    }

    private void calcularResultado(String senha) {

        var contador = new ContadorDeOcorrencias();
        this.contagem = contador.contarOcorrenciasDeRequerimentos(senha);

        if (senha.length() >= TamanhoMinimoSenha.MIN.valor && this.contagem > 3) {
            int multiplicador = 2;
            this.bonus = this.contagem * multiplicador;
        } else {
            this.bonus = 0;
        }
    }

    private void calcularEstado() {
        if (senha.length() >= TamanhoMinimoSenha.MIN.valor && this.contagem == 5) {
            this.estado = TipoEstado.EXCEPCIONAL;
        } else if (senha.length() >= TamanhoMinimoSenha.MIN.valor && this.contagem == 4) {
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
