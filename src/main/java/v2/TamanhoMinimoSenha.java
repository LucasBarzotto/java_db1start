package v2;

public enum TamanhoMinimoSenha {

    MIN(8);

    public final int valor;

    private TamanhoMinimoSenha(int min) {
        this.valor = min;
    }

}
