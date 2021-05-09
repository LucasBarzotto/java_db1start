package v2;

public class ResultadoDeAnaliseNumeroCaracteres extends ResultadoDeAnalise {
    private int contagem;
    private int bonus;
    private TipoEstado estado;

    public ResultadoDeAnaliseNumeroCaracteres(String senha) {
        super(senha);
        calcularResultado(senha);
        calcularEstado();
    }

    private void calcularEstado() {
        if (contagem < 8)
            estado = TipoEstado.FALHA;
        else if (contagem == 8)
            estado = TipoEstado.SUFICIENTE;
        else estado = TipoEstado.EXCELENTE;
    }

    private void calcularResultado(String senha) {
        contagem = senha.length();
        int multiplicador = 4;
        bonus = contagem * multiplicador;
    }

    @Override
    int obterBonus() {
        return bonus;
    }

    @Override
    int obterContagem() {
        return contagem;
    }

    @Override
    TipoEstado obterEstado() {
        return estado;
    }

    @Override
    TipoOperacao obterTipoOperacao() {
        return TipoOperacao.INCREMENTADOR;
    }
}
