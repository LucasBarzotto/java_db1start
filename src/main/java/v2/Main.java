package v2;

public class Main {

    public static void main(String[] args) {

        var verificadorDeForcaDeSenha = new VerificadorDeForcaDeSenha("Lu#3lucas");

        verificadorDeForcaDeSenha.calcularScore();

        System.out.println(verificadorDeForcaDeSenha.obterScore());

    }

}
