package v2;

public enum StringsPossiveis {

    LETRAS("abcdefghijklmnopqrstuvwxyz"),
    NUMEROS("01234567890"),
    SIMBOLOS(")!@#$%^&*()");

    public final String valor;

    private StringsPossiveis(String valor) {
        this.valor = valor;
    }

}
