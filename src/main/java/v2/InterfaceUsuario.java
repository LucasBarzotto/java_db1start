package v2;

import java.util.Scanner;

public class InterfaceUsuario {

    private Scanner scanner;

    public InterfaceUsuario(Scanner scan) {
        scanner = scan;
    }

    public void start() {
        System.out.println("");
        System.out.println("*** BEM VINDO(A) AO PASSWORD CHECKER DA DB1 START - O MELHOR DO BRASIL ***");
        System.out.println("");
    }

    public String obterSenhaDoUsuario() {
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        System.out.println("");
        return senha;
    }

    public void imprimirSaida(String saida) {
        System.out.println("Análise sobre a senha:");
        System.out.println("");
        System.out.println(saida);
        System.out.println("");
    }

    public boolean verificarSeRepeteOuFinaliza() {
        System.out.println("Deseja verificar outra senha? y/n");
        char resposta = scanner.nextLine().charAt(0);

        return (resposta == 'y') ? true : false;
    }
}
