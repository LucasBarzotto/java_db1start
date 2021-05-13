package v2;

public abstract class ResultadoDeAnalise {
    protected String senha;

    public ResultadoDeAnalise(String senha) {
        this.senha = senha;
    }

    public abstract int obterBonus();

    public abstract int obterContagem();

    public abstract TipoEstado obterEstado();

    public abstract boolean retornaTrueQuandoTipoIncrementador();
}
