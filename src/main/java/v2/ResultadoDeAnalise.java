package v2;

public abstract class ResultadoDeAnalise {
    protected String senha;
    protected ContadorDeOcorrencias contadorDeOcorrencias;
    protected CalculadorDeBonus calculadorDeBonus;
    protected boolean incrementador;
    protected int contagem;
    protected int bonus;
    protected TipoEstado estado;

    public ResultadoDeAnalise(String senhaInput, ContadorDeOcorrencias contador, CalculadorDeBonus calculador) {
        senha = senhaInput;
        contadorDeOcorrencias = contador;
        calculadorDeBonus = calculador;
        calcularResultado();
        calcularEstado();
        setarContagemEBonus();
    }

    protected abstract void calcularResultado();

    protected abstract void calcularEstado();

    protected abstract void setarContagemEBonus();

    public int obterBonus() {
        return (incrementador) ? bonus : bonus*(-1);
    }

    public int obterContagem() {
        return contagem;
    }

    public TipoEstado obterEstado() {
        return estado;
    }

    public boolean retornaTrueQuandoTipoIncrementador() {
        return incrementador;
    }
}
