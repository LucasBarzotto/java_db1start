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
        setarContagemEBonus();
    }

    protected abstract void calcularResultado();

    protected void calcularEstadoParaIncrementadores() {
        if (contagem == 0) {
            estado = TipoEstado.FALHA;
        } else if (contagem == 1) {
            estado = TipoEstado.SUFICIENTE;
        } else {
            estado = TipoEstado.EXCEPCIONAL;
        }
    }

    protected void calcularEstadoParaDecrementadores() {
        estado = (contagem == 0) ? TipoEstado.SUFICIENTE : TipoEstado.ALERTA;
    }

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
