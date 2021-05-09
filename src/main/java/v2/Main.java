package v2;

public class Main {

    public static void main(String[] args) {

        var verificadorDeForcaDeSenha = new VerificadorDeForcaDeSenha("Lusca123321@");

        verificadorDeForcaDeSenha.calcularScore();

        System.out.println(verificadorDeForcaDeSenha.obterScore());

    }

}
