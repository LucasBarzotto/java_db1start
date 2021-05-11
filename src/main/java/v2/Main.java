package v2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InterfaceUsuario ui = new InterfaceUsuario(scanner);
        boolean repetir = true;

        ui.start();

        while(repetir) {
            String senha = ui.obterSenhaDoUsuario();

            ContadorDeOcorrencias contadorDeOcorrencias = new ContadorDeOcorrencias(senha);
            CalculadorDeBonus calculadorDeBonus = new CalculadorDeBonus(senha);
            var verificadorDeForcaDeSenha = new VerificadorDeForcaDeSenha(senha, contadorDeOcorrencias, calculadorDeBonus);

            ui.imprimirSaida(verificadorDeForcaDeSenha.obterStringDeSaida());
            repetir = ui.verificarSeRepeteOuFinaliza();
        }

        scanner.close();

    }

}
