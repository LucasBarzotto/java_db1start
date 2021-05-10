package v2;

public class Main {

    public static void main(String[] args) {

        var verificadorDeForcaDeSenha = new VerificadorDeForcaDeSenha("Lucas123");

        System.out.println(verificadorDeForcaDeSenha.obterScore());
        System.out.println(verificadorDeForcaDeSenha.obterComplexidade());

    }

}
