package v2;

public abstract class ResultadoDeAnalise {
    protected String senha;
    protected ContadorDeOcorrencias contadorDeOcorrencias;
    protected CalculadorDeBonus calculadorDeBonus;
    protected boolean incrementador;
    protected int contagem;
    protected int bonus;
    protected TipoEstado estado;

    public ResultadoDeAnalise(String senha, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        this.senha = senha;
        this.contadorDeOcorrencias = contador;
        this.calculadorDeBonus = calculador;
        this.calcularResultado();
        this.calcularEstado();
        this.setarContagemEBonus();
    }

    protected abstract void calcularResultado();

    protected abstract void calcularEstado();

    protected abstract void setarContagemEBonus();

    public abstract int obterBonus();

    public abstract int obterContagem();

    public abstract TipoEstado obterEstado();

    public abstract boolean retornaTrueQuandoTipoIncrementador();
}
