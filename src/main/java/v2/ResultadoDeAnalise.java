package v2;

public abstract class ResultadoDeAnalise {
    protected String senha;

    public ResultadoDeAnalise(String senha) {
        this.senha = senha;
    }

    abstract int obterBonus();

    abstract int obterContagem();

    abstract TipoEstado obterEstado();

    abstract TipoOperacao obterTipoOperacao();
}
