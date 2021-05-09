package v2;

public enum TamanhoMinimo {

    SENHA(8),
    REQUERIMENTOS(3);

    public final int valor;

    private TamanhoMinimo(int min) {
        this.valor = min;
    }

}
